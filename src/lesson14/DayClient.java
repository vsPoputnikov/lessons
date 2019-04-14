package lesson14;

import java.time.LocalDate;

public class DayClient extends Client {

    private LocalDate endDate;

    public DayClient(String secondName, String firstName, int yearOfBirth) {
        super(secondName, firstName, yearOfBirth);
        this.endDate = LocalDate.now().plusYears(1);
    }

    public DayClient(String secondName, String firstName, int yearOfBirth, LocalDate regDate, int months) {
        super(secondName, firstName, yearOfBirth, regDate);
        this.endDate = regDate.plusMonths(months);
    }









}
