package aToZStriverSheetJava._003_Arrays;

public class Find_Missing_And_Repeated_Numbers {
    // hashing
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid[0].length;
        boolean[] map = new boolean[n*n + 2];
        int[] ans = new int[2];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int ele = grid[i][j];
                if(map[ele] == true){
                    ans[0] = grid[i][j];
                }
                map[ele] = true;
            }
        }

        for(int i=1; i<=n*n; i++){
            if(map[i] == false){
                ans[1] = i;
                break;
            }
        }

        return ans;
    }
    // optimal - Maths
    public int[] findMissingAndRepeatedValues_optimal(int[][] grid) {
        int n = grid.length;
        int N = n * n;

        // Expected sum and sum of squares for numbers 1 to N
        long expectedSum = (long) N * (N + 1) / 2;
        long expectedSquareSum = (long) N * (N + 1) * (2 * N + 1) / 6;

        // Actual sum and sum of squares
        long actualSum = 0;
        long actualSquareSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = grid[i][j];
                actualSum += num;
                actualSquareSum += (long) num * num;
            }
        }

        // Differences
        long sumDiff = expectedSum - actualSum;                  // missing - repeated
        long squareSumDiff = expectedSquareSum - actualSquareSum; // missing^2 - repeated^2

        // Solve equations
        long sumOfMissingAndRepeated = squareSumDiff / sumDiff;  // missing + repeated
        int missing = (int) ((sumOfMissingAndRepeated + sumDiff) / 2);
        int repeated = (int) (sumOfMissingAndRepeated - missing);

        return new int[]{repeated, missing};
    }
}
