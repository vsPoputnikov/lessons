package homework4;

public class Nod {
    int value;
    Nod nextNod;

    Nod(){

    }

    @Override
    public String toString() {
        return Integer.toString(this.value);
    }

    Nod(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Nod getNextNod() {
        return nextNod;
    }

    public void setNextNod(Nod nextNod) {
        this.nextNod = nextNod;
    }

    Nod(int value, Nod nextNod){
        this.value = value;
        this.nextNod = nextNod;
    }
}
