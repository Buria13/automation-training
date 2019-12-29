package by.epam.learn.errorexceptions.main.java;

import java.util.List;

public class Student {
    private static int countId = 0;
    private int studentId;
    private String name;
    private List<Subject> subjects;

    public Student(String name) {
        this.studentId = ++countId;
        this.name = name;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }


    @Override
    public String toString() {
        return "\n    Student{" +
                "Id=" + studentId +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return (studentId == student.studentId)
                && (name.equals(student.name));
    }

    @Override
    public int hashCode() {
        return 31 * studentId + name.hashCode();
    }
}
