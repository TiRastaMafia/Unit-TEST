package org.example;

import java.util.List;

public class ListsOfNumbers {

    private List<Double> list1;

    private List<Double> list2;

    public ListsOfNumbers() {

    }

    public List<Double> getList1() {
        return list1;
    }

    public void setList1(List<Double> list1) {
        this.list1 = list1;
    }

    public List<Double> getList2() {
        return list2;
    }

    public void setList2(List<Double> list2) {
        this.list2 = list2;
    }

    public double getAverage(List<Double> list) {
        double average = 0.0;
        for (double item : list) {
            average += item;
        }
        return average / list.size();
    }

    public void compareAverages() {
        if ((list1 != null && !list1.isEmpty())
                && ((list2 != null && !list2.isEmpty()))) {
            if (getAverage(list1) < getAverage(list2)) {
                System.out.println("Список1 имеет меньшее среднее значение");
            } else if (getAverage(list1) > getAverage(list2)) {
                System.out.println("Список1 имеет большее среднее значение");
            } else {
                System.out.println("Средние значения Списка1 и Списка2 равны");
            }
        } else {
            throw new NullPointerException("Нельзя выполнить с одним списком");
        }
    }
}
