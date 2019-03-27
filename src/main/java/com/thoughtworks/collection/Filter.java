package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;

public class Filter {

    List<Integer>  array;

    public Filter(List<Integer> array) {
     this.array = array;
    }

    public List<Integer> filterEven() {
        return array.stream()
                .filter(item -> item % 2 == 0)
                .collect(Collectors.toList());
    }

    public List<Integer> filterMultipleOfThree() {
        return array.stream()
                .filter(item -> item % 3 == 0)
                .collect(Collectors.toList());
    }

    public List<Integer> getCommonElements(List<Integer> firstList, List<Integer> secondList) {

        // 不支持直接 retain ?
//        firstList.retainAll(secondList);
//        return firstList;
        List<Integer> resultList = new ArrayList<>(firstList);
        resultList.retainAll(secondList);
        return resultList;
    }

    public List<Integer> getDifferentElements() {
        return array.stream()
                .distinct()
                .collect(Collectors.toList());
    }
}