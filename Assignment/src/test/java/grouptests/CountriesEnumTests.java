package grouptests;

import edu.coolschool.utilities.CountriesEnum;
import edu.coolschool.utilities.ErrorStrings;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CountriesEnumTests {

    @Test
    @DisplayName("fromCode returns correct enum for valid uppercase code")
    public void fromCodeReturnsCorrectEnumForValidUppercaseCode() {
        assertEquals(CountriesEnum.US, CountriesEnum.fromCode("US"));
        assertEquals(CountriesEnum.CA, CountriesEnum.fromCode("CA"));
        assertEquals(CountriesEnum.DE, CountriesEnum.fromCode("DE"));
    }

    @Test
    @DisplayName("fromCode is case-insensitive")
    public void fromCodeIsCaseInsensitive() {
        assertEquals(CountriesEnum.US, CountriesEnum.fromCode("us"));
        assertEquals(CountriesEnum.FR, CountriesEnum.fromCode("fr"));
        assertEquals(CountriesEnum.JP, CountriesEnum.fromCode("Jp"));
    }

    @Test
    @DisplayName("fromCode returns null for null input")
    public void fromCodeReturnsNullForNullInput() {
        assertNull(CountriesEnum.fromCode(null));
    }

    @Test
    @DisplayName("fromCode throws IllegalArgumentException for unknown code")
    public void fromCodeThrowsExceptionForUnknownCode() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                CountriesEnum.fromCode("XX")
        );
        assertEquals(ErrorStrings.UNKNOWN_COUNTRY.getMessage(), ex.getMessage());
    }

    @Test
    @DisplayName("getCode returns correct ISO alpha-2 code")
    public void getCodeReturnsCorrectISOCode() {
        assertEquals("US", CountriesEnum.US.getCode());
        assertEquals("JP", CountriesEnum.JP.getCode());
        assertEquals("BR", CountriesEnum.BR.getCode());
    }

    @Test
    @DisplayName("getDisplayName returns correct full country name")
    public void getDisplayNameReturnsCorrectFullName() {
        assertEquals("United States of America", CountriesEnum.US.getDisplayName());
        assertEquals("Germany", CountriesEnum.DE.getDisplayName());
        assertEquals("France", CountriesEnum.FR.getDisplayName());
    }

    @Test
    @DisplayName("toString returns display name")
    public void toStringReturnsDisplayName() {
        assertEquals("Japan", CountriesEnum.JP.toString());
        assertEquals("Canada", CountriesEnum.CA.toString());
    }
}