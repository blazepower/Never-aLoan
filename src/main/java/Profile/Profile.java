package main.java.Profile;


import main.java.FundAProject.Project;
import main.java.lib.Description;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Objects;

public class Profile {

    private String fName, lName, user, pass;
    private Description bio;
    private Financial financialProfile;
    private HashMap<String, Project> projects;

    private Profile(String fName, String lName, String user, String pass) {
        this.fName = fName;
        this.lName = lName;
        this.user = user;
        this.pass = pass;
    }

    public static final Profile of(String fName, String lName, String user, String pass, String passVer) throws Exception {
        if(verifyPassword(pass, passVer)){
            return new Profile(Objects.requireNonNull(fName), Objects.requireNonNull(lName),
                    Objects.requireNonNull(user), Objects.requireNonNull(passVer));
        } else {
            throw new Exception("Passwords do not match");
        }
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
        this.projects.put(newProject.getProjectName(), newProject);
    }
}
