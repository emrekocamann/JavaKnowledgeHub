package com.emre.streams;

import java.util.List;

public class SumAndReduce {




    public static int calculate(List<Integer> numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }

    public static int calculate2(List<Integer> numbers) {
      return numbers.stream()
              .reduce(Integer::sum)
              .orElse(0);
    }
}
