package lesson3;

import java.util.Arrays;

public class StringsClass {
    public static void main(String[] args) {
        String string = "строка"; // до 9ой версии java это массив char, после - массив byte + кодировка (utf16/latin 1)
        String string2 = "строка"; // Попадает в пул строк в куче. ссылка скопирована
        String string3 = new String("строка"); // Создаётся как объект не в пуле строк
        string3 = string3.intern(); // Добавляет объект в пул строк принудительно

        // Сравнение строк
        System.out.println(string == string2);
        System.out.println(string == string3);
        System.out.println(string.equals(string3));
        // Сравнение без учёта регистра
        System.out.println(string.equalsIgnoreCase(string3));

        System.out.println(string.startsWith("ст"));
        System.out.println(string.endsWith("ка"));
        // Сортировка строк
        String[] strArr = {string, string2, string3};
        Arrays.sort(strArr);

        // Конкатенация строк(склеивание)
        String string5 = "Str 1";
        String string6 = "Str 2";
        String string7 = string5 + string6;
        String string8 = "Begin";
        for (int i = 0; i < 3; i++) {
            string8 += " iteration"; // Каждый раз создаётся новый объект. не рекомендуется
        }
        System.out.println(string8);

        StringBuilder stringBuilder;// работает быстрее, но не потокобезопасен
        StringBuffer stringBuffer;// поддерживает потоки
        String string9 = "Begin";
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(string9);
        for (int i = 0; i < 3; i++) {
            stringBuilder1.append(" iteration").append(i)
                    .append("it "); // Каждый раз создаётся новый объект. не рекомендуется
        }
        string9 = stringBuilder1.toString();
        System.out.println(string9);
        System.out.println(stringBuilder1);

        // Методы работы со строками
        string9.substring(2);
        System.out.println(string9.substring(2, 4));
        System.out.println(Arrays.toString(string9.split(""))); // разбивает строку на массив строк по регулярному выражению
        System.out.println(string9.trim());// удаляет пробелы в начале и конце
        string9.replaceAll("", "new str");
    }
}
