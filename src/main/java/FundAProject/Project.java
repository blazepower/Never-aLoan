package main.java.FundAProject;

import main.java.Profile.*;
import main.java.lib.Description;

import java.math.BigDecimal;
import java.util.*;
import java.util.List;
import java.util.Objects;

public class Project {
    private String projectName;
    private BigDecimal totalLoan, intrestRate, progress;
    private List<Donation> donations;
    private Description projectDescription;

    private Project (String projectName, BigDecimal totalLoan, BigDecimal intrestRate) {
        this.projectName = projectName;
        this.totalLoan = totalLoan;
        this.intrestRate = intrestRate;
    }

    public static final Project of(String projectName, BigDecimal totalLoan, BigDecimal intrestRate) {
        return new Project(Objects.requireNonNull(projectName),
                Objects.requireNonNull(totalLoan), Objects.requireNonNull(intrestRate));
    }
    
    public void setProjectDescription(String description){
        this.projectDescription = Description.of(description);
    }

    void donate(Profile donor, BigDecimal donationAmount){
        donations.add(Donation.of(donor, donationAmount));
    }

    public String getProjectName(){
        return this.projectName;
    }

    public BigDecimal getProgress(){
        return this.progress;
    }
}
