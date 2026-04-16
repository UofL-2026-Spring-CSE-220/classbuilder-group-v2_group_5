package qatests;

import edu.coolschool.utilities.dateutils.DateRecord;
import edu.coolschool.utilities.dateutils.MonthsEnum;

// import edu.coolschool.utilities.ErrorStrings;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DateRecordQATests {

    @Test
    public void testValidDateRecordBuilder() {
        // Testing the Happy Path using Jacob's exact method names
        DateRecord date = new DateRecord.Builder()
                .setMonth(MonthsEnum.MAY) // Using the enum revealed in the autograder
                .setDay(15)
                .setYear(2023)
                .build();

        // We check the string output to verify the month was stored correctly
        assertEquals("05/15/2023", date.toString());
    }

    @Test
    public void testInvalidBuilderMonthThrowsException() {
        // Testing the Unhappy Path: Does the Builder catch a bad month?
        // Note: If Jacob overloaded setMonth to take an int, test 13.
        // If he only accepts MonthsEnum, we might need to test a bad day instead (like Feb 30).

        assertThrows(IllegalArgumentException.class, () -> {
            new DateRecord.Builder()
                    .setDay(31)
                    .setMonth(MonthsEnum.FEBRUARY) // Feb 31st should definitely fail!
                    .setYear(2024)
                    .build();
        }, "Builder should reject February 31st");
    }
}