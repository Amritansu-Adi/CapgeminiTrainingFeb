import java.util.*;

public class FlipMatrix {
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

        char ch = sc.next().charAt(0);

        if (ch == 'H') {
            for (int i = 0; i < r / 2; i++) {
                int[] temp = A[i];
                A[i] = A[r - i - 1];
                A[r - i - 1] = temp;
            }
        } else {
            for (int i = 0; i < r; i++) {
                int l = 0, rr = c - 1;
                while (l < rr) {
                    int temp = A[i][l];
                    A[i][l] = A[i][rr];
                    A[i][rr] = temp;
                    l++;
                    rr--;
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }
}
