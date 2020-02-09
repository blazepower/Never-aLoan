package main.java.controller;

import main.java.Profile.Profile;
import main.java.data.ProfileDatabase;
import main.java.data.ProjectDatabase;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class Controller {
    ProfileDatabase profileDatabase = new ProfileDatabase(); //stores user info for sign in
    ProjectDatabase projectDatabase = new ProjectDatabase(); //holds all projects created for explorer page

    @PostMapping("/about")
    public int createProfile(@RequestBody String firstname, String lastName, String user,
                                 String password, String passwordVerf) {
        if (password.equals(passwordVerf)) {
            Profile newUser = Profile.of(firstname, lastName, user, password);
            profileDatabase.addProfile(newUser);
            System.out.println("oiajsdaflka;sfdlk;dsfamdlsfkmkfsdlkm'");
            return 1;
        } else {
            return -1;
        }
    }


}