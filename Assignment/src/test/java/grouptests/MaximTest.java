package grouptests;

import edu.coolschool.utilities.dateutils.DateRecord;
import edu.coolschool.utilities.dateutils.MonthsEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MaximTest {
    @Test
    @DisplayName("constructor with null MonthsEnum throws NullPointerException")
    void constructorWithNullMonthEnumThrowsException() {
        assertThrows(NullPointerException.class, () -> new DateRecord(15, (MonthsEnum) null, 2024));
    }

    @Test
    @DisplayName("toString with null format throws NullPointerException")
    void toStringWithNullFormatThrowsException() {
        DateRecord date = new DateRecord(15, 3, 2024);

        assertThrows(NullPointerException.class, () -> date.toString(null));
    }
}
