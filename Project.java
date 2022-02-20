package project;

import java.util.ArrayList;

public class Project {

    public static void main(String[] args) {
        arraylist object1 = new arraylist();
        System.out.println("-------------");
        array object2 = new array();
        object2.arrays();

    }

}

class array {

    void arrays() {
        int arr1[] = {1, 2, 3, 4, 5};
        int arr2[] = {6, 7, 8, 9, 10};
        int arr3[] = new int[10];
        int num = 5;
        for (int i = 0; i < arr1.length; i++) {
            arr3[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            arr3[num] = arr2[i];
            num++;
        }
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }
        System.out.println();
    }
}

class arraylist {

    public arraylist() {
        ArrayList obj = new ArrayList();
        obj.add("Ifham");
        obj.add("N");
        obj.add("Male");
        obj.add(21);
        obj.add(5.9f);
        System.out.println("Name: " + obj.get(0));
        System.out.println("Age: " + obj.get(3));
        System.out.println("Gender: " + obj.get(2));
        System.out.println("Height: " + obj.get(4));
        System.out.println("Covid: " + obj.get(1));
    }
}
