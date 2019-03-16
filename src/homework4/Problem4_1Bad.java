package homework4;

public class Problem4_1Bad {
    public static void solveBad(){
        OneWayListBad myList = new OneWayListBad();
        for (int i = 0; i < 10 ; i++) {
            myList.add(i);
        }
        myList.add(20);
        System.out.println(myList);
        System.out.println(myList.getLength());
        for (int i = 0; i < 10 ; i++) {
            myList.remove();
        }
        myList.remove();
        System.out.println(myList);
        System.out.println(myList.getLength());
    }
}

class OneWayListBad {
    private Nod firstNod;
    private Nod lastNod;
    private int length = 0;

    public OneWayListBad() {
        this.firstNod = null;
        this.lastNod = null;
    }

    public void add(int value) {
        this.setLength(this.getLength() + 1);
        Nod nod = new Nod(value);
        if (this.getLength() == 1) {
            this.setFirstNod(nod);
            this.setLastNod(nod);
            return;
        }
        this.lastNod.setNextNod(nod);
        this.setLastNod(nod);
        return;
    }
    public void remove(){
        if(this.getLength()>1){
            Nod iter1 = this.getFirstNod();
            Nod iter2 = this.getFirstNod().getNextNod();
            while(iter2!=this.getLastNod()){
                iter1 = iter2;
                iter2 = iter2.getNextNod();
            }
            iter1.setNextNod(null);
            this.setLastNod(iter1);
        } else {
            this.setFirstNod(null);
        }
        this.setLength(this.getLength()-1);
    }

    @Override
    public String toString() {
        String s = "";
        Nod iter = this.firstNod;
        while (iter != null) {
            s += iter.getValue() + " ";
            iter = iter.getNextNod();
        }
        return s;
    }

    public Nod getFirstNod() {
        return firstNod;
    }

    public void setFirstNod(Nod firstNod) {
        this.firstNod = firstNod;
    }

    public Nod getLastNod() {
        return lastNod;
    }

    public void setLastNod(Nod lastNod) {
        this.lastNod = lastNod;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
