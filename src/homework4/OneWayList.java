package homework4;

public class OneWayList {
    private Nod firstNod;

    public void remove() {
        Nod iter = this.getFirstNod();
        if (iter.getNextNod() != null) {
            while (iter.getNextNod().getNextNod() != null) {
                iter = iter.getNextNod();
            }
            iter.setNextNod(null);
        } else {
            this.setFirstNod(null);
        }

    }

    public void add(int value) {
        if (firstNod == null) {
            this.setFirstNod(new Nod(value));
        } else {
            Nod iter = this.getFirstNod();
            while (iter.getNextNod() != null) {
                iter = iter.getNextNod();
            }
            iter.setNextNod(new Nod(value));
        }
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
}