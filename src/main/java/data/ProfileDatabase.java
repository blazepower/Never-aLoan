package data;

import Profile.Profile;

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

    public int getSize(){
        return profiles.size();
    }
}
