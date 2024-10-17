package inicioDeSesión;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class JsonHandler {
    private static final String FILE_NAME = "users.json";
    private static final Gson gson = new Gson();

    public static void saveUserData(User user) {
        Map<String, User> usersMap = loadAllUsers();
        usersMap.put(user.getUserName(), user);
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(usersMap, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, User> loadAllUsers() {
        try (FileReader reader = new FileReader(FILE_NAME)) {
            Type userMapType = new TypeToken<Map<String, User>>() {}.getType();
            Map<String, User> userMap = gson.fromJson(reader, userMapType);
            return userMap != null ? userMap : new HashMap<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>(); // Return an empty map if an error occurs
        }
    }

    public static User loadUserData(String userName) {
        Map<String, User> userMap = loadAllUsers();
        return userMap.get(userName);
    }

    public static void incrementMatchesPlayed(String userName){
        User user = loadUserData(userName);
        if (user != null){
            user.incrementMatchesPlayed();
            saveUserData(user);
        }
    }

    public static void incrementMatchesWon(String userName){
        User user = loadUserData(userName);
        if (user != null){
            user.incrementMatchesWon();
            saveUserData(user);
        }
    }

    public static void incrementMatchesLost(String userName){
        User user = loadUserData(userName);
        if (user != null){
            user.incrementMatchesLost();
            saveUserData(user);
        }
    }

    public static void incrementCharacterKills(String username, String characterName) {
        User user = loadUserData(username);
        user.initializeCharacterStats(characterName);
        user.getCharacterStats(characterName).incrementKills();
        saveUserData(user);
    }

    public static void incrementCharacterDeaths(String username, String characterName) {
        User user = loadUserData(username);
        user.initializeCharacterStats(characterName);
        user.getCharacterStats(characterName).incrementDeaths();
        saveUserData(user);
    }

    public static void incrementCharacterTowerKills(String username, String characterName) {
        User user = loadUserData(username);
        user.initializeCharacterStats(characterName);
        user.getCharacterStats(characterName).incrementTowerKills();
        saveUserData(user);
    }
}