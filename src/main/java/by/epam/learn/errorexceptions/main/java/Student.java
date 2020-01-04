package by.epam.learn.errorexceptions.main.java;

import by.epam.learn.errorexceptions.main.java.structure.SubjectName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private static int countId = 0;
    private int studentId;
    private String name;
    private Map<SubjectName, List<Integer>> grades;

    public Student(String name) {
        this.studentId = ++countId;
        this.name = name;
        this.grades = new HashMap<>();
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public Map<SubjectName, List<Integer>> getGrades() {
        return grades;
    }

    public void addSubjectToStudent(SubjectName subjectName) {
        grades.put(subjectName, new ArrayList<>());
    }

    public void addGradeToStudent(SubjectName subjectName, int grade) {
        grades.get(subjectName).add(grade);
    }

    public double getAverageGrade() {
        double averageGrades = 0;

        for (Map.Entry<SubjectName, List<Integer>> subject : grades.entrySet()) {
            averageGrades += (double) (subject.getValue().stream()
                    .reduce((o1, o2) -> o1 + o2)
                    .orElse(0))
                    / subject.getValue().size();
        }

        return (double) Math.round((averageGrades / grades.size()) * 10) / 10;
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
