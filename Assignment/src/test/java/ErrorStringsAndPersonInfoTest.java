package grouptests;

import edu.coolschool.utilities.ErrorStrings;
import edu.coolschool.utilities.PersonInfo;
import edu.coolschool.utilities.CountriesEnum;
import edu.coolschool.utilities.dateutils.DateRecord;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ErrorStringsAndPersonInfoTest {

    @Test
    void errorStringsAreNotNull() {
        for (ErrorStrings error : ErrorStrings.values()) {
            assertNotNull(error.getMessage());
        }
    }

    @Test
    void errorStringsHaveCorrectMessages() {
        assertEquals("First name cannot be null or blank. Please provide a valid first name.",
                ErrorStrings.FIRST_NAME_BLANK.getMessage());
        assertEquals("Last name cannot be null or blank. Please provide a valid last name.",
                ErrorStrings.LAST_NAME_BLANK.getMessage());
    }

    @Test
    void personInfoBuildsCorrectly() {
        DateRecord dob = new DateRecord(15, 3, 2000);
        PersonInfo person = new PersonInfo.Builder()
                .setFirstName("John")
                .setLastName("Doe")
                .setDateOfBirth(dob)
                .setCountryOfResidence(CountriesEnum.US)
                .setCountryOfBirth(CountriesEnum.US)
                .build();
        assertEquals("John", person.firstName());
        assertEquals("Doe", person.lastName());
    }

    @Test
    void personInfoThrowsOnNullFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new PersonInfo.Builder()
                    .setLastName("Doe")
                    .setDateOfBirth(new DateRecord(1, 1, 2000))
                    .setCountryOfResidence(CountriesEnum.US)
                    .setCountryOfBirth(CountriesEnum.US)
                    .build();
        });
    }

    @Test
    void personInfoThrowsOnNullLastName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new PersonInfo.Builder()
                    .setFirstName("John")
                    .setDateOfBirth(new DateRecord(1, 1, 2000))
                    .setCountryOfResidence(CountriesEnum.US)
                    .setCountryOfBirth(CountriesEnum.US)
                    .build();
        });
    }

    @Test
    void personInfoThrowsOnNullCountry() {
        assertThrows(IllegalArgumentException.class, () -> {
            new PersonInfo.Builder()
                    .setFirstName("John")
                    .setLastName("Doe")
                    .setDateOfBirth(new DateRecord(1, 1, 2000))
                    .setCountryOfBirth(CountriesEnum.US)
                    .build();
        });
    }
}
