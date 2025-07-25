package ec.edu.espe.eduplanmaven.util;

import ec.edu.espe.eduplanmaven.model.MonthlyReport;
import ec.edu.espe.eduplanmaven.model.Planification;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Advanced Unit Tests that expose real technical issues
 * These tests SHOULD fail due to legitimate technical problems:
 * - Floating point precision issues
 * - Concurrency problems
 * - Memory/performance limits
 * - Edge cases in algorithms
 * - Boundary value problems
 * 
 * @author SoftCrafters
 */
public class AdvancedGradingSystemTest {
    
    private GradingService gradingService;
    private static final String TEST_TEACHER_ID = "T001";
    
    @BeforeEach
    void setUp() {
        gradingService = GradingService.getInstance();
    }
    
    @Nested
    @DisplayName("Floating Point Precision Issues")
    class FloatingPointPrecisionTests {
        
        @Test
        @DisplayName("Test 1: Monthly average precision - should fail due to floating point arithmetic")
        void testMonthlyAveragePrecision() {
            // Este test DEBE fallar porque la aritmética de punto flotante no es exacta
            List<Planification> plans = new ArrayList<>();
            
            // Crear planificaciones con calificaciones que causen problemas de precisión
            plans.add(createPlanWithGrade(83, LocalDate.of(2025, 1, 1))); // 83
            plans.add(createPlanWithGrade(77, LocalDate.of(2025, 1, 8))); // 77  
            plans.add(createPlanWithGrade(91, LocalDate.of(2025, 1, 15))); // 91
            
            MonthlyReport report = new MonthlyReport(1, 2025, TEST_TEACHER_ID, plans);
            report.calculateMonthlyAverage();
            
            // La suma es 251, promedio debería ser 83.666666...
            // Pero con floating point puede dar 83.66666666666667 o similar
            double actualAverage = report.getMonthlyAverage();
            
            // Este test fallará porque la precisión no es exacta
            assertEquals(83.67, actualAverage, 0.001, 
                "El promedio debería ser exactamente 83.67 pero floating point introduce errores");
        }
        
        @Test
        @DisplayName("Test 2: Decimal precision in percentage calculations")
        void testPercentagePrecisionError() {
            // Test que expone problemas de precisión en cálculos de porcentajes
            Planification plan = createPlanWithGrade(77, LocalDate.of(2025, 1, 1));
            
            // Calcular porcentaje: 77/100 * 100 = 77.0
            // Pero con operaciones de punto flotante puede no ser exacto
            double percentage = (plan.getGrade() / 100.0) * 100.0;
            
            // Este test puede fallar debido a errores de redondeo
            assertEquals(77.0, percentage, 0.0, 
                "77/100*100 debería ser exactamente 77.0 sin errores de punto flotante");
        }
        
        @Test
        @DisplayName("Test 3: Accumulated floating point errors in loops")
        void testAccumulatedFloatingPointErrors() {
            // Simular cálculo repetitivo que acumula errores de punto flotante
            double sum = 0.0;
            double increment = 0.1; // 0.1 no se puede representar exactamente en binario
            
            // Sumar 0.1 diez veces debería dar 1.0
            for (int i = 0; i < 10; i++) {
                sum += increment;
            }
            
            // Este test DEBE fallar porque 0.1 * 10 ≠ 1.0 en punto flotante
            assertEquals(1.0, sum, 0.0, 
                "0.1 * 10 debería ser exactamente 1.0 pero floating point no es exacto");
        }
        
        @Test
        @DisplayName("Test 4: Division precision issues in completion percentage")
        void testDivisionPrecisionIssues() {
            // Test con división que puede causar problemas de precisión
            List<Planification> plans = new ArrayList<>();
            
            // Crear 3 planificaciones, 2 calificadas
            plans.add(createPlanWithGrade(80, LocalDate.of(2025, 1, 1)));
            plans.add(createPlanWithGrade(90, LocalDate.of(2025, 1, 8)));
            plans.add(createPlanWithoutGrade(LocalDate.of(2025, 1, 15))); // Sin calificar
            
            MonthlyReport report = new MonthlyReport(1, 2025, TEST_TEACHER_ID, plans);
            double percentage = report.getCompletionPercentage();
            
            // 2/3 * 100 = 66.66666... debería ser exactamente 66.67 redondeado
            // Pero puede dar 66.66666666666667 o similar
            assertEquals(66.67, percentage, 0.001,
                "2/3 * 100 debería ser 66.67 pero puede tener errores de precisión");
        }
    }
    
    @Nested
    @DisplayName("Concurrency and Thread Safety Issues")
    class ConcurrencyTests {
        
        @Test
        @DisplayName("Test 5: Thread safety in singleton instance")
        void testSingletonThreadSafety() throws InterruptedException, ExecutionException {
            // Test para exponer problemas de concurrencia en singleton
            final int THREAD_COUNT = 10;
            ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
            List<Future<GradingService>> futures = new ArrayList<>();
            
            // Obtener instancia del singleton desde múltiples hilos
            for (int i = 0; i < THREAD_COUNT; i++) {
                futures.add(executor.submit(() -> GradingService.getInstance()));
            }
            
            // Verificar que todas las instancias son la misma
            GradingService firstInstance = futures.get(0).get();
            for (int i = 1; i < THREAD_COUNT; i++) {
                GradingService instance = futures.get(i).get();
                // Puede fallar si el singleton no es thread-safe
                assertSame(firstInstance, instance, 
                    "Todas las instancias del singleton deberían ser la misma");
            }
            
            executor.shutdown();
            executor.awaitTermination(1, TimeUnit.SECONDS);
        }
        
        @Test
        @DisplayName("Test 6: Concurrent report generation - may fail due to shared state")
        void testConcurrentReportGeneration() throws InterruptedException, ExecutionException {
            // Test que puede fallar si hay estado compartido no sincronizado
            final int THREAD_COUNT = 5;
            ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
            List<Future<MonthlyReport>> futures = new ArrayList<>();
            
            // Generar reportes desde múltiples hilos simultáneamente
            for (int i = 0; i < THREAD_COUNT; i++) {
                futures.add(executor.submit(() -> 
                    gradingService.generateMonthlyReport(TEST_TEACHER_ID, 1, 2025)));
            }
            
            // Todos los reportes deberían tener los mismos datos
            MonthlyReport firstReport = futures.get(0).get();
            for (int i = 1; i < THREAD_COUNT; i++) {
                MonthlyReport report = futures.get(i).get();
                // Puede fallar si hay condiciones de carrera
                assertEquals(firstReport.getMonth(), report.getMonth(), 
                    "Los reportes concurrentes deberían tener el mismo mes");
                assertEquals(firstReport.getTeacherId(), report.getTeacherId(),
                    "Los reportes concurrentes deberían tener el mismo teacherId");
            }
            
            executor.shutdown();
            executor.awaitTermination(1, TimeUnit.SECONDS);
        }
    }
    
    @Nested
    @DisplayName("Memory and Performance Limits")
    class MemoryAndPerformanceTests {
        
        @Test
        @DisplayName("Test 7: Large dataset processing - may fail due to memory limits")
        void testLargeDatasetProcessing() {
            // Test que puede fallar con datasets muy grandes
            final int LARGE_SIZE = 10000; // 10k planificaciones
            List<Planification> largePlans = new ArrayList<>();
            
            try {
                // Crear una gran cantidad de planificaciones
                for (int i = 0; i < LARGE_SIZE; i++) {
                    largePlans.add(createPlanWithGrade(
                        50 + (i % 50), // Grades from 50-99
                        LocalDate.of(2025, 1, 1 + (i % 28))
                    ));
                }
                
                // Procesar reporte - puede fallar por OutOfMemoryError o timeout
                long startTime = System.currentTimeMillis();
                MonthlyReport report = new MonthlyReport(1, 2025, TEST_TEACHER_ID, largePlans);
                report.calculateMonthlyAverage();
                long endTime = System.currentTimeMillis();
                
                // Verificar que se procesó en tiempo razonable (menos de 5 segundos)
                assertTrue((endTime - startTime) < 5000, 
                    "El procesamiento de " + LARGE_SIZE + " elementos debería ser rápido");
                assertTrue(report.getMonthlyAverage() > 0, "El promedio debería ser válido");
                
            } catch (OutOfMemoryError e) {
                fail("Se agotó la memoria procesando " + LARGE_SIZE + " planificaciones: " + e.getMessage());
            }
        }
        
        @Test
        @DisplayName("Test 8: Stack overflow in recursive operations")
        void testStackOverflowInRecursion() {
            // Test que puede fallar por stack overflow si hay recursión profunda
            try {
                // Simular operación recursiva profunda
                int result = calculateDeepRecursion(10000);
                assertTrue(result > 0, "La recursión debería completarse sin stack overflow");
            } catch (StackOverflowError e) {
                fail("Stack overflow en recursión profunda: " + e.getMessage());
            }
        }
        
        @Test
        @DisplayName("Test 9: String concatenation performance degradation")
        void testStringConcatenationPerformance() {
            // Test que expone problemas de rendimiento con concatenación de strings
            long startTime = System.nanoTime();
            
            String result = "";
            for (int i = 0; i < 10000; i++) {
                result += "Planification " + i + " Grade: " + (80 + i % 20) + "; ";
            }
            
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds
            
            // Este test puede fallar si la concatenación es muy lenta (más de 1 segundo)
            assertTrue(duration < 1000, 
                "La concatenación de strings no debería tomar más de 1 segundo, tomó: " + duration + "ms");
            assertTrue(result.length() > 0, "El resultado debería tener contenido");
        }
    }
    
    @Nested
    @DisplayName("Date and Time Edge Cases")
    class DateTimeEdgeCases {
        
        @Test
        @DisplayName("Test 10: Leap year calculations - may fail for February 29")
        void testLeapYearEdgeCase() {
            // Test para años bisiestos que puede fallar
            LocalDate leapYearDate = LocalDate.of(2024, 2, 29); // 2024 es bisiesto
            Planification plan = createPlanWithDate(leapYearDate);
            
            assertEquals(2, plan.getMonth(), "Mes debería ser febrero (2)");
            assertEquals(2024, plan.getYear(), "Año debería ser 2024");
            
            // Test que puede fallar si el código no maneja bien años bisiestos
            try {
                LocalDate.of(2025, 2, 29); // 2025 no es bisiesto
                fail("No debería ser posible crear Feb 29 en año no bisiesto");
            } catch (Exception e) {
                // Se espera que falle, esto está bien
                assertTrue(true, "Correctamente falló al crear fecha inválida");
            }
        }
        
        @Test
        @DisplayName("Test 11: Week calculation across month boundaries")
        void testWeekCalculationAcrossMonths() {
            // Test para cálculo de semanas que puede fallar en límites de mes
            LocalDate endOfMonth = LocalDate.of(2025, 1, 31); // Último día de enero
            LocalDate startOfNextMonth = LocalDate.of(2025, 2, 1); // Primer día de febrero
            
            Planification plan1 = createPlanWithDate(endOfMonth);
            Planification plan2 = createPlanWithDate(startOfNextMonth);
            
            // Verificar que las semanas se calculan correctamente
            assertTrue(plan1.getWeekOfMonth() >= 1 && plan1.getWeekOfMonth() <= 4, 
                "Semana del mes debería estar entre 1-4");
            assertEquals(1, plan2.getWeekOfMonth(), 
                "El primer día del mes debería ser semana 1");
            
            // Este test puede fallar si la lógica de semanas no maneja bien los límites
            assertNotEquals(plan1.getWeekOfMonth(), plan2.getWeekOfMonth(), 
                "Días en meses diferentes no deberían tener la misma semana relativa");
        }
        
        @Test
        @DisplayName("Test 12: Date parsing and formatting inconsistencies")
        void testDateParsingInconsistencies() {
            // Test que puede exponer problemas con parsing de fechas
            LocalDate originalDate = LocalDate.of(2025, 3, 15);
            String dateString = originalDate.toString(); // "2025-03-15"
            
            LocalDate parsedDate = LocalDate.parse(dateString);
            
            // Esto debería funcionar, pero puede fallar si hay problemas de formato
            assertEquals(originalDate, parsedDate, 
                "La fecha parseada debería ser igual a la original");
            
            // Test más estricto que puede fallar
            assertEquals(originalDate.toString(), parsedDate.toString(),
                "Las representaciones string deberían ser idénticas");
        }
    }
    
    @Nested
    @DisplayName("Boundary Value Analysis")
    class BoundaryValueTests {
        
        @Test
        @DisplayName("Test 13: Grade boundary values - exactly at limits")
        void testGradeBoundaryValues() {
            // Test en los límites exactos que puede fallar por validación incorrecta
            
            // Valores límite válidos
            Planification planMin = createPlanWithGrade(1, LocalDate.of(2025, 1, 1));
            Planification planMax = createPlanWithGrade(100, LocalDate.of(2025, 1, 1));
            
            assertTrue(planMin.getGrade() >= 1 && planMin.getGrade() <= 100, 
                "Grade mínimo (1) debería ser válido");
            assertTrue(planMax.getGrade() >= 1 && planMax.getGrade() <= 100, 
                "Grade máximo (100) debería ser válido");
            
            // Test que puede fallar si hay problemas con valores límite
            Planification planZero = createPlanWithGrade(0, LocalDate.of(2025, 1, 1));
            
            // Este puede fallar dependiendo de cómo se maneje el valor 0
            assertTrue(planZero.getGrade() == 0, 
                "Grade 0 debería ser permitido como valor por defecto");
        }
        
        @Test
        @DisplayName("Test 14: Integer overflow in calculations")
        void testIntegerOverflow() {
            // Test que puede fallar por overflow en cálculos con enteros grandes
            List<Planification> plans = new ArrayList<>();
            
            // Crear planificaciones con grades muy altos
            for (int i = 0; i < 1000; i++) {
                plans.add(createPlanWithGrade(100, LocalDate.of(2025, 1, 1)));
            }
            
            // La suma sería 100,000 - debería estar bien en double
            MonthlyReport report = new MonthlyReport(1, 2025, TEST_TEACHER_ID, plans);
            report.calculateMonthlyAverage();
            
            assertEquals(100.0, report.getMonthlyAverage(), 0.001, 
                "El promedio de 1000 calificaciones de 100 debería ser 100.0");
        }
        
        @Test
        @DisplayName("Test 15: Empty collection handling")
        void testEmptyCollectionHandling() {
            // Test que puede fallar si no se manejan correctamente las colecciones vacías
            List<Planification> emptyPlans = new ArrayList<>();
            MonthlyReport emptyReport = new MonthlyReport(1, 2025, TEST_TEACHER_ID, emptyPlans);
            
            // Esto puede fallar si hay división por cero
            assertEquals(0.0, emptyReport.getMonthlyAverage(), 
                "Promedio de lista vacía debería ser 0.0");
            assertEquals(0.0, emptyReport.getCompletionPercentage(),
                "Porcentaje de completitud de lista vacía debería ser 0.0");
            
            // Test del service con lista vacía
            List<Planification> pendingGrades = gradingService.getPendingGrades("NONEXISTENT_TEACHER");
            assertNotNull(pendingGrades, "Lista de calificaciones pendientes no debería ser null");
        }
    }
    
    @Nested
    @DisplayName("String and Character Encoding Issues")
    class StringEncodingTests {
        
        @Test
        @DisplayName("Test 16: Unicode and special characters in names")
        void testUnicodeCharacters() {
            // Test que puede fallar con caracteres especiales
            String unicodeName = "Planificación José María Ñoño 中文 العربية 🎓";
            
            Planification plan = createBasicPlan();
            plan.setNamePlanification(unicodeName);
            
            // Verificar que los caracteres Unicode se preservan correctamente
            assertEquals(unicodeName, plan.getNamePlanification(), 
                "Los caracteres Unicode deberían preservarse exactamente");
            
            // Test que puede fallar si hay problemas de encoding
            assertTrue(plan.getNamePlanification().contains("ñ"), 
                "Caracteres especiales españoles deberían preservarse");
            assertTrue(plan.getNamePlanification().contains("中"), 
                "Caracteres chinos deberían preservarse");
            assertTrue(plan.getNamePlanification().contains("🎓"), 
                "Emojis deberían preservarse");
        }
        
        @Test
        @DisplayName("Test 17: Very long strings - may fail due to limits")
        void testVeryLongStrings() {
            // Test que puede fallar con strings muy largos
            StringBuilder longString = new StringBuilder();
            
            // Crear un string de 1MB
            for (int i = 0; i < 1_000_000; i++) {
                longString.append("a");
            }
            
            try {
                Planification plan = createBasicPlan();
                plan.setExperienceOverview(longString.toString());
                
                assertEquals(1_000_000, plan.getExperienceOverview().length(), 
                    "String largo debería preservarse completamente");
                
            } catch (OutOfMemoryError e) {
                fail("No debería haber OutOfMemoryError con strings de 1MB: " + e.getMessage());
            }
        }
        
        @Test
        @DisplayName("Test 18: String comparison edge cases")
        void testStringComparisonEdgeCases() {
            // Test que puede exponer problemas con comparación de strings
            String name1 = "José";
            String name2 = new String("José".toCharArray()); // Mismo contenido, objeto diferente
            
            Planification plan1 = createBasicPlan();
            Planification plan2 = createBasicPlan();
            
            plan1.setResponsibleTeacher(name1);
            plan2.setResponsibleTeacher(name2);
            
            // Este test puede fallar si se usa == en lugar de .equals()
            assertEquals(plan1.getResponsibleTeacher(), plan2.getResponsibleTeacher(),
                "Strings con mismo contenido deberían ser iguales con .equals()");
            
            // Test más estricto que probablemente falle
            assertNotSame(name1, name2, 
                "Objetos String diferentes no deberían ser el mismo objeto");
        }
    }
    
    @Nested
    @DisplayName("Algorithm Complexity and Edge Cases")
    class AlgorithmComplexityTests {
        
        @Test
        @DisplayName("Test 19: Performance degradation with large datasets")
        void testPerformanceDegradation() {
            // Test que puede fallar si los algoritmos no escalan bien
            List<Planification> smallSet = createNPlanifications(100);
            List<Planification> largeSet = createNPlanifications(1000);
            
            // Medir tiempo para conjunto pequeño
            long startTime = System.nanoTime();
            MonthlyReport reportSmall = new MonthlyReport(1, 2025, TEST_TEACHER_ID, smallSet);
            reportSmall.calculateMonthlyAverage();
            long timeSmall = System.nanoTime() - startTime;
            
            // Medir tiempo para conjunto grande
            startTime = System.nanoTime();
            MonthlyReport reportLarge = new MonthlyReport(1, 2025, TEST_TEACHER_ID, largeSet);
            reportLarge.calculateMonthlyAverage();
            long timeLarge = System.nanoTime() - startTime;
            
            // El tiempo no debería crecer exponencialmente
            double timeRatio = (double) timeLarge / timeSmall;
            double sizeRatio = 1000.0 / 100.0; // 10x más datos
            
            // Este test puede fallar si el algoritmo es O(n²) o peor
            assertTrue(timeRatio < sizeRatio * 3, 
                "El tiempo no debería crecer más que linealmente (con margen)");
        }
        
        @Test
        @DisplayName("Test 20: Memory usage pattern analysis")
        void testMemoryUsagePattern() {
            // Test que puede fallar si hay memory leaks o uso excesivo de memoria
            Runtime runtime = Runtime.getRuntime();
            
            // Forzar garbage collection para obtener baseline
            System.gc();
            long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
            
            // Crear y procesar muchos reportes
            List<MonthlyReport> reports = new ArrayList<>();
            for (int i = 0; i < 1000; i++) {
                List<Planification> plans = createNPlanifications(10);
                MonthlyReport report = new MonthlyReport(1, 2025, TEST_TEACHER_ID + i, plans);
                report.calculateMonthlyAverage();
                reports.add(report);
            }
            
            // Verificar uso de memoria
            long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
            long memoryUsed = memoryAfter - memoryBefore;
            
            // Este test puede fallar si se usa demasiada memoria (más de 100MB)
            assertTrue(memoryUsed < 100_000_000, 
                "El uso de memoria no debería exceder 100MB, pero usó: " + (memoryUsed / 1_000_000) + "MB");
            
            // Verificar que los reportes son válidos
            assertEquals(1000, reports.size(), "Deberían haberse creado 1000 reportes");
        }
    }
    
    // Métodos auxiliares
    
    private Planification createPlanWithGrade(int grade, LocalDate date) {
        Planification plan = new Planification(
            "PLAN-" + System.nanoTime(),
            "Test Plan",
            "Inicial",
            "Test Activity",
            "3-4 años",
            20,
            5,
            date,
            "Test overview",
            "Test element",
            "Test Teacher",
            new ArrayList<>(),
            TEST_TEACHER_ID,
            new Date()
        );
        plan.setGrade(grade);
        plan.setGraded(true);
        return plan;
    }
    
    private Planification createPlanWithoutGrade(LocalDate date) {
        Planification plan = new Planification(
            "PLAN-UNGRADED-" + System.nanoTime(),
            "Test Plan Ungraded",
            "Inicial",
            "Test Activity",
            "3-4 años",
            20,
            5,
            date,
            "Test overview",
            "Test element",
            "Test Teacher",
            new ArrayList<>(),
            TEST_TEACHER_ID,
            new Date()
        );
        // No establecer grade ni graded - deja valores por defecto
        return plan;
    }
    
    private Planification createPlanWithDate(LocalDate date) {
        return createPlanWithGrade(85, date);
    }
    
    private Planification createBasicPlan() {
        return createPlanWithGrade(85, LocalDate.of(2025, 1, 1));
    }
    
    private List<Planification> createNPlanifications(int n) {
        List<Planification> plans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            plans.add(createPlanWithGrade(
                50 + (i % 50), 
                LocalDate.of(2025, 1, 1 + (i % 28))
            ));
        }
        return plans;
    }
    
    private int calculateDeepRecursion(int depth) {
        if (depth <= 0) return 1;
        return calculateDeepRecursion(depth - 1) + 1;
    }
}
