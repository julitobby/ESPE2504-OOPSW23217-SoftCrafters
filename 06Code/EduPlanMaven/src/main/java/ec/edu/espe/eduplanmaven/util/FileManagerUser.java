package ec.edu.espe.eduplanmaven.util;

import com.mongodb.client.MongoCollection;
import ec.edu.espe.eduplanmaven.controller.FrmLoginController;
import ec.edu.espe.eduplanmaven.controller.FrmMenuPrincipalController;
import ec.edu.espe.eduplanmaven.controller.FrmMenuTeacherController;
import ec.edu.espe.eduplanmaven.model.User;
import ec.edu.espe.eduplanmaven.view.FrmLogin;
import ec.edu.espe.eduplanmaven.view.FrmMenuPrincipal;
import ec.edu.espe.eduplanmaven.view.FrmMenuTeacher;
import ec.edu.espe.eduplanmaven.view.FrmRegister;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import org.bson.Document;

public class FileManagerUser {

    private static FileManagerUser instance;
    private final MongoCollection<Document> collection;
    private int intentosRestantes = 3;
    private boolean bloqueado = false;
    private User currentLoggedUser = null;

    private FileManagerUser() {
        collection = MongoClientConnection.getInstance().getDatabase().getCollection("users");
    }

    public static synchronized FileManagerUser getInstance() {
        if (instance == null) {
            instance = new FileManagerUser();
        }
        return instance;
    }

    //METHODS FROM REGISTER
    public boolean registerUser(User user) {
        Document query = new Document("userName", user.getUsername());
        Document existingUser = collection.find(query).first();

        if (existingUser != null) {
            JOptionPane.showMessageDialog(null, "Usuario ya existente", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false; // No se registró
        } else {
            Document object = new Document("id", user.getId())
                    .append("firstName", user.getFirstName())
                    .append("lastName", user.getLastName())
                    .append("userName", user.getUsername())
                    .append("password", user.getPassword())
                    .append("rol", user.getRol());

            try {
                collection.insertOne(object);
                JOptionPane.showMessageDialog(null, "Usuario registrado con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
                return true; // Registro exitoso
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al registrar usuario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
    }

    public void clearRegister() {
        FrmRegister.getInstance().getShowID().setText("");
        FrmRegister.getInstance().getTxtName().setText("");
        FrmRegister.getInstance().getTxtLastName().setText("");
        FrmRegister.getInstance().getTxtUser().setText("");
        FrmRegister.getInstance().getPwdPassword().setText("");
    }

    public void checkRegister() {

        if (FrmRegister.getInstance().getShowID().getText().equals("")
                || FrmRegister.getInstance().getTxtName().getText().equals("")
                || FrmRegister.getInstance().getTxtLastName().getText().equals("")
                || FrmRegister.getInstance().getTxtUser().getText().equals("")
                || FrmRegister.getInstance().getPwdPassword().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor complete todos los campos.", "Campos Vacios!!", JOptionPane.WARNING_MESSAGE);
        } else {
            String id = FrmRegister.getInstance().getShowID().getText();
            String firstName = FrmRegister.getInstance().getTxtName().getText();
            String lastName = FrmRegister.getInstance().getTxtLastName().getText();
            String username = FrmRegister.getInstance().getTxtUser().getText();
            String password = FrmRegister.getInstance().getPwdPassword().getText();
            String rol = FrmRegister.getInstance().getCmbRol().getSelectedItem().toString();

            int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea registrarse?", "Confirmar registro", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                User user = new User(id, firstName, lastName, username, password, rol);
                boolean registrado = FileManagerUser.getInstance().registerUser(user);

                if (registrado) {
                    if ("Maestro".equalsIgnoreCase(rol)) {
                        FrmMenuTeacher.getInstance().getShowTitleNameTeacher().setText(user.getLastName() + " " + user.getFirstName());
                        FrmMenuTeacherController.getInstance().showLMenuTeacher();
                        FrmRegister.getInstance().setVisible(false);
                    } else if ("Director".equalsIgnoreCase(rol)) {
                        FrmMenuPrincipal.getInstance().getShowTitleNamePrincipal().setText(user.getLastName() + " " + user.getFirstName());
                        FrmMenuPrincipalController.getInstance().showLMenuPrincipal();
                        FrmRegister.getInstance().setVisible(false);
                    }
                    clearRegister();
                } else {
                    clearRegister();
                }
            } else {
                clearRegister();
            }
        }
    }

    //METHODS FROM LOGIN
    public void loginUser(String username, String password) {
        if (bloqueado) {
            JOptionPane.showMessageDialog(null, "Sistema bloqueado. Espere unos segundos.", "Bloqueado", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Document query = new Document("userName", username);
        Document userDoc = collection.find(query).first();

        if (userDoc == null) {
            intentosRestantes--;
            verificarIntentos();
            JOptionPane.showMessageDialog(null, "Usuario no encontrado. Intentos restantes: " + intentosRestantes, "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String storedPassword = userDoc.getString("password");
            String rol = userDoc.getString("rol");

            if (storedPassword.equals(password)) {
                JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso", "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
                intentosRestantes = 3;
                bloqueado = false;

                // Crear objeto User con los datos del usuario logueado
                currentLoggedUser = new User(
                    userDoc.getString("id"),
                    userDoc.getString("firstName"),
                    userDoc.getString("lastName"),
                    userDoc.getString("userName"),
                    userDoc.getString("password"),
                    userDoc.getString("rol")
                );

                if ("Maestro".equalsIgnoreCase(rol)) {
                    FrmMenuTeacher.getInstance().getShowTitleNameTeacher().setText(userDoc.getString("lastName") + " " + userDoc.getString("firstName"));
                    FrmMenuTeacherController.getInstance().showLMenuTeacher();
                    FrmLogin.getInstance().setVisible(false);
                } else if ("Director".equalsIgnoreCase(rol)) {
                    FrmMenuPrincipal.getInstance().getShowTitleNamePrincipal().setText(userDoc.getString("lastName") + " " + userDoc.getString("firstName"));
                    FrmMenuPrincipalController.getInstance().showLMenuPrincipal();
                    FrmLogin.getInstance().setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Rol no reconocido: " + rol, "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                intentosRestantes--;
                verificarIntentos();
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta. Intentos restantes: " + intentosRestantes, "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }

        // 🔽 Limpieza al final del método
        FrmLogin.getInstance().getTxtUser().setText("");
        FrmLogin.getInstance().getPwdPassword().setText("");
    }

    private void verificarIntentos() {
        if (intentosRestantes <= 0) {
            bloqueado = true;
            new Thread(() -> {
                JDialog dialogo = new JDialog();
                dialogo.setAlwaysOnTop(true);
                dialogo.setLocationRelativeTo(null);
                dialogo.setTitle("Demasiados intentos");
                dialogo.setSize(300, 100);
                dialogo.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

                JLabel label = new JLabel("Espere 60 segundos...", SwingConstants.CENTER);
                dialogo.add(label);
                dialogo.setVisible(true);

                for (int i = 60; i > 0; i--) {
                    final int segundos = i;
                    SwingUtilities.invokeLater(() -> label.setText("Sistema bloqueado. Intente en " + segundos + " segundos..."));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                dialogo.dispose();
                intentosRestantes = 3;
                bloqueado = false;
            }).start();
        }
    }

    public User findTeacherByLastName(String lastName) {
        Document query = new Document("lastName", lastName)
                .append("rol", "Maestro");

        Document teacherDoc = collection.find(query).first();

        return new User(
                teacherDoc.getString("id"),
                teacherDoc.getString("firstName"),
                teacherDoc.getString("lastName"),
                teacherDoc.getString("userName"),
                teacherDoc.getString("password"),
                teacherDoc.getString("rol")
        );

    }

    // Método para obtener el usuario logueado actualmente
    public User getCurrentLoggedUser() {
        return currentLoggedUser;
    }

    // Método para limpiar la sesión
    public void logout() {
        currentLoggedUser = null;
    }

}
