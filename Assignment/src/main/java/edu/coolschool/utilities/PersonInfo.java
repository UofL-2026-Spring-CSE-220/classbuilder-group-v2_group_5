package edu.coolschool.utilities;

import edu.coolschool.utilities.dateutils.DateRecord;

public record PersonInfo(
        String firstName,
        String middleName,
        String lastName,
        int birthDay,
        int birthMonth,
        int birthYear,
        CountriesEnum countryOfResidence,
        CountriesEnum countryOfBirth
) {
    public PersonInfo {
        if (firstName==null||firstName.isBlank()){
            throw new IllegalArgumentException(ErrorStrings.FIRST_NAME_BLANK.getMessage());
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException(ErrorStrings.LAST_NAME_BLANK.getMessage());
        }
        if (countryOfResidence == null) {
            throw new IllegalArgumentException(ErrorStrings.NULL_COUNTRY.getMessage());
        }
        if (countryOfBirth == null) {
            throw new IllegalArgumentException(ErrorStrings.NULL_COUNTRY_OF_BIRTH.getMessage());
        }

    }
    public DateRecord dateOfBirth(){
        return new DateRecord(birthDay,birthMonth,birthYear);
    }

    public String toString() {
        return toString(0);
    }
    public String toString(int tabLevel) {
        String indent = "\t".repeat(tabLevel);
        StringBuilder sb = new StringBuilder();
        sb.append(indent).append("First Name: ").append(firstName).append("\n");
        if (middleName != null && !middleName.isBlank()) {
            sb.append(indent).append("Middle Name: ").append(middleName).append("\n");
        }
        sb.append(indent).append("Last Name: ").append(lastName).append("\n");
        DateRecord dob = new DateRecord(birthDay, birthMonth, birthYear);
        sb.append(indent).append("Date of Birth: ").append(dob.toString()).append("\n");
        sb.append(indent).append("Country of Residence: ").append(countryOfResidence.toString()).append("\n");
        sb.append(indent).append("Country of Birth: ").append(countryOfBirth.toString()).append("\n");
        return sb.toString();
    }

    public static class Builder {
        private String firstName;
        private String middleName;
        private String lastName;
        private int birthDay;
        private int birthMonth;
        private int birthYear;
        private CountriesEnum countryOfResidence;
        private CountriesEnum countryOfBirth;

        public Builder setFirstName (String firstName){
            this.firstName=firstName;
            return this;
        }
        public Builder setMiddleName (String middleName){
            this.middleName=middleName;
            return this;
        }
        public Builder setLastName (String lastName){
            this.lastName=lastName;
            return this;
        }
        public Builder setDateOfBirth (DateRecord dateOfBirth){
            this.birthDay = dateOfBirth.dayInteger();
            this.birthMonth = dateOfBirth.monthInteger();
            this.birthYear = dateOfBirth.yearInteger();
            return this;
        }
        public Builder setCountryOfResidence (CountriesEnum countryOfResidence){
            this.countryOfResidence=countryOfResidence;
            return this;
        }
        public Builder setCountryOfBirth (CountriesEnum countryOfBirth){
            this.countryOfBirth=countryOfBirth;
            return this;
        }
        public PersonInfo build(){
            return new PersonInfo(firstName,middleName,lastName,birthDay,birthMonth,birthYear,countryOfResidence,countryOfBirth);
        }
    }

    public static void main(String[] args) {
        DateRecord dob = new DateRecord(15, 3, 2024);
        PersonInfo person = new PersonInfo.Builder()
                .setFirstName("John")
                .setMiddleName("Q")
                .setLastName("Public")
                .setDateOfBirth(dob)
                .setCountryOfResidence(CountriesEnum.US)
                .setCountryOfBirth(CountriesEnum.US)
                .build();
        System.out.println(person.toString());
    }

}