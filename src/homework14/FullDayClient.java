package homework14;

import java.time.LocalDate;

public class FullDayClient extends DayClient {
    public FullDayClient(String secondName, String firstName, int yearOfBirth) {
        super(secondName, firstName, yearOfBirth);
    }

    public FullDayClient(String secondName, String firstName, int yearOfBirth, LocalDate regDate, int months) {
        super(secondName, firstName, yearOfBirth, regDate, months);
    }

}
