package project;

import java.util.Scanner;

public class DSA_Searching {
    public static void main(String[] args) {
//        Linear_Searching object1 = new Linear_Searching();
//        object1.Searching();
        Binary_Search object2 = new Binary_Search();
//        object2.Searching_String();
        object2.Searching_Int();
    }
}

class Linear_Searching{
String arr[]=new String[5];
boolean condition=false;
Scanner obj = new Scanner(System.in);
void Searching(){
    for (int i = 0; i < arr.length; i++) {
        System.out.println(i+") Enter Student name: ");
        arr[i]=obj.next();
    }
    for (int i = 0; i < arr.length; i++) {
        if (arr[i].compareTo("Ifham")==0) {
            System.out.println("Ifham found");
            condition= true;
        }
    }
    if (condition==false) {
        System.out.println("Not found");
    }
}

}

class Binary_Search{
String arr[]=new String[5];
Scanner obj = new Scanner(System.in);
void Searching_String(){
    for (int i = 0; i < arr.length; i++) {
        System.out.println(i+") Enter Student name: ");
        arr[i]=obj.next();
    }
    int first=0;
    int last=arr.length-1;
    int mid=(first/last)/2;
    int res = "Ifham".compareTo(arr[mid]);
    while(first<=last){
        if (arr[mid].compareTo("Ifham")==0) {
            System.out.println("Ifham found");
            break;
        }
        else if (res>0) {
        first=mid+1;    
        }
        else {
        last=mid-1;
        }
        mid=(first/last)/2;
    }
}
int arr1[]={1,2,3,4,5};
void Searching_Int(){
    int arr1[] = {1, 2, 3, 4, 5, 6};
        int search = 2;
        int start = 0;
        int end = arr.length - 1;
        int middle = (start + end) / 2;
        while (start <= end) {
            if (arr1[middle] == search) {
                System.out.println("Found at index: " + middle);
                break;
            } else if (arr1[middle] < search) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
            middle = (start + end) / 2;
        }
        
}
}