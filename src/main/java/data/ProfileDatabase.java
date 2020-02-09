package main.java.data;

import main.java.Profile.Profile;

import java.util.HashMap;

public class ProfileDatabase {
    HashMap<String, Profile> profiles;

    public ProfileDatabase() {
        this.profiles = new HashMap<>();
    }

    public void addProfile(Profile profile) {
        //TODO logic tto ensure profle names are unique
        profiles.put(profile.getUserName(), profile);
    }

    public Profile getProfile(String name) {
        return profiles.get(name);
    }
}
