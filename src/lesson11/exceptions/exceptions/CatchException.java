package lesson11.exceptions.exceptions;

public class CatchException {
    public static void main(String[] args) {
        int a = 9;
        int b = 0;
       // System.out.println(a/b); // Arithmetical exception

        // Попытка получить 10 ый элемент массива из 5 эл.
        int[] arr = new int[5];
       /* arr[10]=8;
        System.out.println(Arrays.toString(arr));

        String str = null;
        str.equals("string"); // null pointer exception

        Integer.parseInt("asd");*/ // numberFormatException

        // Обработка исключений осуществляется при помощи конструктора try catch

        Object data = "42";
        /*Integer intData = (Integer)data;*/ // class cast exception
        try{
            Integer intData = (Integer)data;
            System.out.println("after exception inside try");
        } catch (ClassCastException e){
            System.out.println("class cast exception" + e.getMessage());
        }


        /*try{
            if(System.currentTimeMillis()%2==0){
                Integer intData = (Integer)data;
            }else{
                arr[23]=12;
            }
        } catch (ClassCastException e){
            System.out.println("all exceptions " + e.getMessage());
            e.printStackTrace();
        }*/

        /*catch (ClassCastException e){
            System.out.println("ClassCast");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOut");
        }*/
        /*catch (ClassCastException|ArrayIndexOutOfBoundsException e){
            System.out.println("one ore another");
        }*/

        // все исключения наследуются от RuntimeException
        finally {
            System.out.println("выполнНО");
            // высвобождение ресурсов занятых в try
        }
        try {
            voidWithException();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void voidWithException() throws Exception {
        // Обрабатываемые исключения (checked exception)
        //throw new Exception("Some Exception");
        throw new CheckedException("kojkll");
    }
    public static void voidWithCheckedException (int i)throws CheckedException{
        if(i<10){
            throw new CheckedException("bad data");
        }
    }


}
