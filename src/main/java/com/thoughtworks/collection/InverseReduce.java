package com.thoughtworks.collection;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {
    }

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {
        List<Integer> resultList = new ArrayList<>();

        for (int item = number; item - 2 > 0; item -= 2) {
            resultList.add(Integer.valueOf(item-2));
        }

        return resultList;
    }
}

