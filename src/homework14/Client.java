package homework14;

import java.time.LocalDate;

public class Client {
    private String secondName;
    private String firstName;
    private int yearOfBirth;
    private LocalDate regDate;

    public Client(String secondName, String firstName, int yearOfBirth) {
        this.secondName = secondName;
        this.firstName = firstName;
        this.yearOfBirth = yearOfBirth;
        this.regDate = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Client{" +
                "secondName='" + secondName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }

    public Client(String secondName, String firstName, int yearOfBirth, LocalDate regDate) {
        this.secondName = secondName;
        this.firstName = firstName;
        this.yearOfBirth = yearOfBirth;
        this.regDate = regDate;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }
}
