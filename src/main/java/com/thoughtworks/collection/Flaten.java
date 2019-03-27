package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Flaten {

    Integer[][] array;
    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        List resultList = new ArrayList();

        for (Integer arrayList[]:array) {
            for (Integer item : arrayList) {
                resultList.add(item);
            }
        }

        return resultList;
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        return transformToOneDimesional().stream()
                .distinct()
                .collect(Collectors.toList());

    }
}
