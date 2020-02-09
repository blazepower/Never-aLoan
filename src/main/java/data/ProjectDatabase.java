package main.java.data;

import main.java.FundAProject.Project;
import main.java.Profile.Profile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProjectDatabase {
    HashMap<Profile, List<Project>> projects;

    public ProjectDatabase() {
        this.projects = new HashMap<>();
    }

    public void addProject(Profile owner, Project project) {
        List<Project> pList = new ArrayList<>();
        if(this.projects.containsKey(owner)){
            pList = this.projects.get(owner);
            pList.add(project);
            this.projects.replace(owner, pList);
        }else {
            pList.add(project);
            this.projects.put(owner, pList);
        }
    }

    public List<Project> getProjects(Profile user){
        return this.projects.get(user);
    }
}
