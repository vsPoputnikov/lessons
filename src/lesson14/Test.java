package lesson14;

import java.time.LocalDate;
import java.time.LocalTime;

public class Test {
    public static void main(String[] args) {
        DayClient dayClient = new DayClient("Иванов", "Иван", 1990);
        FullDayClient fullDayClient = new FullDayClient("Иванов", "Илья", 1990);
        FitnessRegistrator fitnessRegistrator = new FitnessRegistrator();
        try {
            fitnessRegistrator.accept(fullDayClient,FitnessServiceEnumeration.GYM, LocalTime.of(12,00));
            fitnessRegistrator.accept(dayClient, FitnessServiceEnumeration.GYM, LocalTime.of(12,00));
            System.out.println(fitnessRegistrator.clientsGym);
            fitnessRegistrator.listClients();

            fitnessRegistrator.leave(dayClient);

        } catch (NoAccessException e) {
            System.out.println("No access exception");
            e.printStackTrace();
        } catch (QueueException e) {
            System.out.println("Queue exception");
            e.printStackTrace();
        }

    }
}
