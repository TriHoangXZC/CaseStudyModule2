package Manager;

import Model.User;

import java.io.*;
import java.util.ArrayList;

public class ManagerLogin {
    public static ArrayList<User> userArrayList = new ArrayList<>();

    public static void writeFileLogin() throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream("src/login.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(userArrayList);
    }

    public static void readFileLogin() throws IOException, ClassNotFoundException{
        FileInputStream fileInputStream = new FileInputStream("src/login.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        userArrayList = (ArrayList<User>) objectInputStream.readObject();
    }

//    public static void removeLogin(String nameLogin) throws IOException, ClassNotFoundException{
//        readFileLogin();
//        for (int i = 0; i < userArrayList.size(); i++) {
//            if(userArrayList.get(i).getUserName().equals(nameLogin)){
//                userArrayList.remove(i);
//            }
//        }
//        writeFileLogin();
//    }
}
