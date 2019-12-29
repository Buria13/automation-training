package by.epam.learn.errorexceptions.main.java;

import by.epam.learn.errorexceptions.main.java.structure.SubjectName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subject {
    private SubjectName subjectName;
    private Map<Student, List<Integer>> grades;

    public Subject(SubjectName subjectName) {
        this.subjectName = subjectName;
        grades = new HashMap<>();
    }

    public void addSubjectToStudent(Student student) {
        grades.put(student, new ArrayList<>());
    }

    public void addSubjectToGroup(Group group) {

    }

    public List<Integer> getGradesOfSpecifyStudent(Student student) {
        return grades.get(student);
    }

    public void addGradeToStudent(Student student, int grade) {
        List<Integer> newGrades = grades.get(student);
        newGrades.add(grade);
        grades.put(student, newGrades);
    }


}
