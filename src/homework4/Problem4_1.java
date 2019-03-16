package homework4;

public class Problem4_1 {
    public static void solve(){
        OneWayList myList = new OneWayList();
        myList.add(7);
        myList.add(19);
        System.out.println(myList);
        myList.remove();
        System.out.println(myList);
        for (int i = 0; i < 10 ; i++) {
            myList.add(i);
        }
        myList.add(20);
        System.out.println(myList);
        myList.remove();
        while(myList.getFirstNod()!=null){
            myList.remove();
            System.out.println(myList);
        }

    }
}
