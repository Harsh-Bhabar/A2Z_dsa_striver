package aToZStriverSheetJava._003_Arrays.Easy;

//link - https://www.geeksforgeeks.org/problems/second-largest3735/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card

public class Second_Largest {

//    method - 1
    public int getSecondLargest(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int x: arr){
            if(x > max){
                max = x;
            }
            if(x < min){
                min = x;
            }
        }
        int secondMax = min;
        for(int x: arr){
            if(x < max && x > secondMax){
                secondMax = x;
            }
        }
        if(secondMax == max){
            return -1;
        }
        return secondMax;
    }

    // method - 2 - optimal
    public int getSecondLargest_2(int[] arr) {
        int large = Integer.MIN_VALUE;
        int second_large = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > large) {
                second_large = large;
                large = arr[i];
            } else if (arr[i] > second_large && arr[i] != large) {
                second_large = arr[i];
            }
        }

        if(large == second_large){
            return -1;
        }

        return second_large == Integer.MIN_VALUE ? -1 : second_large;
    }

    public static void main(String[] args) {
    }
}
