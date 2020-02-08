package main.java.FundAProject;

import main.java.Profile.Profile;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Objects;

public class Donation {
    BigDecimal donationAmount;
    Profile donor;

    private Donation(Profile donor, BigDecimal donationAmount) {
        this.donationAmount = donationAmount;
        this.donor = donor;
    }

    public static final Donation of(Profile donor,  BigDecimal donationAmount) {
        return new Donation(Objects.requireNonNull(donor), Objects.requireNonNull(donationAmount));
    }

    public BigDecimal getDonationAmount() {
        return this.donationAmount;
    }

    public Profile getDonor() {
        return this.donor;
    }
}
