package festi.persistence;

import festi.model.User;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static festi.model.User.*;

public class PersistenceManager {
    private static Path localUserStorage = Path.of("C:\\home\\users.obj");
    private static Path azureStorage = Path.of("/home");




    public static void loadUsersFromFile() throws ClassNotFoundException {
        List<User> loaded = new ArrayList<>();
        try {
            /*String environment = System.getenv("AZURE_FUNCTIONS_ENVIRONMENT");
            if (environment != null && environment.equalsIgnoreCase("Development")) {*/
                ObjectInputStream azureInput = new ObjectInputStream(Files.newInputStream(azureStorage));
                while (true) {
                    User user = (User) azureInput.readObject();
                    loaded.add(user);
                }
        /*    }
            ObjectInputStream localInput = new ObjectInputStream(Files.newInputStream(localUserStorage));
            while (true) {
                User user = (User) localInput.readObject();
                loaded.add(user);
            }
*/


        } catch (IOException e) {
            if (loaded.isEmpty()){
                 createAdmin("admin","adminGod","admin@festifind.nl");
                 createUser("SuperOona", "oona", "o@hot.com");
            }
            User.setAllUsers(loaded);
            System.out.println(getAllUsers());
            e.printStackTrace();
        }
    }

    public static void saveUsersToFile() throws IOException {
        Path homeDire = Path.of("C:\\home");
        if (!Files.exists(homeDire)) {
            Files.createDirectory(homeDire);
        }
        try {
            /*String environment = System.getenv("AZURE_FUNCTIONS_ENVIRONMENT");
            if (environment != null && environment.equalsIgnoreCase("Development")) {*/
                ObjectOutputStream azureOutput = new ObjectOutputStream(Files.newOutputStream(azureStorage));
                List<User> toSave = User.getAllUsers();
                toSave.forEach(user -> {
                    try {
                        azureOutput.writeObject(user);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
           /* }
            ObjectOutputStream localOutput = new ObjectOutputStream(Files.newOutputStream(localUserStorage));
            List<User> toSave = User.getAllUsers();
            toSave.forEach(user -> {
                try {
                    localOutput.writeObject(user);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });*/
        }catch (IOException oie){
            oie.printStackTrace();
        }finally {
            System.out.println("done");
        }




    }



}
