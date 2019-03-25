package homework6;

import java.util.Arrays;

public class Pupil {
    String id;
    public ExamResult[] examResults;

    Pupil(String id){
        this.id = id;
    }
    public void setExams(String[] ex, int[] marks){
        this.examResults = new ExamResult[ex.length];
        for (int i = 0; i < ex.length; i++) {
            this.examResults[i] = new ExamResult(ex[i], marks[i]);
        }
    }

    @Override
    public String toString() {
        return "Pupil{" +
                "id='" + id + '\'' +
                ", examResults=" + Arrays.toString(examResults) +
                '}';
    }

    class ExamResult{
        String ex;
        int mark;

        public ExamResult(String ex, int mark) {
            this.ex = ex;
            this.mark = mark;
        }

        @Override
        public String toString() {
            {
                if (this.pass()){
                    return this.ex + " Сдано";
                }    else
                    return this.ex + " Не сдано";
            }
        }
        public boolean pass(){
            if (mark>2)
                return true;
            else
                return false;
        }
    }
}

