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

    public SubjectName getSubjectName() {
        return subjectName;
    }

    public void addSubjectToFaculty(Faculty faculty) {
        for (Group group : faculty.getGroups()) {
            addSubjectToGroup(group);
        }
    }

    public void addSubjectToGroup(Group group) {
        for (Student student : group.getStudents()) {
            addStudentToMapOfStudents(student);
            student.addSubjectToStudent(subjectName);
        }
    }

    private void addStudentToMapOfStudents(Student student) {
        mapOfStudents.put(student, new ArrayList<>());

        student.addSubjectToStudent(subjectName);
    }

    public void addGradeToStudent(Student student, int grade) {
        mapOfStudents.get(student).add(grade);
        student.addGradeToStudent(subjectName, grade);
    }

    public List<Integer> getGradesOfSpecificStudent(Student student) {
        return mapOfStudents.get(student);
    }


}
