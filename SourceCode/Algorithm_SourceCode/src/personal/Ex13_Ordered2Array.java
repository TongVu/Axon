package personal;

public class Ex13_Ordered2Array {
    public static void main(String[] args) {
        int[] arr1 = {3, 5, 8, 9, 15, 20, 27};
        int[] arr2 = {0, 1, 4, 6, 8, 10, 12};
        int[] sorted = new int[arr1.length + arr2.length];

        int i = 0,
                k = 0;
        int n = 0;

        while(i < arr1.length   &&
         k < arr2.length ){
            if(arr1[i] < arr2[k]) {
                sorted[n] = arr1[i];
                n++;
                i++;
            } else{
                sorted[n] = arr2[k];
                n++;
                k++;
            }
        }

        // after sorted, there could be elements remain in 2 small array,
        // the index where they were sorted still there
        // if 1 array reached its limit first then the sorted Algo above ended
        // that's mean the rest of the other array still there and need to be added to the sorted array.

        while(i < arr1.length ){
            sorted[n] = arr1[i];
            i++;
            n++;
        }
        while(k < arr2.length ){
            sorted[n] = arr1[k];
            k++;
            n++;
        }

        for (int numb :
                sorted) {
            System.out.print(numb + " -> ");
        }
        System.out.print("\b\b\b");


    }
}
