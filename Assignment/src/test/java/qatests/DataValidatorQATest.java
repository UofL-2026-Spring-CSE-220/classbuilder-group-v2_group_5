package qatests;

import edu.coolschool.utilities.dateutils.DateValidator;
import edu.coolschool.utilities.dateutils.MonthsEnum;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DataValidatorQATest {

    @Test
    void testIsLeapYear() {
        assertTrue(DateValidator.isLeapYear(2024));
        assertTrue(DateValidator.isLeapYear(2000));
        assertFalse(DateValidator.isLeapYear(1900));
        assertFalse(DateValidator.isLeapYear(2023));
    }

    @Test
    void testGetDaysInMonth() {
        assertEquals(31, DateValidator.getDaysInMonth(1, 2024));
        assertEquals(29, DateValidator.getDaysInMonth(2, 2024));
        assertEquals(28, DateValidator.getDaysInMonth(2, 2023));
        assertEquals(30, DateValidator.getDaysInMonth(6, 2024));
    }

    @Test
    void testIsValidDate() {
        assertTrue(DateValidator.isValidDate(29, 2, 2020));
        assertFalse(DateValidator.isValidDate(29, 2, 2021));
        assertTrue(DateValidator.isValidDate(31, 12, 2021));
        assertFalse(DateValidator.isValidDate(31, 6, 2021));
    }

    @Test
    void testGetDaysInMonth_UsingEnum() {
        assertEquals(31, DateValidator.getDaysInMonth(MonthsEnum.JANUARY, 2024));
        assertEquals(29, DateValidator.getDaysInMonth(MonthsEnum.FEBRUARY, 2024));
    }

    @Test
    void testAprilFailure() {
        assertThrows(IllegalArgumentException.class, () -> {
            DateValidator.getDaysInMonth(4, 2024);
        });
    }
}