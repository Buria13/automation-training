package by.epam.learn.errorexceptions.main.java;

import by.epam.learn.errorexceptions.main.java.structure.SubjectName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subject {
    private SubjectName subjectName;
    private Map<Student, List<Integer>> studentsMap;

    public Subject(SubjectName subjectName) {
        this.subjectName = subjectName;
        studentsMap = new HashMap<>();
    }

    public SubjectName getSubjectName() {
        return subjectName;
    }

    public Map<Student, List<Integer>> getStudentsMap() {
        return studentsMap;
    }

    public void addSubjectToFaculty(Faculty faculty) {
        for (Group group : faculty.getGroups()) {
            addSubjectToGroup(group);
        }
    }

    public void addSubjectToGroup(Group group) {
        for (Student student : group.getStudents()) {
            studentsMap.put(student, new ArrayList<>());
            student.addSubjectToStudent(subjectName);
        }
    }

    public void addGradeToStudent(Student student, int grade) {
        studentsMap.get(student).add(grade);
    }

    public double getAverageGradeOfStudent(Student student) {
        double averageGrade = 0;
        List<Integer> grades = studentsMap.get(student);

        averageGrade += (double) (grades.stream()
                .reduce((o1, o2) -> o1 + o2)
                .orElse(null))
                / grades.size();

        return averageGrade;
    }


    public List<Integer> getGradesOfSpecificStudent(Student student) {
        return studentsMap.get(student);
    }




}
