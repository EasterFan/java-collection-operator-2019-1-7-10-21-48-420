package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int small = leftBorder <= rightBorder ? leftBorder : rightBorder;
        int big = leftBorder < rightBorder ? rightBorder : leftBorder;

        int sum = 0;
        for (int i = small; i <= big; i++){
            if (i % 2 == 0){
                sum += i;
            }
        }

        return sum;
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int small = leftBorder <= rightBorder ? leftBorder : rightBorder;
        int big = leftBorder < rightBorder ? rightBorder : leftBorder;

        int sum = 0;
        for (int i = small; i <= big; i++){
            if (i % 2 != 0){
                sum += i;
            }
        }

        return sum;
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {

       return arrayList.stream().reduce(0,(sum,item) -> sum + (item * 3 + 2));
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().map(item -> {
            if (item % 2 != 0) {
                return item * 3 + 2;
            }
            return item;
        }).collect(Collectors.toList());
    }


    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream().filter(item ->  item % 2 != 0)
                .map(item -> item * 3 + 5)
                .reduce(0,(sum, item) -> sum + item);
    }


    public double getMedianOfEven(List<Integer> arrayList) {
        List<Integer> evenArray = arrayList.stream().filter(item -> item % 2 == 0)
                // 中位数按大小顺序排序
                .sorted()
                .collect(Collectors.toList());

        int count = evenArray.size();

        return count % 2 == 0 ? (double) ( evenArray.get( count / 2 -1)  + evenArray.get(count / 2) ) / 2 : evenArray.get(count / 2);
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        // count 返回值是long ？？
        long count = arrayList.stream().filter(item -> item % 2 == 0).count();
        return arrayList.stream().filter(item -> item % 2 == 0)
                .reduce(0,(sum , item) -> sum + item) / count;
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream().filter(item -> item % 2 ==0)
                .collect(Collectors.toList())
                .contains(specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream().filter(item -> item % 2 == 0)
                // 去重
                .distinct()
                .collect(Collectors.toList());
    }


    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List evenList = arrayList.stream().filter(item -> item % 2 == 0).collect(Collectors.toList());
        List oddList = arrayList.stream().filter(item -> item % 2 != 0).collect(Collectors.toList());

        // 改变原数组
        Collections.reverse(oddList);
        // 改变原数组
        evenList.addAll(oddList);
        return evenList;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
       List newarraylist = new ArrayList();
       for (int i=1; i<arrayList.size(); i++){
           // warning ???
           newarraylist.add((arrayList.get(i-1) + arrayList.get(i)) * 3);
       }

       return newarraylist;

    }
}
