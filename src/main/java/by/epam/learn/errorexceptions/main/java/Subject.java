package by.epam.learn.errorexceptions.main.java;

import by.epam.learn.errorexceptions.main.java.structure.SubjectName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subject {
    private SubjectName subjectName;
    private Map<Student, List<Integer>> mapOfStudents;

    public Subject(SubjectName subjectName) {
        this.subjectName = subjectName;
        mapOfStudents = new HashMap<>();
    }

    public void addStudentToMapOfStudents(Student student) {
        mapOfStudents.put(student, new ArrayList<>());

        student.addSubjectToStudent(subjectName);
    }

    public void addFacultyToMapOfStudents(Faculty faculty) {
        for (Group group : faculty.getGroups()) {
            addGroupToMapOfStudents(group);
        }
    }

    public void addGroupToMapOfStudents(Group group) {
        for (Student student : group.getStudents()) {
            addStudentToMapOfStudents(student);
            student.addSubjectToStudent(subjectName);
        }
    }

    public void addGradeToStudent(Student student, int grade) {
        List<Integer> newGrades = mapOfStudents.get(student);
        newGrades.add(grade);
        mapOfStudents.put(student, newGrades);

        student.addGradeToStudent(subjectName, newGrades);
    }

    public List<Integer> getGradesOfSpecificStudent(Student student) {
        return mapOfStudents.get(student);
    }


}
