package by.epam.learn.errorexceptions;

import by.epam.learn.errorexceptions.main.java.*;
import by.epam.learn.errorexceptions.main.java.structure.*;

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

        University bguir = new University(Arrays.asList(
                fitu,
                fksis
        ));

        Subject mathematics = new Subject(SubjectName.MATHEMATICS);
        Subject physics = new Subject(SubjectName.PHYSICS);
        Subject programming = new Subject(SubjectName.PROGRAMMING);
        Subject philosophy = new Subject(SubjectName.PHILOSOPHY);

        Group group = fitu.getGroupById(120404);

        physics.addFacultyToMapOfStudents(fitu);

        Student student = bguir.getStudentByName("Burets");

        mathematics.addStudentToMapOfStudents(student);
        mathematics.addGradeToStudent(student, 9);
        mathematics.addGradeToStudent(student, 3);
        mathematics.addGradeToStudent(student, 7);
        System.out.println(mathematics.getGradesOfSpecificStudent(student));
        System.out.println();
        System.out.println(student.getGrades());

        System.out.println();



        //System.out.println(bguir.getFaculties());

    }
}
