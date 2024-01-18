package codingtest.baekjoon.브루트포스;

import java.util.Scanner;

public class 체스판다시칠하기 {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String row = sc.nextLine();
            board[i] = row.toCharArray();
        }

        int minChanges = Integer.MAX_VALUE;

        for (int i = 0 ; i <= N - 8 ; i++) {
            for (int j = 0 ; j <= M - 8 ; j++) {
                int changes = countChanges(board, i, j);
                minChanges = Math.min(minChanges, changes);
            }
        }

        System.out.println(minChanges);
    }

    private static int countChanges(char[][] board, int x, int y) {
        int changesPattern1 = 0;
        int changesPattern2 = 0;

        for (int i = 0 ; i < 8 ; i++) {
            for (int j = 0 ; j < 8 ; j++) {
                char currentCell = board[x + i][y + j];
                char pattern1 = (i + j) % 2 == 0 ? 'W' : 'B';
                char pattern2 = (i + j) % 2 == 0 ? 'B' : 'W';

                if (currentCell != pattern1) changesPattern1++;
                if (currentCell != pattern2) changesPattern2++;
            }
        }

        return Math.min(changesPattern1, changesPattern2);
    }
	
}