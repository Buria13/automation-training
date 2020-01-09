package by.epam.learn.errorexceptions;

import by.epam.learn.errorexceptions.main.java.*;
import by.epam.learn.errorexceptions.main.java.structure.SubjectName;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class University {
    private List<Faculty> faculties;
    private Map<Integer, Group> mapOfGroups;
    private List<Subject> subjectsList;

    public University(List<Faculty> faculties, List<Subject> listOfSubjects) {
        this.faculties = faculties;
        this.subjectsList = listOfSubjects;
        addGroupsToMap(faculties);
    }

    public List<Subject> getSubjectsList() {
        return subjectsList;
    }

    public Subject getSubject(SubjectName subjectName) {
        for (Subject subject : subjectsList) {
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

    public double getAverageGradeOfStudentInAllSubjects(Student student) {
        double averageGrades = 0;
        List<SubjectName> subjectsList = student.getListOfSubjects();

        for (SubjectName subjectName : subjectsList) {
            averageGrades += getSubject(subjectName).getAverageGradeOfStudent(student);
        }

        return round(averageGrades / subjectsList.size());
    }

    public double getAverageGradeOfFacultyInSpecificSubject(Faculty faculty, Subject subject) {
        double averageGrades = 0;
        List<Group> groupList = faculty.getGroups();

        for (Group group : groupList) {
            averageGrades += getAverageGradeOfGroupInSpecificSubject(group, subject);
        }

        return round(averageGrades / groupList.size());
    }

    public double getAverageGradeOfGroupInSpecificSubject(Group group, Subject subject) {
        double averageGrades = 0;
        List<Student> studentList = group.getStudents();

        for (Student student : studentList) {
            averageGrades += subject.getAverageGradeOfStudent(student);
        }

        return round(averageGrades / studentList.size());
    }

    public double getAverageGradeOfUniversityInSpecificSubject(Subject subject) {
        double averageGrades = 0;
        Set<Student> studentList = subject.getStudentsMap().keySet();

        for (Student student : studentList) {
            averageGrades += subject.getAverageGradeOfStudent(student);
        }

        return round((averageGrades / studentList.size()));
    }

    private double round(double number) {
        return (double) Math.round(number * 10) / 10;
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
