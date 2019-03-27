package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        int small = left >= right ? right : left;
        int big = left > right ? left : right;

        List resultList = new ArrayList();
        for (int i = small; i <= big; i++){
            resultList.add(i);
        }

        if (left > right) Collections.reverse(resultList);
        return resultList;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        int small = left >= right ? right : left;
        int big = left > right ? left : right;

        List<Integer> resultList = new ArrayList();
        for (int i = small; i <= big; i++){
            resultList.add(i);
        }

        // filter 复制粘贴，不改变原集合
        List<Integer> temp = resultList.stream().filter(item -> item % 2 == 0).collect(Collectors.toList());
        if (left > right) Collections.reverse(temp);
        return temp;
    }

    public List<Integer> popEvenElments(int[] array) {
        // 数组流装箱操作 boxed
        return Arrays.stream(array).filter(item -> item % 2 == 0).boxed().collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
       return array[array.length - 1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        // 太坑了太坑了(asList 接受的是Integer)...

        Integer[] firstArray1 = transInttoInteger(firstArray);
        Integer[] secondArray1 = transInttoInteger(secondArray);

        List firstList =  new ArrayList<Integer>(firstArray1.length);
        List secondList = new ArrayList<Integer>(secondArray1.length);


        firstList.addAll(Arrays.asList(firstArray1));
        secondList.addAll(Arrays.asList(secondArray1));

        firstList.retainAll(secondList);
        return firstList;
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {

        List<Integer> firstList = new ArrayList<>(firstArray.length);
        List<Integer> secondList = new ArrayList<>(secondArray.length);


        firstList.addAll(Arrays.asList(firstArray));
        secondList.addAll(Arrays.asList(secondArray));

        firstList.addAll(secondList);

        return firstList.stream()
                .distinct()
                .collect(Collectors.toList());

    }

    public Integer[] transInttoInteger(int []intArray){
        Integer[] resultArray = new Integer[intArray.length];
        for (int i=0; i<intArray.length; i++) {
            resultArray[i] = intArray[i];
        }
        return resultArray;
    }
}
