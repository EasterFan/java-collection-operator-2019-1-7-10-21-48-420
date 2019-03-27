package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return arrayList.stream().sorted().collect(Collectors.toList()).get(arrayList.size() - 1);
    }

    public double getMinimum() {

        return arrayList.stream().sorted().collect(Collectors.toList()).get(0);
        // sorted 操作不会改变原数组，所以用get方式一直get出原数组的第一个
//        return arrayList.get(0);
    }

    public double getAverage() {
        return (double)arrayList.stream()
                .reduce(0, (item, sum) -> item + sum) / arrayList.size();

    }

    public double getOrderedMedian() {
        int count = arrayList.size();
        List<Integer> orderedList = arrayList.stream().sorted().collect(Collectors.toList());

        if (count % 2 == 0){
            return  (double) (orderedList.get(count / 2 - 1) + orderedList.get(count / 2)) / 2.0;
        }else {
            // 坑：包装类之间不能直接转换 java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.Double
            return ((Number)orderedList.get(count / 2)).doubleValue();
        }

    }

    public int getFirstEven() {
        return arrayList.stream().filter(item -> item % 2 == 0).findFirst().get();
    }

    public int getIndexOfFirstEven() {
        int even = getFirstEven();
        return arrayList.indexOf(even);
    }

    // 此处参数变量不是成员变量～
    public boolean isEqual(List<Integer> arrayList) {
        return this.arrayList.equals(arrayList);
    }

    //实现接口SingleLink，然后再此函数内使用
    public Double getMedianInLinkList(SingleLink singleLink) {

        SingleLinkList<Integer> singleLinkList = new SingleLinkList<>();
        for (Integer item: arrayList) {
            singleLinkList.addTailPointer(item);
        }

        int index = arrayList.size() / 2;

        if (arrayList.size() % 2 == 0){
            // 坑：包装类之间不能直接转换 java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.Double
            double small = Double.parseDouble(singleLinkList.getNode(index).toString());
            double big = Double.parseDouble(singleLinkList.getNode(index + 1).toString());
//            double big = (double)singleLink.getNode(index + 1);
            return (small + big) / 2;
        }else {
            // 空指针异常 - 重写Node节点返回值判断
            return Double.parseDouble(singleLinkList.getNode(index).toString());
        }
    }

    public int getLastOdd() {
        List oddList = arrayList.stream().filter(item -> item % 2 != 0).collect(Collectors.toList());
        return (int)oddList.get(oddList.size() -1);
    }

    public int getIndexOfLastOdd() {
        int lastOdd = getLastOdd();
        return arrayList.lastIndexOf(lastOdd);
    }
}
