package lesson1;

       public class Lesson1 {
//     Точка входа
            // Однострочный комментарий
   /*
   многострочный
   комментарий
    */


            public static void main(String[] args) {
                System.out.println("Hello World! again");
//    Примитивные типы
       /* byte (целые числа, 1 байт)
        short (целые числа, 2 байта)
        int  (целые числа, 4 байта)
        long (целые числа, 8 байта)
        float (вещественные числа, 4 байта)
        double(вещественные числа, 8 байта)
        char (символ Unicode, 2 байта)
        boolean (логический тип, true/false, 1 байт)*/

       /*
        объявление переменной
        типДанных имяПеременной = значение;
        типДанных имяПеременной;
        имяПеременной = значение;
        типДанных имяПеременной1, имяПеременной2, имяПеременной3;

        Целочисленные типы данных.*/

                byte byteVar; // -127..128
                short shortVar1 = 5;
                short shortVar2 = 38;
                int shortVar3 = shortVar1 + shortVar2; //при вычислении short вычисления происходят в типе int
                int intVar1 = 1_000_000;
                int a = 9;
                int c = 5;
                int res = a/c; // при делении целых чисел остаток отбрасывается. деление на ноль - ошибка.
                long longVar = 200000000000L;// Необходимо ставить букву L, чтобы число воспринималось как long
                // Числа с плавающей точкой
                // Для вычислений высокой точности нужно использовать сторонние библиотеки
                float floatVar = 2.3F;//f чтобы воспринималось как float
                double doubleVar = 2.3;

                boolean isActive = true;// используется для хранения состояния объекта и для условий
                boolean started = false;

                // Два типа преобразования типов:
                // Автоматическое - происходит, если длинна целевого контейнера больше типа.
                // Приведение типов
                int j = 200;
                long k = j;
                long n = 90;
           /* Ошибка компилляции
            int m = n;
            */
                int m = (int)n; // приведение типов
                // Boolean - неприводимый тип

                // Операторы
                // + - * / %
                // % - остаток от деления
                // результат арифметических операций приводится к наивысшему участвовавшему типу

                // ++ --

                // операторы сравнения
                // < > == >= <= !=

                // Логические операторы
                // &&(and) ||(or) !(not) ^(xor)

                // Операторы присваивания
                // = += *= /= -= %=

                // Тернарный оператор
                // переменная a = (условие)?выражение1(true) : выражение2(false);



                /*Ссылочные типы
                 */

            }
        }


