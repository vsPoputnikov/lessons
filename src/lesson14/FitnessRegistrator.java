package lesson14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;

public class FitnessRegistrator {
    final LocalTime openTime = LocalTime.of(8,0);
    final LocalTime closeDayTime = LocalTime.of(16,0);
    final LocalTime closeTime = LocalTime.of(22,0);
    ArrayList<Client> clientsGym = new ArrayList<>();
    ArrayList<Client> clientsPool = new ArrayList<>();
    ArrayList<Client> clientsGroup = new ArrayList<>();


    public void accept(Client client, FitnessServiceEnumeration service, LocalTime time) throws NoAccessException, QueueException {
        if(client instanceof DayClient){
            if(time.isBefore( openTime)||(time.isAfter(closeDayTime))||service == FitnessServiceEnumeration.POOL)
            {
                throw new NoAccessException("");
            }
        }
        if (client instanceof FullDayClient){
            if (time.isBefore( openTime)||(time.isAfter(closeTime))){
                throw new NoAccessException("");
            }
        }
        switch (service){
            case GYM:
                if (clientsGym.size()==20)
                    throw new QueueException("");
                this.clientsGym.add(client);
                break;
            case GROUP:
                if (clientsGroup.size()==20)
                    throw new QueueException("");
                this.clientsGroup.add(client);
                break;
            case POOL:
                if (clientsPool.size()==20)
                    throw new QueueException("");
                this.clientsPool.add(client);
                break;

        }
        try {
            FitnessLogger.add(client,service,time);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void leave(Client client){
        clientsGym.remove(client);
        clientsPool.remove(client);
        clientsGroup.remove(client);
    }
    public void listClients(){
        clientsGym.sort(new ClientComparator());
        clientsPool.sort(new ClientComparator());
        clientsGroup.sort(new ClientComparator());
        System.out.println("GYM:");
        for (Client client: clientsGym){
            String classname = client.getClass().toString();
            System.out.println("<"+client.getSecondName()+"> " +
                    "<"+client.getFirstName()+"> " +
                    "<" +classname.substring(classname.lastIndexOf('.')+1)+"> "+ "<GYM>");
        }
        System.out.println("POOL:");
        for (Client client: clientsPool){
            String classname = client.getClass().toString();
            System.out.println("<"+client.getSecondName()+"> " +
                    "<"+client.getFirstName()+"> " +
                    "<" +classname.substring(classname.lastIndexOf('.')+1)+"> "+ "<POOL>");
        }
        System.out.println("GROUP:");
        for (Client client: clientsGroup){
            String classname = client.getClass().toString();
            System.out.println("<"+client.getSecondName()+"> " +
                    "<"+client.getFirstName()+"> " +
                    "<" +classname.substring(classname.lastIndexOf('.')+1)+"> "+ "<GROUP>");
        }
    }
}

class FitnessLogger{
    final static File log = new File("fitnessLog.txt");
    static void add(Client client, FitnessServiceEnumeration service, LocalTime time) throws IOException {
        try(FileOutputStream out = new FileOutputStream(log, true)){
            String s = client.getSecondName()+client.getFirstName()+service+time+"\n";
            out.write(s.getBytes());
        }
    }
}
