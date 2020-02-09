package main.java.Profile;


import main.java.FundAProject.Project;
import main.java.lib.Description;

import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Profile {

    private String fName, lName, user, pass;
    private Description bio;
    private Financial financialProfile;
    private HashMap<String, Project> myProjects;
    private List<Project> donatedTo;

    private Profile(String fName, String lName, String user, String pass) {
        this.fName = fName;
        this.lName = lName;
        this.user = user;
        this.pass = pass;
    }

    public static final Profile of(String fName, String lName, String user, String pass) {
        return new Profile(Objects.requireNonNull(fName), Objects.requireNonNull(lName),
                Objects.requireNonNull(user), Objects.requireNonNull(pass));
    }

    private static boolean verifyPassword(String p1, String p2) {
        return p1.equals(p2);
    }

    void setBio(String bio){
        this.bio = Description.of(bio);
    }

    void addFinacialInformation(int creditScore, int income) throws Exception {
        this.financialProfile = Financial.of(creditScore, income);
    }

    void createProject(String projectTitle, BigDecimal loanRequest, BigDecimal intrestRate) {
        Project newProject = Project.of(projectTitle, loanRequest, intrestRate);
        this.myProjects.put(newProject.getProjectName(), newProject);
    }

    public String getUserName() {
        return this.user;
    }

    public void addDonatedTo(Project p){
        this.donatedTo.add(p);
    }

    public List<Project> getDonated() {
         return this.donatedTo;
    }
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o instanceof Profile){
            Profile p = (Profile) o;
            return p.getUserName().equals(this.user);
        }
        return false;
    }
}
