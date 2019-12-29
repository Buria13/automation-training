package by.epam.learn.errorexceptions;

import by.epam.learn.errorexceptions.main.java.*;
import by.epam.learn.errorexceptions.main.java.structure.*;

import java.util.Arrays;
import java.util.List;

public class ErrorExceptionsDemo {

    private static List<Student> listOfStudents = Arrays.asList(
            new Student("Siarhei Burets"),
            new Student("Ivan Ivanov"),
            new Student("Petr Petrov")
    );
    private static List<Student> listOfStudents2 = Arrays.asList(
            new Student("Al Pacino"),
            new Student("Tom Cruise"),
            new Student("Robert De Niro")
    );
    private static List<Student> listOfStudents3 = Arrays.asList(
            new Student("Bill Gates"),
            new Student("Elon Musk"),
            new Student("Mark Zuckerberg")
    );
    private static List<Student> listOfStudents4 = Arrays.asList(
            new Student("Leo Messi"),
            new Student("Cristiano Ronaldo"),
            new Student("Andriy Shevchenko")
    );


    public static void main(String[] args) {
        Faculty fitu = new Faculty(FacultyName.FITiU, Arrays.asList(
                new Group(120404, listOfStudents),
                new Group(120403, listOfStudents2)
        ));

        Faculty fksis = new Faculty(FacultyName.FKSiS, new Group(110601, listOfStudents3));
        fksis.addGroup(new Group(110602, listOfStudents4));

        University bguir = new University(Arrays.asList(
                fitu,
                fksis
        ));

        //System.out.println(bguir.getFaculties());

        System.out.println(bguir.getGroupById(120404).getStudentByName("Burets"));
    }
}
