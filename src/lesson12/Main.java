package lesson12;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        File statFile = new File("stat.bin");
        /*LaunchStat launchStat = null;
        if (!statFile.exists()){
            // если первый запуск
            launchStat = new LaunchStat();
        }else {
            try (ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(statFile))){
                // приведение типов
                launchStat = (LaunchStat) objIn.readObject();
            } catch (IOException|ClassNotFoundException e){
                e.printStackTrace();
            }
        }

        if (launchStat.isFirstLaunch()){
            System.out.println("First run");
        } else{
            System.out.println(launchStat);
        }

        launchStat.update();
        // запись объекта
        try(ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(statFile))){
            objOut.writeObject(launchStat);
        }catch (IOException e){
            e.printStackTrace();
        }
*/
        File statFile2 = new File("stat2.bin");
        LaunchStatExt stat = null;

        if(!statFile2.exists()){
            stat = new LaunchStatExt();
        }else {
            try(ObjectInputStream objOut =
                    new ObjectInputStream((new FileInputStream(statFile2)))){
                stat = (LaunchStatExt)objOut.readObject();
            } catch (IOException|ClassNotFoundException e){
                e.printStackTrace();
            }
        }

        if(stat.isFirstLaunch()){
            System.out.println("first");
        } else{
            System.out.println(stat);
        }

        stat.update();
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(statFile2))){
            out.writeObject(stat);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
