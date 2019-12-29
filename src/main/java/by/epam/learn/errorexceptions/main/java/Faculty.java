package by.epam.learn.errorexceptions.main.java;

import by.epam.learn.errorexceptions.main.java.structure.FacultyName;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private List<Group> groups;
    private FacultyName facultyName;

    public Faculty(FacultyName facultyName, List<Group> groups) {
        this.facultyName = facultyName;
        this.groups = groups;
    }

    public Faculty(FacultyName facultyName, Group group) {
        this.facultyName = facultyName;
        groups = new ArrayList<>();
        groups.add(group);
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public Group getGroupById(int groupId) {
        for (Group group : groups) {
            if (group.getGroupId() == groupId) {
                return group;
            }
        }
        return null;
    }

    public Student getStudentById(int studentId) {
        for (Group group : groups) {
            group.getStudentById(studentId);
        }
        return null;
    }

    public Student getStudentByName(String studentName) {
        for (Group group : groups) {
            group.getStudentByName(studentName);
        }
        return null;
    }


    @Override
    public String toString() {
        return "\nFaculty{" + facultyName +
                "\ngroups=" + groups +
                '}';
    }
}
