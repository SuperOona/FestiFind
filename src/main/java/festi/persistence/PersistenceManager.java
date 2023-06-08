package festi.persistence;

import festi.model.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class PersistenceManager {
    private static Path userStorage = Path.of("/home/users.obj");
    public static void loadUsersFromFile() throws ClassNotFoundException{
        try {
            ObjectInputStream inputStream =  new ObjectInputStream(Files.newInputStream(userStorage));
            List<User> loaded = (List<User>) inputStream.readObject();
            User.setAllUsers(loaded);
        }catch (IOException ie){
            System.out.println("pop"+ie);
        }
    }

    public static void saveUsersToFile() throws ClassNotFoundException, IOException {
        Path homeDire = Path.of("/home");
        if (!Files.exists(homeDire)){
            Files.createDirectory(homeDire);
        }
        List<User> toSave = User.getallUsers();
        ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(userStorage));
        outputStream.writeObject(toSave);
    }
}
