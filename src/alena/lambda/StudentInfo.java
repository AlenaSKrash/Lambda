package alena.lambda;

import java.util.ArrayList;

public class StudentInfo {
    public static void main(String[] args) {
        Student s1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student s2 = new Student("Nik  ", 'm', 28, 2, 6.3);
        Student s3 = new Student("Elena", 'f', 19, 1, 8.6);
        Student s4 = new Student("Petr", 'm', 35, 4, 7);
        Student s5 = new Student("Alena", 'f', 22, 3, 9.3);

        ArrayList<Student> students = new ArrayList<>();

        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);

        StudentInfo1 info1 = new StudentInfo1();

        // тут у нас функциональный интерфейс
        info1.testStudent(students, new StudentCheck() {
            @Override
            public boolean check(Student s) {
                return s.age < 30;
            }
        });


        info1.testStudent(students, (Student s) -> {
            return s.age < 30;
        });

        //printStudentUnderAge
        info1.testStudent(students, s -> s.age < 30);

        //printStudentOverGrade

        info1.testStudent(students, s -> s.avgGrade < 9.9);


        //printStudentsMixCondition

        info1.testStudent(students, s -> s.age > 35 && s.avgGrade < 9.0 && s.sex == 'f');


        //отсортировать при помощи Compartor<Student>**
    }

    void printStudentOverGrade(ArrayList<Student> list, double grade) {
        for (Student s : list) {
            if (s.avgGrade > grade) {
                System.out.println(s);
            }
        }
    }

    void printStudentUnderAge(ArrayList<Student> al, int age) {
        for (Student s : al) {
            if (s.age > age) {
                System.out.println(s);
            }
        }
    }

    void printStudentsMixCondition(ArrayList<Student> al, int age, double grade, char sex) {
        for (Student s : al) {
            if (s.age > age && s.avgGrade < grade && s.sex == sex) {
                System.out.println(s);
            }
        }
    }
}