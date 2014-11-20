/**
 * Created by BirthrightL on 11.11.2014.
 */
public class Преподаватель {
    private String fio;
    private String subject;

    public Преподаватель(String s, String y) {
        fio = s;
        subject = y;
    }

    public String getFio() {
        return fio;
    }

    public String getSubject() {
        return subject;
    }

    public void setFio(String s) {
        fio = s;
    }

    public void setSubject(String y) {
        subject = y;
    }

    public void RateStudent(Student a) {
        int s = 2 + (int) (Math.random() * 4);
        String g;
        if (s == 5) {
            g = "Отлично";
        } else {
            if (s == 4) {
                g = "Хорошо";
            } else {
                if (s == 3) {
                    g = "Удовлетворительно";
                } else {
                    g = "Неудовлетворительно";
                }
            }
        }
        System.out.println("Преподаватель " + fio + " оценил студента с именем " + a.getFio() + " по предмету " + subject + " на оценку " + g);
    }
}


