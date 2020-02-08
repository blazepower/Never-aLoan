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

    /**
     *
     * @param file
     * @throws IOException
     */
    @PutMapping("/people/profile")
    public void setProfilePicture(File file) throws IOException {
        BufferedImage image = ImageIO.read(file);
        ImageIcon icon=new ImageIcon(image);
        JFrame frame=new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(200,300);
        JLabel lbl=new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
