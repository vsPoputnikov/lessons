package lambda;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfacesExample {
    public static void main(String[] args) {
        // встроенные функциональные интерфейсы
        // Интерфейс Predicate<T>
//        метод: boolean test(T t);
//        default методы:
//            and(Predicate other);
//            or(Predicate other);
//            negative();
        Predicate<Integer> pos = (num)->{
            return num>0;
        };
        Predicate<Integer> neg = (num)->num<0;
        Predicate<Integer> four = (num)->num==4;

        System.out.println(pos.test(45));
        System.out.println(neg.test(45));

        System.out.println(pos.and(four).or(neg).test(-4));

        // Interface Function<T,R> принимает значение в качестве аргумента одного типа (T)
        //и возвращает другое (R)
        // метод: R apply(T t)
        // default methods:
        // andThan(Function after)
        //compose(Function before)

        Function<Integer,String> convert = a->a+"$";
        System.out.println(convert.apply(45));
        Function<Integer, Double> tenPersent = a->a*0.1;

        Function<Integer,Integer> plusTen = a->a+10;
        Function<Integer,Integer> plusFive = a->a+5;
        double res = plusTen.andThen(plusFive).andThen(tenPersent).apply(20);

        // Задача: дан предикат condition и две функции (Function) ifTrue ifFalse
        // Написать метод, который вернёт новую функцию(Function) возвращающую значение функции ifTrue,
        // если condition true

        Predicate<Integer> condition = num->num>0;
        Function<Integer,Integer> ifTrue = a->a+10;
        Function<Integer,Integer> ifFalse = a->a-10;
        Function<Integer,Integer> func = getFunction(condition,ifTrue,ifFalse);


        // Интерфейс Consumer<T> принимает значение и ничего не возвращает
        // метод void accept();
        // default method: andThen(Consumer<T> after)

        // BinaryOperator<T>, UnaryOperator<T>

        }
    public static Function<Integer,Integer> getFunction(Predicate<Integer> condition,
                                                        Function<Integer,Integer> ifTrue,
                                                        Function<Integer,Integer> ifFalse){
        return a->condition.test(a)?ifTrue.apply(a):ifFalse.apply(a);
    }

}
