package festi.persistence;

import festi.model.User;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PersistenceManager {
    private static Path userStorage = Path.of("/home/users.obj");
    public static void loadUsersFromFile() throws ClassNotFoundException{
        List<User> loaded = new ArrayList<>();
        try {
            ObjectInputStream inputStream =  new ObjectInputStream(Files.newInputStream(userStorage));

            while (true){
                User user = (User) inputStream.readObject();
                loaded.add(user);
            }

        }catch (IOException e) {
            User.setAllUsers(loaded);
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void saveUsersToFile() throws ClassNotFoundException, IOException {
        Path homeDire = Path.of("/home");
        if (!Files.exists(homeDire)){
            Files.createDirectory(homeDire);
        }
        List<User> toSave = User.getAllUsers();
        toSave.forEach(user -> {
            try {
                OutputStream output = Files.newOutputStream(userStorage);
                ObjectOutputStream outputStream = new ObjectOutputStream(output);
                outputStream.writeObject(user);
            }catch (IOException oei){
                System.out.println(oei);
            }

        });


    }
}
