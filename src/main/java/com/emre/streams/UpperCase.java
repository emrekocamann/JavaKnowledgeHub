package com.emre.streams;


import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

public class UpperCase {

    public static void main(String[] args) {

        System.out.println(mapToUppercase("John", "Jane", "Joe"));
        System.out.println(mapToUppercaseWithStream("John", "Jane", "Joe"));


    }


    public static List<String> mapToUppercase(String... names) {
        List<String> uppercaseNames = new ArrayList<>();
        for(String name : names) {
            uppercaseNames.add(name.toUpperCase());
        }
        return uppercaseNames;
    }

    //Array elemanlarının tamamını al --> stream()
    //büyük harflere çevir --> map()
    //liste olarak geri dön --> collect()

    public static List<String> mapToUppercaseWithStream(String... names) {
       return Arrays.stream(names)
               .map(name->name.toUpperCase())  //.map(String::toUpperCase)
                .collect(Collectors.toList());
    }


}


