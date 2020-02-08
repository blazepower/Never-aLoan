package Profile;


import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Profile {

    private String fName, lName;

    private Profile()

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

    @PutMapping("/people/profile")
    public void setFirstName(String fName){
        this.fName = fName;
    }

    @PutMapping("people/profile")
    public void setLastName(String lName){
        this.lName = lName;
    }

}
