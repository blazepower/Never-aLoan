package main.java.Profile;


import com.sun.corba.se.impl.protocol.FullServantCacheLocalCRDImpl;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Profile {

    private String fName, lName, user, pass;
    private String bio;
    private Financial financialProfile;

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
        this.bio = bio;
    }

    void addFinacialInformation(int creditScore, int income) {
        this. financialProfile = Financial.of(creditScore, income);
    }
}
