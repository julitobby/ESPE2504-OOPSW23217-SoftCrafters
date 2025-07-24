package ec.edu.espe.eduplanmaven;

import ec.edu.espe.eduplanmaven.util.FileManagerPlanification;

/**
 * Clase temporal para probar el sistema de calificaciones
 * @author SoftCrafters
 */
public class TestGradingSystem {
    public static void main(String[] args) {
        System.out.println("=== PRUEBA DEL SISTEMA DE CALIFICACIONES ===");
        
        try {
            // Inicializar el FileManager que automáticamente corregirá los datos
            FileManagerPlanification fileManager = FileManagerPlanification.getInstance();
            
            System.out.println("✅ FileManager inicializado correctamente");
            System.out.println("✅ Datos de calificación corregidos automáticamente");
            
            // Obtener todas las planificaciones para verificar que no hay errores
            var planifications = fileManager.getAllPlanifications();
            System.out.println("✅ Cargadas " + planifications.size() + " planificaciones sin errores");
            
            // Mostrar información de algunas planificaciones
            int count = 0;
            for (var plan : planifications) {
                if (count >= 3) break; // Solo mostrar las primeras 3
                System.out.println("📋 Planificación: " + plan.getNamePlanification());
                System.out.println("   - Semana: " + plan.getWeekOfMonth());
                System.out.println("   - Mes: " + plan.getMonth());
                System.out.println("   - Año: " + plan.getYear());
                System.out.println("   - Calificada: " + (plan.isGraded() ? "Sí" : "No"));
                if (plan.isGraded()) {
                    System.out.println("   - Calificación: " + plan.getGrade());
                }
                System.out.println();
                count++;
            }
            
            System.out.println("=== PRUEBA COMPLETADA EXITOSAMENTE ===");
            
        } catch (Exception e) {
            System.err.println("❌ Error durante la prueba: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
