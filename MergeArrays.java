import java.util.Arrays;

public class MergeArrays {
    public static void mergeArrays(int[] X, int[] Y) {
        int m = X.length;
        int n = Y.length;
        
        // Move all non-zero elements of X to front
        int k = m - 1;
        for (int i = m - 1; i >= 0; i--) {
            if (X[i] != 0) {
                X[k] = X[i];
                k--;
            }
        }
        
        // Merge X and Y
        int i = k + 1; // index of first non-zero element in X
        int j = 0;     // index of first element in Y
        k = 0;         // index of merged array
        while (i < m && j < n) {
            if (X[i] < Y[j]) {
                X[k] = X[i];
                i++;
            } else {
                X[k] = Y[j];
                j++;
            }
            k++;
        }
        
        // Copy remaining elements of Y, if any
        while (j < n) {
            X[k] = Y[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] X = { 0, 2, 0, 3, 0, 5, 6, 0, 0 };
        int[] Y = { 1, 8, 9, 10, 15 };

        mergeArrays(X, Y);

        System.out.println(Arrays.toString(X));
    }
}
