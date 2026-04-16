package grouptests;

import edu.coolschool.utilities.dateutils.MonthsEnum;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MonthsEnumTest {

    @Test
    void testGetMonthNumber() {
        assertEquals(1, MonthsEnum.JANUARY.getMonthNumber());
        assertEquals(12, MonthsEnum.DECEMBER.getMonthNumber());
    }

    @Test
    void testFromMonthNumberValid() {
        assertEquals(MonthsEnum.FEBRUARY, MonthsEnum.fromMonthNumber(2));
        assertEquals(MonthsEnum.OCTOBER, MonthsEnum.fromMonthNumber(10));
    }

    @Test
    void testFromMonthNumberInvalid() {
        assertThrows(IllegalArgumentException.class, () -> MonthsEnum.fromMonthNumber(0));
        assertThrows(IllegalArgumentException.class, () -> MonthsEnum.fromMonthNumber(13));
    }

    @Test
    void testFromStringValid() {
        assertEquals(MonthsEnum.MARCH, MonthsEnum.fromString("MARCH"));
        assertEquals(MonthsEnum.APRIL, MonthsEnum.fromString("april"));
        assertEquals(MonthsEnum.MAY, MonthsEnum.fromString("May"));
    }

    @Test
    void testFromStringInvalid() {
        assertThrows(IllegalArgumentException.class, () -> MonthsEnum.fromString("Enero"));
        assertThrows(IllegalArgumentException.class, () -> MonthsEnum.fromString(""));
        assertThrows(IllegalArgumentException.class, () -> MonthsEnum.fromString(null));
    }

    @Test
    void testToString() {
        assertEquals("January", MonthsEnum.JANUARY.toString());
        assertEquals("August", MonthsEnum.AUGUST.toString());
        assertEquals("December", MonthsEnum.DECEMBER.toString());
    }
}