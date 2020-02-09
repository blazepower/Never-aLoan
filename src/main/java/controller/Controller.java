package controller;

import Profile.Profile;
import data.ProfileDatabase;
import FundAProject.Project;
import Profile.Profile;
import data.ProfileDatabase;
import data.ProjectDatabase;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.math.BigDecimal;
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
        int totFields = 5;
        int fields = 0;
        int tagEnd;
        int lastColon = 0;
        String[] values = new String[totFields];
        int valueStart, valueEnd;

        while (fields != totFields){
            tagEnd = json.indexOf(':', lastColon + 1);
            valueStart = json.indexOf("\"", tagEnd);
            valueEnd = json.indexOf("\"", valueStart+1);
            values[fields] = json.substring(valueStart+1, valueEnd);
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

    @PostMapping("/login")
    public Profile login(@RequestBody String json){
        int totFields = 2;
        int fields = 0;
        int tagEnd;
        int lastColon = 0;
        String[] values = new String[totFields];
        int valueStart, valueEnd;

        while (fields != totFields){
            tagEnd = json.indexOf(':', lastColon + 1);
            valueStart = json.indexOf("\"", tagEnd);
            valueEnd = json.indexOf("\"", valueStart+1);
            values[fields] = json.substring(valueStart+1, valueEnd);
            lastColon = tagEnd;
            fields++;
        }

        String username = values[0]; String password = values[1];

        Profile check = profileDatabase.getProfile(username);
        if (check == null){
            throw new Error("Account has not been created");
        }

        if (Profile.verifyPassword(password, check.getPass())){
            return check;
        }
        else {
            return null;
        }
    }

    @PostMapping("/create")
    public void createProject(String json){
        int totFields = 4;
        int fields = 0;
        int tagEnd;
        int lastColon = 0;
        String[] values = new String[totFields];
        int valueStart, valueEnd;

        while (fields != totFields){
            tagEnd = json.indexOf(':', lastColon + 1);
            valueStart = json.indexOf("\"", tagEnd);
            valueEnd = json.indexOf("\"", valueStart+1);
            values[fields] = json.substring(valueStart, valueEnd);
            lastColon = tagEnd;
            fields++;
        }

        String title = values[0]; String description = values[1]; String amount = values[2]; String deadline = values[3];

        Project p = Project.of(title, new BigDecimal(amount), new BigDecimal(deadline));
        p.setProjectDescription(description);
        projectDatabase.addProject(p);
    }

}