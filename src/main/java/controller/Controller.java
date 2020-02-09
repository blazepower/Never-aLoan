package main.java.controller;

import main.java.FundAProject.Project;
import main.java.Profile.Profile;
import main.java.data.ProfileDatabase;
import main.java.data.ProjectDatabase;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;


@RestController
public class Controller {
    ProfileDatabase profileDatabase = new ProfileDatabase(); //stores user info for sign in
    ProjectDatabase projectDatabase = new ProjectDatabase(); //holds all projects created for explorer page

    @PostMapping("/about")
    public int createProfile(@RequestBody String json) {
        System.out.println(json);
        int fields = 0;
        int tagEnd;
        int lastColon = 0;
        String[] values = new String[5];
        int valueStart, valueEnd;

        while (fields != 5){
            tagEnd = json.indexOf(':', lastColon + 1);
            valueStart = json.indexOf("\"", tagEnd);
            valueEnd = json.indexOf("\"", valueStart+1);
            values[fields] = json.substring(valueStart, valueEnd);
            lastColon = tagEnd;
            fields++;
        }

        String firstName = values[0]; String lastName = values[1]; String username = values[2]; String password = values[3]; String passwordVerification = values[4];

        if (password.equals(passwordVerification)) {
            Profile newUser = Profile.of(firstName, lastName, username, password);
            profileDatabase.addProfile(newUser);
            return 1;
        } else {
            return -1;
        }
    }

}