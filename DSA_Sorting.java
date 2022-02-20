package project;

public class DSA_Sorting {
    public static void main(String[] args) {
        
    }
}

class Bubble_sort {

    void sorting() {
        int arr[] = {5, 4, 3, 2, 1};
        int temp;
        System.out.println("Before sorting:");
        PrintArray(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        System.out.println("---------------");
        System.out.println("After sorting:");
        PrintArray(arr);
    }

    static void PrintArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

class Selection_sort {

    void sorting() {
        int arr[] = {5, 4, 3, 2, 1};
        int temp, mid;
        System.out.println("Before sorting:");
        PrintArray(arr);
        for (int i = 0; i < arr.length; i++) {
            mid = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[mid] > arr[j]) {
                    mid = j;
                }
            }
            temp = arr[mid];
            arr[mid] = arr[i];
            arr[i] = temp;
        }
        System.out.println("---------------");
        System.out.println("After sorting:");
        PrintArray(arr);
    }

    static void PrintArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

class Insertion_sort {

    void sorting() {
        int arr[] = {5, 4, 3, 2, 1};
        System.out.println("Before sorting:");
        PrintArray(arr);
        for (int j = 0; j < arr.length; j++) {
            int key = arr[j];
            int i = j - 1;
            while ((i > -1) && (arr[i] > key)) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = key;
        }
        System.out.println("---------------");
        System.out.println("After sorting:");
        PrintArray(arr);
    }

    static void PrintArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

class Quick_sort {

    void sorting() {
        int arr[] = {5, 4, 3, 2, 1};
        int n = arr.length;
        System.out.println("Before sorting:");
        PrintArray(arr);
        quick(arr, 0, n - 1);
        System.out.println("---------------");
        System.out.println("After sorting:");
        PrintArray(arr);
    }

    void quick(int arr[], int start, int end) {
        if (start < end) {
            int p = partition(arr, start, end);
            quick(arr, start, p - 1);
            quick(arr, p + 1, end);
        }
    }

    int partition(int arr[], int start, int end) {
        int pivot = arr[end];
        int i = (start - 1);
        for (int j = start; j <= end - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[end];
        arr[end] = arr[i + 1];
        arr[i + 1] = temp;
        return (i + 1);
    }

    static void PrintArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

class Merge_sort {

    void sorting() {
        int a[] = {5,4,3,2,1};
        int n = a.length;
        Merge_sort m1 = new Merge_sort();
        System.out.println("\nBefore sorting array elements are - ");
        m1.printArray(a, n);
        m1.mergeSort(a, 0, n - 1);
        System.out.println("\nAfter sorting array elements are - ");
        m1.printArray(a, n);
        System.out.println("");
    }

    void merge(int a[], int beg, int mid, int end) {
        int i, j, k;
        int n1 = mid - beg + 1;
        int n2 = end - mid;

        /* temporary Arrays */
        int LeftArray[] = new int[n1];
        int RightArray[] = new int[n2];

        /* copy data to temp arrays */
        for (i = 0; i < n1; i++) {
            LeftArray[i] = a[beg + i];
        }
        for (j = 0; j < n2; j++) {
            RightArray[j] = a[mid + 1 + j];
        }

        i = 0;
        /* initial index of first sub-array */
        j = 0;
        /* initial index of second sub-array */
        k = beg;
        /* initial index of merged sub-array */

        while (i < n1 && j < n2) {
            if (LeftArray[i] <= RightArray[j]) {
                a[k] = LeftArray[i];
                i++;
            } else {
                a[k] = RightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            a[k] = LeftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            a[k] = RightArray[j];
            j++;
            k++;
        }
    }

    void mergeSort(int a[], int beg, int end) {
        if (beg < end) {
            int mid = (beg + end) / 2;
            mergeSort(a, beg, mid);
            mergeSort(a, mid + 1, end);
            merge(a, beg, mid, end);
        }
    }

    /* Function to print the array */
    void printArray(int a[], int n) {
        int i;
        for (i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
