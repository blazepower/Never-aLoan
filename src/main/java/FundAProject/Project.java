package FundAProject;

import Profile.*;
import main.java.lib.Description;

import java.math.BigDecimal;
import java.util.*;
import java.util.List;
import java.util.Objects;

public class Project {
    private String projectName;
    private BigDecimal totalLoan, intrestRate, progress;
    private List<FundAProject.Donation> donations;
    private Description projectDescription;
    private String description;
    private static Integer id = 0;

    private Project (String projectName, BigDecimal totalLoan, BigDecimal intrestRate) {
        this.projectName = projectName;
        this.totalLoan = totalLoan;
        this.intrestRate = intrestRate;
        id++;
    }

    public static final Project of(String projectName,  BigDecimal totalLoan, BigDecimal intrestRate) {
        return new Project(Objects.requireNonNull(projectName),
                Objects.requireNonNull(totalLoan), Objects.requireNonNull(intrestRate));
    }

    public static final Project of(String projectName,  BigDecimal totalLoan) {
        return new Project(Objects.requireNonNull(projectName),
                Objects.requireNonNull(totalLoan), Objects.requireNonNull(intrestRate));
    }
    
    public void setProjectDescription(String description){
        this.projectDescription = Description.of(description);
    }

    void donate(Profile donor, BigDecimal donationAmount){
        donations.add(FundAProject.Donation.of(donor, donationAmount));
    }

    public String getProjectName(){
        return this.projectName;
    }

    public BigDecimal getProgress(){
        return this.progress;
    }

    public Integer getId(){
        return this.id;
    }
}
