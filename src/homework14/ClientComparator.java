package homework14;

import java.util.Comparator;

public class ClientComparator implements Comparator<Client> {
    @Override
    public int compare(Client o1, Client o2) {
        return (o1.getSecondName()+" "+o1.getFirstName()).compareTo(o2.getSecondName()+" "+o2.getFirstName());
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
