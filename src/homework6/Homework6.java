package homework6;

public class Homework6 {
    public static void main(String[] args) {
        Pupil pupil = new Pupil("Василий");
        String ex[] = {"Математика","Биология", "ОБЖ"};
        int marks[] = { 2, 5, 3 };
        pupil.setExams(ex, marks);
        System.out.println(pupil);
    }
}
