package grouptests;

import edu.coolschool.utilities.dateutils.DateFormatOptionsEnum;
import edu.coolschool.utilities.dateutils.DateRecord;
import edu.coolschool.utilities.dateutils.MonthsEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DateFormatOptionsEnumTests {

    @Test
    @DisplayName("values returns all date format options in declaration order")
    public void valuesReturnsAllDateFormatOptionsInDeclarationOrder() {
        DateFormatOptionsEnum[] expected = {
                DateFormatOptionsEnum.DD_MM_YYYY,
                DateFormatOptionsEnum.MM_DD_YYYY,
                DateFormatOptionsEnum.YYYY_MM_DD,
                DateFormatOptionsEnum.MONTH_DD_YYYY
        };

        assertArrayEquals(expected, DateFormatOptionsEnum.values());
    }

    @Test
    @DisplayName("valueOf returns matching enum for valid names")
    public void valueOfReturnsMatchingEnumForValidNames() {
        assertEquals(DateFormatOptionsEnum.DD_MM_YYYY, DateFormatOptionsEnum.valueOf("DD_MM_YYYY"));
        assertEquals(DateFormatOptionsEnum.MM_DD_YYYY, DateFormatOptionsEnum.valueOf("MM_DD_YYYY"));
        assertEquals(DateFormatOptionsEnum.YYYY_MM_DD, DateFormatOptionsEnum.valueOf("YYYY_MM_DD"));
        assertEquals(DateFormatOptionsEnum.MONTH_DD_YYYY, DateFormatOptionsEnum.valueOf("MONTH_DD_YYYY"));
    }

    @Test
    @DisplayName("valueOf throws IllegalArgumentException for unknown names")
    public void valueOfThrowsForUnknownNames() {
        assertThrows(IllegalArgumentException.class, () -> DateFormatOptionsEnum.valueOf("MM-DD-YYYY"));
        assertThrows(IllegalArgumentException.class, () -> DateFormatOptionsEnum.valueOf(""));
    }

    @Test
    @DisplayName("each option can format a date through DateRecord")
    public void eachOptionCanFormatDateThroughDateRecord() {
        DateRecord date = new DateRecord(9, MonthsEnum.MARCH, 2025);

        assertEquals("09/03/2025", date.toString(DateFormatOptionsEnum.DD_MM_YYYY));
        assertEquals("03/09/2025", date.toString(DateFormatOptionsEnum.MM_DD_YYYY));
        assertEquals("2025/03/09", date.toString(DateFormatOptionsEnum.YYYY_MM_DD));
        assertEquals("March 09, 2025", date.toString(DateFormatOptionsEnum.MONTH_DD_YYYY));
    }
}

