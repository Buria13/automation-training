package by.epam.learn.errorexceptions;

import by.epam.learn.errorexceptions.main.java.*;
import by.epam.learn.errorexceptions.main.java.structure.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ErrorExceptionsDemo {

    private static List<Student> listOfStudents = Arrays.asList(
            new Student("Siarhei Burets"),
            new Student("Ivan Ivanov"),
            new Student("Petr Petrov"),
            new Student("Al Pacino"),
            new Student("Tom Cruise"),
            new Student("Robert De Niro"),
            new Student("Bill Gates"),
            new Student("Elon Musk"),
            new Student("Mark Zuckerberg"),
            new Student("Leo Messi"),
            new Student("Cristiano Ronaldo"),
            new Student("Andriy Shevchenko")
    );


    public static void main(String[] args) {

        Faculty fitu = new Faculty(FacultyName.FITiU, Arrays.asList(
                new Group(120404, listOfStudents.subList(0, 3)),
                new Group(120403, listOfStudents.subList(3, 6))
        ));

        Faculty fksis = new Faculty(FacultyName.FKSiS, new Group(110601, listOfStudents.subList(6, 9)));
        fksis.addGroup(new Group(110602, listOfStudents.subList(9, 12)));

        List<Subject> listOfSubjects = new ArrayList<>(Arrays.asList(
                new Subject(SubjectName.MATHEMATICS),
                new Subject(SubjectName.PHYSICS),
                new Subject(SubjectName.PROGRAMMING),
                new Subject(SubjectName.PHILOSOPHY)
        ));

        University bguir = new University(Arrays.asList(
                fitu,
                fksis
        ), listOfSubjects);

        // Добавляем на факультеты случайные предметы и ставим случайные оценки студентам
        for (Subject subject : listOfSubjects) {
            for (Faculty faculty : bguir.getFaculties()) {
                if (Math.random() > 0.5) {
                    subject.addSubjectToFaculty(faculty);
                    setRandomGradesToStudents(faculty, subject);
                }
            }
        }

        Subject mathematics = bguir.getSubject(SubjectName.MATHEMATICS);

        Student student = bguir.getStudentByName("Burets");

        System.out.println(student.getGrades());
        System.out.println();
        System.out.println("Средняя оценка студента: " + student.getAverageGrade());

    }


    private static void setRandomGradesToStudents(Faculty faculty, Subject subject) {
        for (Group group : faculty.getGroups()) {
            for (Student student : group.getStudents()) {
                for (int i = 0; i < 10; i++) {
                    int randomGrade = (int) (Math.random() * 9) + 2;
                    subject.addGradeToStudent(student, randomGrade);
                }
            }
        }
    }

}
