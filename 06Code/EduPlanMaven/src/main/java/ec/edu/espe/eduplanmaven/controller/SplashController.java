package ec.edu.espe.eduplanmaven.controller;

import ec.edu.espe.eduplanmaven.util.MongoClientConnection;
import ec.edu.espe.eduplanmaven.view.SplashWindow;
import javax.swing.SwingWorker;
import javax.swing.Timer;

/**
 * Controlador para manejar la lógica de la ventana splash
 * incluyendo la conexión a la base de datos y el progreso
 * 
 * @author SoftCrafters ESPE
 */
public class SplashController {
    
    private SplashWindow splashWindow;
    
    public SplashController(SplashWindow splashWindow) {
        this.splashWindow = splashWindow;
    }
    
    /**
     * Inicia el proceso de conexión a la base de datos con barra de progreso
     */
    public void startDatabaseConnection() {
        // Inicializar la barra de progreso
        splashWindow.getPgrLoadConection().setValue(0);
        splashWindow.getPgrLoadConection().setStringPainted(true);
        splashWindow.getPgrLoadConection().setString("Iniciando conexión...");
        
        // Crear un SwingWorker para manejar la conexión en segundo plano
        SwingWorker<Boolean, Integer> connectionWorker = new SwingWorker<Boolean, Integer>() {
            
            @Override
            protected Boolean doInBackground() throws Exception {
                try {
                    // Simular el progreso de conexión
                    publish(10);
                    Thread.sleep(200);
                    
                    publish(25);
                    Thread.sleep(300);
                    
                    publish(40);
                    Thread.sleep(200);
                    
                    // Realizar la conexión real a la base de datos
                    publish(60);
                    MongoClientConnection.getInstance();
                    
                    publish(80);
                    Thread.sleep(300);
                    
                    publish(95);
                    Thread.sleep(200);
                    
                    publish(100);
                    Thread.sleep(500);
                    
                    return true;
                    
                } catch (Exception e) {
                    System.err.println("Error al conectar con la base de datos: " + e.getMessage());
                    return false;
                }
            }
            
            @Override
            protected void process(java.util.List<Integer> chunks) {
                // Actualizar la barra de progreso en el hilo de la interfaz
                for (Integer progress : chunks) {
                    splashWindow.getPgrLoadConection().setValue(progress);
                    updateProgressText(progress);
                }
            }
            
            @Override
            protected void done() {
                try {
                    Boolean result = get();
                    if (result) {
                        splashWindow.getPgrLoadConection().setString("Conexión completada");
                        // Abrir FrmMainMenu y cerrar splash inmediatamente
                        openMainMenuAndCloseSplash();
                    } else {
                        splashWindow.getPgrLoadConection().setString("Error en la conexión");
                        // En caso de error, cerrar después de mostrar el mensaje
                        Timer closeTimer = new Timer(2000, event -> {
                            splashWindow.dispose();
                        });
                        closeTimer.setRepeats(false);
                        closeTimer.start();
                    }
                } catch (Exception e) {
                    System.err.println("Error en el proceso de conexión: " + e.getMessage());
                    splashWindow.getPgrLoadConection().setString("Error inesperado");
                    // En caso de error inesperado, cerrar después de un momento
                    Timer closeTimer = new Timer(2000, event -> {
                        splashWindow.dispose();
                    });
                    closeTimer.setRepeats(false);
                    closeTimer.start();
                }
            }
        };
        
        // Ejecutar el worker
        connectionWorker.execute();
    }
    
    /**
     * Actualiza el texto de la barra de progreso según el porcentaje
     * @param progress Porcentaje de progreso (0-100)
     */
    private void updateProgressText(int progress) {
        String message;
        
        if (progress <= 20) {
            message = "Iniciando conexión...";
        } else if (progress <= 40) {
            message = "Configurando parámetros...";
        } else if (progress <= 60) {
            message = "Conectando a MongoDB...";
        } else if (progress <= 80) {
            message = "Verificando conexión...";
        } else if (progress < 100) {
            message = "Finalizando...";
        } else {
            message = "Conexión completada";
        }
        
        splashWindow.getPgrLoadConection().setString(message + " " + progress + "%");
    }
    
    /**
     * Abre el menú principal y cierra la ventana splash
     */
    private void openMainMenuAndCloseSplash() {
        // Crear y mostrar el menú principal usando el patrón Singleton
        java.awt.EventQueue.invokeLater(() -> {
            try {
                ec.edu.espe.eduplanmaven.view.FrmMainMenu.getInstance().setVisible(true);
                // Cerrar la ventana splash inmediatamente después
                splashWindow.dispose();
            } catch (Exception e) {
                System.err.println("Error al abrir el menú principal: " + e.getMessage());
                // Si hay error, cerrar el splash de todas formas
                splashWindow.dispose();
            }
        });
    }
}
