package main.java.FundAProject;

import main.java.Profile.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Project {
    private String projectName;
    private BigDecimal loan;
    private BigDecimal intrestRate;
    private BigDecimal progress;
    private List<Profile> donors;

    private Project (String projectName, BigDecimal loan, BigDecimal intrestRate) {
        this.projectName = projectName;
        this.loan = loan;
        this.intrestRate = intrestRate;
    }

    public static final Project of(String projectName, BigDecimal loan, BigDecimal intrestRate) {
        return new Project(Objects.requireNonNull(projectName),
                Objects.requireNonNull(loan), Objects.requireNonNull(intrestRate));
    }


}
