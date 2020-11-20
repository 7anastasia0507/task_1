package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ArrayVectorImpl arrayVectorImp = new ArrayVectorImpl();
        arrayVectorImp.set(1, 2, 3);
        arrayVectorImp.set(5,5);

        ArrayVectorImpl arrayVectorNew = new ArrayVectorImpl();
        arrayVectorNew.set(1,2,3,4,5,6,5);

        System.out.println(Arrays.toString(arrayVectorImp.get()));
        System.out.println(Arrays.toString(arrayVectorNew.get()));
        System.out.println(Arrays.toString(arrayVectorImp.sum(arrayVectorNew).get()));
        System.out.println("------/-----------");
        Integer i = new Integer("10");
        if(i.toString() == i.toString()){
            System.out.println("+");
        }
        else
            System.out.println("-");
    }
}
