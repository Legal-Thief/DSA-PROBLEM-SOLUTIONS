import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[] queens = new int[n]; 
        backtrack(ans, queens, n, 0, 0, 0, 0);
        return ans;
    }

    private void backtrack(List<List<String>> ans, int[] queens, int n, int row, 
                           int cols, int diag1, int diag2) {
        if (row == n) {
            ans.add(generateBoard(queens, n));
            return;
        }

        int availablePositions = ~(cols | diag1 | diag2) & ((1 << n) - 1);

        while (availablePositions > 0) {
            
            int position = availablePositions & -availablePositions;
           
            availablePositions -= position;

            
            int col = Integer.numberOfTrailingZeros(position);
            queens[row] = col;

           
            backtrack(ans, queens, n, row + 1, 
                      cols | position, 
                      (diag1 | position) << 1, 
                      (diag2 | position) >> 1);
        }
    }

    private List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            java.util.Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
