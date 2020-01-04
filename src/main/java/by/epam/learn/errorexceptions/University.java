package by.epam.learn.errorexceptions;

import by.epam.learn.errorexceptions.main.java.*;
import by.epam.learn.errorexceptions.main.java.structure.SubjectName;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class University {
    private List<Faculty> faculties;
    private Map<Integer, Group> mapOfGroups;
    private List<Subject> listOfSubjects;

    public University(List<Faculty> faculties, List<Subject> listOfSubjects) {
        this.faculties = faculties;
        this.listOfSubjects = listOfSubjects;
        addGroupsToMap(faculties);
    }

    public Subject getSubject(SubjectName subjectName) {
        for (Subject subject : listOfSubjects) {
            if (subject.getSubjectName() == subjectName) {
                return subject;
            }
        }
        return null;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public Group getGroupById(int groupId) {
        return mapOfGroups.get(groupId);
    }

    public Student getStudentById(int studentId) {
        for (Faculty faculty : faculties) {
            Student student = faculty.getStudentById(studentId);
            if (student != null) return student;
        }
        return null;
    }

    public Student getStudentByName(String studentName) {
        for (Faculty faculty : faculties) {
            Student student = faculty.getStudentByName(studentName);
            if (student != null) return student;

        }
        return null;
    }

    private void addGroupsToMap(List<Faculty> faculties) {
        mapOfGroups = new HashMap<>();

        for(Faculty faculty : faculties) {
            for (Group group : faculty.getGroups()) {
                mapOfGroups.put(group.getGroupId(), group);
            }
        }
    }


    @Override
    public String toString() {
        return "University{" +
                "\nfaculties=" + faculties +
                '}';
    }
}
