package aToZStriverSheetJava._003_Arrays.Easy;

//link - https://www.geeksforgeeks.org/problems/rotate-array-by-n-elements-1587115621/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card

public class RotateArrayLeft {
    static void reverse(int nums[], int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    static void rotateArr(int arr[], int d) {
        int n = arr.length;

        d %= n;

        reverse(arr, 0, n-1);
        reverse(arr, 0, n-d-1);
        reverse(arr, n-d, n-1);
    }
}
