package grouptests.JacobBTest;

import edu.coolschool.utilities.dateutils.DateFormatOptionsEnum;
import edu.coolschool.utilities.dateutils.DateRecord;
import edu.coolschool.utilities.dateutils.MonthsEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DateRecordTest {

    @Test
    @DisplayName("record component accessors return constructor values")
    void recordComponentAccessorsReturnConstructorValues() {
        DateRecord date = new DateRecord(1, 12, 1999);

        assertEquals(1, date.dayInteger());
        assertEquals(12, date.monthInteger());
        assertEquals(1999, date.yearInteger());
    }

    @Test
    @DisplayName("default toString uses MM/DD/YYYY with leading zeros")
    void defaultToStringUsesMMDDYYYYWithLeadingZeros() {
        DateRecord date = new DateRecord(3, 7, 2021);

        assertEquals("07/03/2021", date.toString());
    }

    @Test
    @DisplayName("toString supports all declared date format options")
    void toStringSupportsAllDateFormatOptions() {
        DateRecord date = new DateRecord(9, MonthsEnum.MARCH, 2025);

        assertEquals("09/03/2025", date.toString(DateFormatOptionsEnum.DD_MM_YYYY));
        assertEquals("03/09/2025", date.toString(DateFormatOptionsEnum.MM_DD_YYYY));
        assertEquals("2025/03/09", date.toString(DateFormatOptionsEnum.YYYY_MM_DD));
        assertEquals("March 09, 2025", date.toString(DateFormatOptionsEnum.MONTH_DD_YYYY));
    }

    @Test
    @DisplayName("constructor with MonthsEnum matches integer month constructor")
    void constructorWithMonthsEnumMatchesIntegerConstructor() {
        DateRecord fromEnum = new DateRecord(15, MonthsEnum.MARCH, 2024);
        DateRecord fromInt = new DateRecord(15, 3, 2024);

        assertEquals(fromInt.dayInteger(), fromEnum.dayInteger());
        assertEquals(fromInt.monthInteger(), fromEnum.monthInteger());
        assertEquals(fromInt.yearInteger(), fromEnum.yearInteger());
        assertEquals(fromInt.toString(), fromEnum.toString());
    }

    @Test
    @DisplayName("builder supports both enum and integer month inputs")
    void builderSupportsEnumAndIntegerMonthInputs() {
        DateRecord fromEnum = new DateRecord.Builder()
                .setDay(15)
                .setMonth(MonthsEnum.MARCH)
                .setYear(2024)
                .build();

        DateRecord fromInt = new DateRecord.Builder()
                .setDay(15)
                .setMonth(3)
                .setYear(2024)
                .build();

        assertEquals(fromEnum, fromInt);
        assertEquals("03/15/2024", fromEnum.toString());
    }

    @Test
    @DisplayName("invalid dates are rejected with IllegalArgumentException")
    void invalidDatesAreRejected() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> new DateRecord(31, 2, 2021)
        );
        assertEquals("Invalid date: 31/2/2021", ex.getMessage());

        assertThrows(IllegalArgumentException.class, () -> new DateRecord(0, 1, 2020));
        assertThrows(IllegalArgumentException.class, () -> new DateRecord(1, 13, 2020));
        assertThrows(IllegalArgumentException.class, () -> new DateRecord(31, 4, 2021));
    }

    @Test
    @DisplayName("leap-year rules are enforced for February 29")
    void leapYearRulesEnforcedForFebruary29() {
        assertDoesNotThrow(() -> new DateRecord(29, MonthsEnum.FEBRUARY, 2000)); // leap year
        assertThrows(IllegalArgumentException.class, () -> new DateRecord(29, MonthsEnum.FEBRUARY, 1900)); // not leap year
    }

    @Test
    @DisplayName("builder without required fields results in invalid date exception")
    void builderWithoutRequiredFieldsThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                new DateRecord.Builder()
                        .setDay(10)
                        .setYear(2024)
                        .build() // month defaults to 0, invalid
        );
    }
}

