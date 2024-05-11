package com.emre.serialization_deserialization;

public class Main {
    public static void main(String[] args) {

        String path = "C:\\Users\\emrek\\Documents\\Kraft\\serializationTest.txt";
        Sample.serialization(path);
        Sample.deserialization(path);

    }
}
