package alena.lambda;

import java.util.ArrayList;

public class StudentInfo1 {
    void testStudent(ArrayList<Student> al, StudentCheck sC) {
        for (Student s : al) {
            if (sC.check(s)) {
                System.out.println(s);
            }
        }
    }
}

class CheckOverGrade implements StudentCheck {

    @Override
    public boolean check(Student s) {
        return s.avgGrade > 8;
    }
}