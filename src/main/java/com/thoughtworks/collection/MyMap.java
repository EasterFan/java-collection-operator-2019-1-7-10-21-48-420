package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return array.stream()
                .map(item -> item * 3)
                .collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        return array.stream().map(item -> letterList.get(item - 1)).collect(Collectors.toList());
    }

    public List<String> mapLetters() {
        return array.stream().map(item -> {
            int a = item / 26;
            int b = item % 26;

            if (a == 0 && b !=0 ){
                return letterList.get(item - 1);
            }else if (a != 0 && b == 0){
                return letterList.get(a-2) +"z";
            }else {
                return letterList.get(a-1) + letterList.get(b-1);
            }
        }).collect(Collectors.toList());
    }

    public List<Integer> sortFromBig() {
        List result = array.stream().sorted().collect(Collectors.toList());
        Collections.reverse(result);
        // reverse 不改变原数组??
//        Collections.reverse(sortFromSmall());
//        return array;
        return result;

    }

    public List<Integer> sortFromSmall() {
        return array.stream().sorted().collect(Collectors.toList());
    }
}
