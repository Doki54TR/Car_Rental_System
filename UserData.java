package MyCarRentalSystem;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserData {
    // Map to store username and password pairs
    private static HashMap<String, String> userMap = new HashMap<>();
    // File path for storing user data
    private static final String FILE_PATH = "users.txt";

    // Static block to load users when the class is first accessed
    static {
        loadUsersFromFile();
        
        // If the file is empty, add default users
        if (!userMap.containsKey("admin")) {
            userMap.put("admin", "1234");
            userMap.put("user", "1234");
            saveUsersToFile(); // Add default users to file
        }
    }

    // Kullanıcı Ekleme
    public static boolean addUser(String username, String password) {
        if (userMap.containsKey(username)) {
            return false; // User already exists
        }
        userMap.put(username, password);
        saveUsersToFile(); // Update the file after adding a user
        return true; 
    }

    // Enterance check
    public static boolean validateUser(String username, String password) {
        if (userMap.containsKey(username)) {
            return userMap.get(username).equals(password);
        }
        return false;
    }

    // Save users from the map to file
    private static void saveUsersToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Map.Entry<String, String> entry : userMap.entrySet()) {
                // username and password separated by ':'
                writer.write(entry.getKey() + ":" + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read users from file into the map
    private static void loadUsersFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return; // If file doesn't exist, nothing to load
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":"); // Concatenate username and password with ':'
                if (parts.length == 2) {
                    String uName = parts[0];
                    String pass = parts[1];
                    userMap.put(uName, pass);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String currentUsername = "";
}