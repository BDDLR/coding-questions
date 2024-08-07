import java.util.HashSet;
import java.util.Set;

public class SubSudoku {
    public static void main(String[] args) {
        int[][] grid1 = {
                { 2, 3, 1 },
                { 1, 2, 3 },
                { 3, 1, 2 },
        };

        int[][] grid2 = {
                { 1, 2, 3 },
                { 3, 2, 1 },
                { 3, 1, 2 },
        };

        int[][] grid3 = {
                { 2, 2, 3 },
                { 3, 1, 2 },
                { 2, 3, 1 },
        };
        int[][] grid4 = {
                { 1 },
        };
        int[][] grid5 = {
                { -1, -2, -3 },
                { -2, -3, -1 },
                { -3, -1, -2 },
        };
        int[][] grid6 = {
                { 1, 3, 3 },
                { 3, 1, 2 },
                { 2, 3, 1 },
        };
        int[][] grid7 = {
                { 1, 2, 3, 4 },
                { 4, 3, 2, 1 },
                { 1, 3, 2, 4 },
                { 4, 2, 3, 1 },
        };
        int[][] grid8 = {
                { 0, 3 },
                { 3, 0 },
        };
        int[][] grid9 = {
                { 0, 1 },
                { 1, 0 },
        };
        int[][] grid10 = {
                { 1, 1, 6 },
                { 1, 6, 1 },
                { 6, 1, 1 },
        };
        int[][] grid11 = {
                { 1, 2, 3, 4 },
                { 2, 3, 1, 4 },
                { 3, 1, 2, 4 },
                { 4, 2, 3, 1 },
        };
        int[][] grid12 = {
                { -1, -2, 12, 1 },
                { 12, -1, 1, -2 },
                { -2, 1, -1, 12 },
                { 1, 12, -2, -1 },
        };
        int[][] grid13 = {
                { 2, 3, 3 },
                { 1, 2, 1 },
                { 3, 1, 2 },
        };
        int[][] grid14 = {
                { 1, 3 },
                { 3, 1 },
        };
        int[][] grid15 = {
                { 2, 3 },
                { 3, 2 },
        };
        int[][] grid16 = {
                { 3, 2 },
                { 2, 3 },
        };

        validateSudoku(grid1);
        validateSudoku(grid2);
        validateSudoku(grid3);
        validateSudoku(grid4);
        validateSudoku(grid5);
        validateSudoku(grid6);
        validateSudoku(grid7);
        validateSudoku(grid8);
        validateSudoku(grid9);
        validateSudoku(grid10);
        validateSudoku(grid11);
        validateSudoku(grid12);
        validateSudoku(grid13);
        validateSudoku(grid14);
        validateSudoku(grid15);
        validateSudoku(grid16);

    }

    public static void validateSudoku(int[][] grid) {
        Set<Integer> base = new HashSet<>();
        for (var i = 0; i <= grid.length - 1; i++) {
            base.add(i + 1);
        }
        Set<Integer> tmp = new HashSet<Integer>();

        // Comparison for rows
        for (var i = 0; i <= grid.length - 1; i++) {
            for (var j = 0; j <= grid.length - 1; j++) {
                tmp.add(grid[i][j]);
            }

            if (!base.equals(tmp)) {
                System.out.println("false");
                return;
            }

            tmp.clear();
        }

        // Comparion for columns
        for (var i = 0; i <= grid.length - 1; i++) {
            for (var j = 0; j <= grid.length - 1; j++) {
                tmp.add(grid[j][i]);
            }
            if (!base.equals(tmp)) {
                System.out.println("false");
                return;
            }
            tmp.clear();
        }

System.out.println("true");
        return;
    }
}
