package com.emre.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMap {

    public static void main(String[] args) {

    }


    /*
    {
        {A,B,C},
        {D,E,F},
        {G,H,I}
    }
     */

    public static List<String> transform(List<List<String>> collection) {
        List<String> newCollection = new ArrayList<>();
        for (List<String> subCollection : collection) {
            for (String value : subCollection) {
                newCollection.add(value);
            }
        }
        return newCollection;
    }
    //nested liste ait değerleri al --> stream()
    //her bir elemanı listeye ekle --> flatMap()

    public static List<String> transform2(List<List<String>> collection) {
      return  collection.stream()
              .flatMap(subCollection->subCollection.stream())
              .collect(Collectors.toList());
    }
}
