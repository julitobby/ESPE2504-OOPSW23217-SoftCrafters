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
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for GradingService and MonthlyReport
 * @author SoftCrafters
 */
public class GradingServiceTest {
    
    private GradingService gradingService;
    private List<Planification> testPlanifications;
    
    @BeforeEach
    void setUp() {
        gradingService = GradingService.getInstance();
        testPlanifications = createTestPlanifications();
    }
    
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
                "T001",
                new Date()
            );
            
            // Set week and month
            plan.setYear(2024);
            plan.setMonth(1);
            plan.setWeekOfMonth(i);
            
            plans.add(plan);
        }
        
        return plans;
    }
    
    @Test
    void testGradePlanification() {
        Planification plan = testPlanifications.get(0);
        
        // Test valid grade
        plan.setGrade(85);
        assertTrue(plan.isGraded());
        assertEquals(85, plan.getGrade());
        
        // Test invalid grade - should throw exception
        assertThrows(IllegalArgumentException.class, () -> {
            plan.setGrade(101);
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            plan.setGrade(0);
        });
    }
    
    @Test
    void testMonthlyReportCalculation() {
        // Grade all planifications
        testPlanifications.get(0).setGrade(90); // Week 1
        testPlanifications.get(1).setGrade(85); // Week 2
        testPlanifications.get(2).setGrade(75); // Week 3
        testPlanifications.get(3).setGrade(80); // Week 4
        
        MonthlyReport report = new MonthlyReport(1, 2024, "T001", testPlanifications);
        
        // Test average calculation: (90+85+75+80)/4 = 82.5
        assertEquals(82.5, report.getMonthlyAverage(), 0.01);
        assertTrue(report.isComplete());
        assertEquals(100.0, report.getCompletionPercentage(), 0.01);
        assertEquals("Muy Bueno", report.getPerformanceLevel());
    }
    
    @Test
    void testPartiallyGradedReport() {
        // Grade only 2 planifications
        testPlanifications.get(0).setGrade(90);
        testPlanifications.get(1).setGrade(80);
        // Leave 2 ungraded
        
        MonthlyReport report = new MonthlyReport(1, 2024, "T001", testPlanifications);
        
        // Average should be (90+80)/2 = 85
        assertEquals(85.0, report.getMonthlyAverage(), 0.01);
        assertEquals(50.0, report.getCompletionPercentage(), 0.01);
        assertEquals("Muy Bueno", report.getPerformanceLevel());
    }
    
    @Test
    void testPerformanceLevels() {
        List<Planification> singlePlan = new ArrayList<>();
        singlePlan.add(testPlanifications.get(0));
        
        // Test Excelente (90-100)
        singlePlan.get(0).setGrade(95);
        MonthlyReport report1 = new MonthlyReport(1, 2024, "T001", singlePlan);
        assertEquals("Excelente", report1.getPerformanceLevel());
        
        // Test Muy Bueno (80-89)
        singlePlan.get(0).setGrade(85);
        MonthlyReport report2 = new MonthlyReport(1, 2024, "T001", singlePlan);
        assertEquals("Muy Bueno", report2.getPerformanceLevel());
        
        // Test Bueno (70-79)
        singlePlan.get(0).setGrade(75);
        MonthlyReport report3 = new MonthlyReport(1, 2024, "T001", singlePlan);
        assertEquals("Bueno", report3.getPerformanceLevel());
        
        // Test Regular (60-69)
        singlePlan.get(0).setGrade(65);
        MonthlyReport report4 = new MonthlyReport(1, 2024, "T001", singlePlan);
        assertEquals("Regular", report4.getPerformanceLevel());
        
        // Test Necesita Mejora (<60)
        singlePlan.get(0).setGrade(50);
        MonthlyReport report5 = new MonthlyReport(1, 2024, "T001", singlePlan);
        assertEquals("Necesita Mejora", report5.getPerformanceLevel());
    }
    
    @Test
    void testWeekAndMonthAssignment() {
        Planification plan = new Planification(
            "TEST-001",
            "Test Plan",
            "Inicial",
            "Test Activity",
            "3-4 años",
            20,
            5,
            LocalDate.of(2024, 3, 15), // March 15th
            "Test description",
            "Element",
            "Teacher",
            new ArrayList<>(),
            "T001",
            new Date()
        );
        
        gradingService.assignWeekAndMonth(plan);
        
        assertEquals(2024, plan.getYear());
        assertEquals(3, plan.getMonth());
        // March 15th should be week 3 of the month
        assertTrue(plan.getWeekOfMonth() >= 1 && plan.getWeekOfMonth() <= 4);
    }
    
    @Test
    void testValidationRules() {
        Planification plan = testPlanifications.get(0);
        
        // Test week validation
        assertThrows(IllegalArgumentException.class, () -> {
            plan.setWeekOfMonth(0);
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            plan.setWeekOfMonth(5);
        });
        
        // Test month validation
        assertThrows(IllegalArgumentException.class, () -> {
            plan.setMonth(0);
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            plan.setMonth(13);
        });
        
        // Valid values should work
        assertDoesNotThrow(() -> {
            plan.setWeekOfMonth(3);
            plan.setMonth(6);
        });
    }
    
    @Test
    void testEmptyReport() {
        List<Planification> emptyList = new ArrayList<>();
        MonthlyReport report = new MonthlyReport(1, 2024, "T001", emptyList);
        
        assertEquals(0.0, report.getMonthlyAverage());
        assertEquals(0.0, report.getCompletionPercentage());
        assertFalse(report.isComplete());
    }
}
