package com.emre.streams;

import java.util.Arrays;

public class LetterCount {








  // array elemanlarını al --> stream()
  //5ten uzun isimleri filtrele --> filter()
  //geri kalan listedeki harlerin sayısını  --> mapToInt()
    // harf sayılarını topla --> sum()
    public static int getTotalNumberOfLettersOfNamesLongerThanFive(String... names) {
        return  Arrays.stream(names)
                .filter(name->name.length()>5) //Stream<String>
                .mapToInt(name->name.length())//Stream<Integer>
                .sum();
    }
}
