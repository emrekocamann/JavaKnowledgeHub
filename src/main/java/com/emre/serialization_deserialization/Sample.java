package com.emre.serialization_deserialization;

import java.io.*;

public class Sample {

    /**Serialization Java Class ---> txt, xml, json ...	*/

     static void serialization(String path){
        try {
            User user = new User(1,"Emre","Kocaman");

            FileOutputStream file = new FileOutputStream(path);
            ObjectOutputStream outputStream = new ObjectOutputStream(file);
            outputStream.writeObject(user);
            outputStream.close();
            file.close();

            System.out.println("File was created");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

     static void deserialization(String path){
        try {
            FileInputStream file = new FileInputStream(path);
            ObjectInputStream inputStream = new ObjectInputStream(file);
            User user = (User) inputStream.readObject();
            inputStream.close();
            file.close();

            System.out.println(user.toString());
        }catch (FileNotFoundException e){
            serialization(path);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
    // ---- Serialization olabilmesi için User classı Serializable interfaceinden implement olması gerekiyor. ----
class User implements Serializable {

    int id;
    String name;
    String lastName;

    public User(int id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

        @Override
        public String toString() {
            return  "id=" + id +
                    ", name='" + name + '\'' +
                    ", lastName='" + lastName + '\'';
        }
    }
