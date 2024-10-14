package inicioDeSesión;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    private static final String FILE_NAME = "users.json";
    private Map<String, User> users;

    public UserService() {
        this.users = loadUsers();
    }

    private Map<String, User> loadUsers() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return new HashMap<>();
        }
        try (Reader reader = new FileReader(file)) {
            Gson gson = new Gson();
            List<User> userList = gson.fromJson(reader, new TypeToken<List<User>>() {
            }.getType());
            Map<String, User> userMap = new HashMap<>();
            for (User user : userList) {
                userMap.put(user.getUserName(), user);
            }
            return userMap;
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    public void saveUsers() {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            Gson gson = new Gson();
            gson.toJson(users.values(), writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User getUser(String userName) {
        return users.get(userName);
    }

    public void addUser(User user) {
        users.put(user.getUserName(), user);
        saveUsers();
    }
}
