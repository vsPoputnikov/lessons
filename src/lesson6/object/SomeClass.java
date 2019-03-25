package lesson6.object;


public class SomeClass {
    private SomeClass(){}
    private static final SomeClass obj = new SomeClass();
    public static void main(String[] args) {
        SomeClass2 sc2 = new SomeClass2();
        sc2.someVoid();
    }
    final static SomeClass getObj(){
        return obj;
    }

    public void printInfo(String string){
        System.out.println("info"+ string);
    }
}

class SomeClass2{
    public void someVoid(){

        SomeClass someClass = SomeClass.getObj();
     someClass.printInfo("data");
            }

    }

