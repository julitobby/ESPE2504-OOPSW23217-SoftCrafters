package ec.edu.espe.eduplanmaven.util;

import ec.edu.espe.eduplanmaven.model.MonthlyReport;
import ec.edu.espe.eduplanmaven.model.Planification;
import ec.edu.espe.eduplanmaven.model.Scope;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Comprehensive Unit Tests for EduPlan Grading System (20 Tests)
 * Tests cover Planification model, FileManagerPlanification, and GradingService
 * @author SoftCrafters
 */
public class EduPlanGradingSystemTest {
    
    private GradingService gradingService;
    private List<Planification> testPlanifications;
    private Planification samplePlanification;
    private static final String TEST_TEACHER_ID = "T001";
    
    @BeforeEach
    void setUp() {
        gradingService = GradingService.getInstance();
        testPlanifications = createTestPlanifications();
        samplePlanification = createSamplePlanification();
    }
    
    /**
     * Creates sample planifications for testing
     */
    private List<Planification> createTestPlanifications() {
        List<Planification> plans = new ArrayList<>();
        
        // Create 4 planifications for January 2024
        for (int i = 1; i <= 4; i++) {
            Planification plan = new Planification(
                "PLAN-2024-01-" + i,
                "Planificación Semana " + i,
                "Inicial",
                "Actividad Test " + i,
                "3-4 años",
                20,
                5,
                LocalDate.of(2024, 1, i * 7), // Week 1, 2, 3, 4
                "Descripción test",
                "Elemento integrador",
                "Teacher Test",
                new ArrayList<Scope>(),
                TEST_TEACHER_ID,
                new Date()
            );
            plans.add(plan);
        }
        
        return plans;
    }
    
    private Planification createSamplePlanification() {
        return new Planification(
            "PLAN-TEST-001",
            "Planificación de Prueba",
            "Inicial",
            "Actividad de Prueba",
            "3-4 años",
            25,
            7,
            LocalDate.of(2024, 7, 15),
            "Descripción de experiencia",
            "Elemento integrador de prueba",
            "Prof. Prueba",
            new ArrayList<Scope>(),
            TEST_TEACHER_ID,
            new Date()
        );
    }
    
    @Nested
    @DisplayName("Planification Model Tests")
    class PlanificationModelTests {
        
        @Test
        @DisplayName("Test 1: Planification constructor initializes grading fields correctly")
        void testPlanificationConstructorInitializesGradingFields() {
            assertNotNull(samplePlanification);
            assertEquals(1, samplePlanification.getGrade()); // Default grade should be 1
            assertFalse(samplePlanification.isGraded()); // Should not be graded initially
            assertTrue(samplePlanification.getMonth() >= 1 && samplePlanification.getMonth() <= 12);
            assertTrue(samplePlanification.getYear() >= 2020);
            assertTrue(samplePlanification.getWeekOfMonth() >= 1 && samplePlanification.getWeekOfMonth() <= 4);
        }
        
        @Test
        @DisplayName("Test 2: Grade validation accepts valid range")
        void testGradeValidationAcceptsValidRange() {
            // Test valid grades
            int[] validGrades = {1, 10, 25, 50, 75, 90, 100};
            
            for (int grade : validGrades) {
                assertDoesNotThrow(() -> samplePlanification.setGrade(grade));
                assertEquals(grade, samplePlanification.getGrade());
                assertTrue(samplePlanification.isGraded());
            }
        }
        
        @Test
        @DisplayName("Test 3: Grade validation rejects invalid values")
        void testGradeValidationRejectsInvalidValues() {
            // Test invalid grades
            int[] invalidGrades = {0, -1, 101, 150, -50};
            
            for (int grade : invalidGrades) {
                assertThrows(IllegalArgumentException.class, 
                    () -> samplePlanification.setGrade(grade),
                    "Grade " + grade + " should throw IllegalArgumentException");
            }
        }
        
        @Test
        @DisplayName("Test 4: Date calculations are accurate")
        void testDateCalculationsAccurate() {
            LocalDate testDate = LocalDate.of(2025, 7, 15); // July 15, 2025
            Planification plan = new Planification(
                "DATE-TEST", "Date Test", "Inicial", "Activity", "3-4 años",
                20, 5, testDate, "Overview", "Element", "Teacher",
                new ArrayList<>(), TEST_TEACHER_ID, new Date()
            );
            
            assertEquals(7, plan.getMonth()); // July
            assertEquals(2025, plan.getYear());
            assertEquals(3, plan.getWeekOfMonth()); // 15th day should be week 3
        }
        
        @Test
        @DisplayName("Test 5: Week of month calculation edge cases")
        void testWeekOfMonthCalculationEdgeCases() {
            // Test first day of month
            LocalDate firstDay = LocalDate.of(2025, 1, 1);
            Planification plan1 = createPlanWithDate(firstDay);
            assertEquals(1, plan1.getWeekOfMonth());
            
            // Test last day of month
            LocalDate lastDay = LocalDate.of(2025, 1, 31);
            Planification plan2 = createPlanWithDate(lastDay);
            assertEquals(4, plan2.getWeekOfMonth()); // Should be capped at 4
            
            // Test mid-month
            LocalDate midMonth = LocalDate.of(2025, 1, 15);
            Planification plan3 = createPlanWithDate(midMonth);
            assertEquals(3, plan3.getWeekOfMonth());
        }
        
        private Planification createPlanWithDate(LocalDate date) {
            return new Planification(
                "DATE-" + date.toString(), "Test Plan", "Inicial", "Activity", "3-4 años",
                20, 5, date, "Overview", "Element", "Teacher",
                new ArrayList<>(), TEST_TEACHER_ID, new Date()
            );
        }
    }
    
    @Nested
    @DisplayName("Monthly Report Tests")
    class MonthlyReportTests {
        
        @Test
        @DisplayName("Test 6: Monthly report generation with valid data")
        void testMonthlyReportGenerationWithValidData() {
            // Grade the test planifications
            for (int i = 0; i < testPlanifications.size(); i++) {
                Planification plan = testPlanifications.get(i);
                plan.setGrade(80 + (i * 5)); // Grades: 80, 85, 90, 95
            }
            
            MonthlyReport report = new MonthlyReport(1, 2024, TEST_TEACHER_ID, testPlanifications);
            
            assertNotNull(report);
            assertEquals(1, report.getMonth());
            assertEquals(2024, report.getYear());
            assertEquals(87.5, report.getMonthlyAverage(), 0.01); // (80+85+90+95)/4 = 87.5
            assertEquals(4, report.getPlanifications().size());
            assertTrue(report.isComplete()); // 4 planifications = complete
        }
        
        @Test
        @DisplayName("Test 7: Monthly report with mixed graded and ungraded planifications")
        void testMonthlyReportWithMixedGradedUngraded() {
            // Grade only half of the planifications
            testPlanifications.get(0).setGrade(80);
            testPlanifications.get(1).setGrade(90);
            // Leave others ungraded
            
            MonthlyReport report = new MonthlyReport(1, 2024, TEST_TEACHER_ID, testPlanifications);
            
            assertEquals(85.0, report.getMonthlyAverage(), 0.01); // (80+90)/2 = 85
            assertEquals(4, report.getPlanifications().size());
            assertEquals(50.0, report.getCompletionPercentage(), 0.01); // 2/4 * 100 = 50%
        }
        
        @Test
        @DisplayName("Test 8: Monthly report with no planifications")
        void testMonthlyReportWithNoPlanifications() {
            List<Planification> emptyList = new ArrayList<>();
            MonthlyReport report = new MonthlyReport(1, 2024, TEST_TEACHER_ID, emptyList);
            
            assertNotNull(report);
            assertEquals(0.0, report.getMonthlyAverage());
            assertEquals(0, report.getPlanifications().size());
            assertFalse(report.isComplete());
            assertEquals(0.0, report.getCompletionPercentage());
        }
        
        @Test
        @DisplayName("Test 9: Performance level calculation")
        void testPerformanceLevelCalculation() {
            // Test different performance levels
            testPerformanceLevel(95, "Excelente");
            testPerformanceLevel(85, "Muy Bueno");
            testPerformanceLevel(75, "Bueno");
            testPerformanceLevel(65, "Regular");
            testPerformanceLevel(50, "Necesita Mejora");
        }
        
        private void testPerformanceLevel(int grade, String expectedLevel) {
            List<Planification> singlePlan = new ArrayList<>();
            Planification plan = createSamplePlanification();
            plan.setGrade(grade);
            singlePlan.add(plan);
            
            MonthlyReport report = new MonthlyReport(7, 2024, TEST_TEACHER_ID, singlePlan);
            assertEquals(expectedLevel, report.getPerformanceLevel());
        }
        
        @Test
        @DisplayName("Test 10: Completion percentage calculation")
        void testCompletionPercentageCalculation() {
            // Test complete (100%) status
            for (Planification plan : testPlanifications) {
                plan.setGrade(80);
            }
            MonthlyReport completeReport = new MonthlyReport(1, 2024, TEST_TEACHER_ID, testPlanifications);
            assertEquals(100.0, completeReport.getCompletionPercentage(), 0.01);
            
            // Test partial (75%) status
            testPlanifications.get(3).setGraded(false); // Reset one planification
            MonthlyReport partialReport = new MonthlyReport(1, 2024, TEST_TEACHER_ID, testPlanifications);
            assertEquals(75.0, partialReport.getCompletionPercentage(), 0.01); // 3/4 * 100 = 75%
        }
    }
    
    @Nested
    @DisplayName("GradingService Tests")
    class GradingServiceTests {
        
        @Test
        @DisplayName("Test 11: GradingService singleton pattern")
        void testGradingServiceSingletonPattern() {
            GradingService instance1 = GradingService.getInstance();
            GradingService instance2 = GradingService.getInstance();
            
            assertSame(instance1, instance2);
            assertNotNull(instance1);
        }
        
        @Test
        @DisplayName("Test 12: Assign week and month functionality")
        void testAssignWeekAndMonthFunctionality() {
            Planification plan = createSamplePlanification();
            LocalDate testDate = LocalDate.of(2024, 3, 22); // March 22, 2024
            plan.setDate(testDate);
            
            gradingService.assignWeekAndMonth(plan);
            
            assertEquals(3, plan.getMonth()); // March
            assertEquals(2024, plan.getYear());
            assertEquals(4, plan.getWeekOfMonth()); // 22nd day should be week 4
        }
        
        @Test
        @DisplayName("Test 13: Week calculation with different dates")
        void testWeekCalculationWithDifferentDates() {
            int[] testDays = {1, 7, 8, 14, 15, 21, 22, 28, 29, 31};
            int[] expectedWeeks = {1, 1, 2, 2, 3, 3, 4, 4, 4, 4};
            
            for (int i = 0; i < testDays.length; i++) {
                Planification plan = createSamplePlanification();
                LocalDate testDate = LocalDate.of(2024, 1, testDays[i]);
                plan.setDate(testDate);
                
                gradingService.assignWeekAndMonth(plan);
                
                assertEquals(expectedWeeks[i], plan.getWeekOfMonth(), 
                    "Day " + testDays[i] + " should be in week " + expectedWeeks[i]);
            }
        }
    }
    
    @Nested
    @DisplayName("Edge Cases and Error Handling")
    class EdgeCasesAndErrorHandling {
        
        @Test
        @DisplayName("Test 14: Null date handling in planification")
        void testNullDateHandlingInPlanification() {
            Planification planWithNullDate = new Planification(
                "NULL-DATE", "Null Date Test", "Inicial", "Activity", "3-4 años",
                20, 5, null, "Overview", "Element", "Teacher",
                new ArrayList<>(), TEST_TEACHER_ID, null // También null para day
            );
            
            // Should have default values when date is null
            assertEquals(1, planWithNullDate.getMonth());
            assertEquals(2025, planWithNullDate.getYear()); // Cambiado a 2025
            assertEquals(1, planWithNullDate.getWeekOfMonth());
        }
        
        @Test
        @DisplayName("Test 15: Boundary grade values")
        void testBoundaryGradeValues() {
            // Test minimum valid grade
            assertDoesNotThrow(() -> samplePlanification.setGrade(1));
            assertEquals(1, samplePlanification.getGrade());
            
            // Test maximum valid grade
            assertDoesNotThrow(() -> samplePlanification.setGrade(100));
            assertEquals(100, samplePlanification.getGrade());
        }
        
        @Test
        @DisplayName("Test 16: MonthlyReport recalculation when planifications change")
        void testMonthlyReportRecalculationWhenPlanificationsChange() {
            MonthlyReport report = new MonthlyReport(1, 2024, TEST_TEACHER_ID, testPlanifications);
            
            // Initial state - no grades
            assertEquals(0.0, report.getMonthlyAverage());
            
            // Grade planifications
            testPlanifications.get(0).setGrade(80);
            testPlanifications.get(1).setGrade(90);
            
            // Recalculate
            report.calculateMonthlyAverage();
            assertEquals(85.0, report.getMonthlyAverage(), 0.01);
        }
        
        @Test
        @DisplayName("Test 17: Planification field validation")
        void testPlanificationFieldValidation() {
            // Test with various field combinations
            Planification plan = samplePlanification;
            
            // Test ID validation
            assertNotNull(plan.getIdPlanification());
            assertFalse(plan.getIdPlanification().isEmpty());
            
            // Test teacher ID validation
            assertNotNull(plan.getIdTeacher());
            assertFalse(plan.getIdTeacher().isEmpty());
            
            // Test numeric fields
            assertTrue(plan.getNumberOfChildren() > 0);
            assertTrue(plan.getEstimatedTime() > 0);
        }
    }
    
    @Nested
    @DisplayName("Integration and Business Logic Tests")
    class IntegrationAndBusinessLogicTests {
        
        @Test
        @DisplayName("Test 18: Grade modification updates isGraded flag")
        void testGradeModificationUpdatesIsGradedFlag() {
            assertFalse(samplePlanification.isGraded());
            
            samplePlanification.setGrade(75);
            assertTrue(samplePlanification.isGraded());
            
            samplePlanification.setGrade(90);
            assertTrue(samplePlanification.isGraded()); // Should remain true
        }
        
        @Test
        @DisplayName("Test 19: Monthly progress calculation accuracy")
        void testMonthlyProgressCalculationAccuracy() {
            // Test with precise grade values
            List<Planification> precisionPlans = new ArrayList<>();
            int[] grades = {73, 81, 92, 68}; // Average should be 78.5
            
            for (int i = 0; i < grades.length; i++) {
                Planification plan = createSamplePlanification();
                plan.setGrade(grades[i]);
                precisionPlans.add(plan);
            }
            
            MonthlyReport report = new MonthlyReport(7, 2024, TEST_TEACHER_ID, precisionPlans);
            assertEquals(78.5, report.getMonthlyAverage(), 0.01);
        }
        
        @Test
        @DisplayName("Test 20: Complete grading workflow simulation")
        void testCompleteGradingWorkflowSimulation() {
            // Simulate a complete grading workflow
            List<Planification> workflowPlans = createTestPlanifications();
            
            // Step 1: Verify initial state
            assertTrue(workflowPlans.stream().noneMatch(Planification::isGraded));
            
            // Step 2: Grade planifications progressively
            workflowPlans.get(0).setGrade(85);
            workflowPlans.get(1).setGrade(92);
            
            // Step 3: Generate intermediate report
            MonthlyReport intermediateReport = new MonthlyReport(1, 2024, TEST_TEACHER_ID, workflowPlans);
            assertEquals(50.0, intermediateReport.getCompletionPercentage(), 0.01); // 2/4 = 50%
            assertEquals(2, workflowPlans.stream().mapToInt(p -> p.isGraded() ? 1 : 0).sum());
            
            // Step 4: Complete remaining planifications
            workflowPlans.get(2).setGrade(78);
            workflowPlans.get(3).setGrade(88);
            
            // Step 5: Generate final report
            MonthlyReport finalReport = new MonthlyReport(1, 2024, TEST_TEACHER_ID, workflowPlans);
            finalReport.calculateMonthlyAverage(); // Recalculate after changes
            
            assertEquals(100.0, finalReport.getCompletionPercentage(), 0.01); // 4/4 = 100%
            assertEquals(4, workflowPlans.stream().mapToInt(p -> p.isGraded() ? 1 : 0).sum());
            assertEquals(85.75, finalReport.getMonthlyAverage(), 0.01); // (85+92+78+88)/4
            assertEquals("Muy Bueno", finalReport.getPerformanceLevel());
            
            // Step 6: Verify all planifications are graded
            assertTrue(workflowPlans.stream().allMatch(Planification::isGraded));
        }
    }
}
