package by.epam.learn.errorexceptions;

import by.epam.learn.errorexceptions.main.java.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class University {
    private List<Faculty> faculties;
    private Map<Integer, Group> mapOfGroups;

    public University(List<Faculty> faculties) {
        this.faculties = faculties;
        addGroupsToMap(faculties);
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public Group getGroupById(int groupId) {
        return mapOfGroups.get(groupId);
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
