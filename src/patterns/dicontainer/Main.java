package patterns.dicontainer;

import patterns.dicontainer.di.Container;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Class> classes = new ArrayList<>();
        classes.add(Cat.class);
        classes.add(Dog.class);
        classes.add(Human.class);
        try {
            new Container(classes).start();
        } catch (NoSuchMethodException
                | IllegalAccessException
                | InvocationTargetException
                | InstantiationException
                | IOException e) {
            e.printStackTrace();
        }
    }
}
