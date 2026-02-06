import java.util.*;

public class TransposeMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] A = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        // Transpose
        for (int j = 0; j < c; j++) {
            for (int i = 0; i < r; i++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }
}
