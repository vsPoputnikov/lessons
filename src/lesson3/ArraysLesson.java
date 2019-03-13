package lesson3;

import java.util.Arrays;

public class ArraysLesson {
    public static void main(String[] args) {
        // java.util.Arrays
        // Объявление массива
        int[] arr;// предпочтительный способ
        int arr2[];
        arr = new int[5]; //Значение по умолчанию ноль
        System.out.println(Arrays.toString(arr));
        //Инициализирующие значения по умолчанию:
//        int = 0;
//        bool = false;
//        object = null;
//        char = "";
        int arrLength = arr.length;
        System.out.println("Длина массива " + arrLength);
        // Создание инициализированного массива
        int[] arr3 = {2, 4, 8};
        arr3 = new int[]{2, 6};
        //обращение к элементам
        System.out.println(arr3[1]);

        int[] arr4 = new int[4];
        for (int i = 0; i<arr4.length; i++){
            arr4[i] += 4;
        }
        System.out.println(Arrays.toString(arr4));

        // Array coping
        int[] arr5 = {2, 7, 1, 90};
        //int[] arr6 = arr5;
        int[] arr6 = arr5.clone();
        int[] arr7 = new int[10];
        System.arraycopy(arr5, 1,arr7, 4,2);
        System.out.println(Arrays.toString(arr7));
        int[] arr8 = {2, 7, 1, 90};
        int[] copyArr = Arrays.copyOf(arr8, 12 );
        System.out.println(Arrays.toString(copyArr));

        // Перебор массива
        // Цикл for позволяет менять элементы массива
        for(int i = 0; i<arr8.length;i++){
            System.out.println(arr8[i]);
            arr8[i] += 3;
        }
        System.out.println(Arrays.toString(arr8));

        // Цикл for each
        for(int num: arr8){ // num - тип перебираемых элементов
            System.out.println(num);
            num += 3; // не меняет изменения
        }
        System.out.println(Arrays.toString(arr8));

        int[] arr9 = new int[5];
        int[] arr10 = new int[5];

        System.out.println(arr9 == arr10); //false
        System.out.println(arr9.equals(arr10));// false

        System.out.println(Arrays.equals(arr9,arr10)); // Сравнение по содержимому!
        // Если сравниваются многомерные массивы, то Arrays.deepequals
        Arrays.fill(arr9,23);

        // Search in array
        int[] arr11 = {2,4,6,1,89};
        System.out.println(Arrays.binarySearch(arr11,4));
        // -(точка входа)-1 возвращает если не найден
        String[] strArr = {"qwe","asd","zxc"};
        System.out.println(Arrays.asList(strArr).contains("qwe"));

        // Сортировка массивов
        Arrays.sort(arr11); // Метод быстрой сортировки
    }
}
