import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Nonogram {

    public static void main(String[] args) {

        char[][] matrix1 = {
                { 'W', 'W', 'W', 'W' },
                { 'B', 'W', 'W', 'W' },
                { 'B', 'W', 'B', 'B' },
                { 'W', 'W', 'B', 'W' },
                { 'B', 'B', 'W', 'W' } };

        int[][] rows1_1 = { {}, { 1 }, { 1, 2 }, { 1 }, { 2 } };
        int[][] columns1_1 = { { 2, 1 }, { 1 }, { 2 }, { 1 } };

        int[][] rows1_2 = { {}, {}, { 1 }, { 1 }, { 1, 1 } };
        int[][] columns1_2 = { { 2 }, { 1 }, { 2 }, { 1 } };

        int[][] rows1_3 = { {}, { 1 }, { 3 }, { 1 }, { 2 } };
        int[][] columns1_3 = { { 3 }, { 1 }, { 2 }, { 1 } };

        int[][] rows1_4 = { {}, { 1, 1 }, { 1, 2 }, { 1 }, { 2 } };
        int[][] columns1_4 = { { 2, 1 }, { 1 }, { 2 }, { 1 } };

        int[][] rows1_5 = { {}, { 1 }, { 1 }, { 1 }, { 2 } };
        int[][] columns1_5 = { { 2, 1 }, { 1 }, { 2 }, { 1 } };

        int[][] rows1_6 = { {}, { 1 }, { 2, 1 }, { 1 }, { 2 } };
        int[][] columns1_6 = { { 2, 1 }, { 1 }, { 2 }, { 1 } };

        int[][] rows1_7 = { {}, { 1 }, { 1, 2 }, { 1 }, { 2, 1 } };
        int[][] columns1_7 = { { 2, 1 }, { 1 }, { 2 }, { 1 } };

        int[][] rows1_8 = { { 1 }, { 1 }, { 1, 2 }, { 1 }, { 2 } };
        int[][] columns1_8 = { { 2, 1 }, { 1 }, { 2 }, { 1 } };

        char[][] matrix2 = {
                { 'W', 'W' },
                { 'B', 'B' },
                { 'B', 'B' },
                { 'W', 'B' } };

        int[][] rows2_1 = { {}, { 2 }, { 2 }, { 1 } };
        int[][] columns2_1 = { { 1, 1 }, { 3 } };

        int[][] rows2_2 = { {}, { 2 }, { 2 }, { 1 } };
        int[][] columns2_2 = { { 3 }, { 3 } };

        int[][] rows2_3 = { {}, {}, {}, {} };
        int[][] columns2_3 = { {}, {} };

        int[][] rows2_4 = { {}, { 2 }, { 2 }, { 1 } };
        int[][] columns2_4 = { { 2, 1 }, { 3 } };

        int[][] rows2_5 = { {}, { 2 }, { 2 }, { 1 } };
        int[][] columns2_5 = { { 2 }, { 3 } };

        int[][] rows2_6 = { {}, { 2 }, { 2 }, { 1 } };
        int[][] columns2_6 = { { 2 }, { 1, 1 } };

        char[][] matrix3 = {
                { 'B', 'W', 'B', 'B', 'W', 'B' } };

        int[][] rows3_1 = { { 1, 2, 1 } };
        int[][] columns3_1 = { { 1 }, {}, { 1 }, { 1 }, {}, { 1 } };

        int[][] rows3_2 = { { 1, 2, 2 } };
        int[][] columns3_2 = { { 1 }, {}, { 1 }, { 1 }, {}, { 1 } };

        validateNonogram(matrix1, rows1_1, columns1_1);
        validateNonogram(matrix1, rows1_2, columns1_2);
        validateNonogram(matrix1, rows1_3, columns1_3);
        validateNonogram(matrix1, rows1_4, columns1_4);
        validateNonogram(matrix1, rows1_5, columns1_5);
        validateNonogram(matrix1, rows1_6, columns1_6);
        validateNonogram(matrix1, rows1_7, columns1_7);
        validateNonogram(matrix1, rows1_8, columns1_8);
        validateNonogram(matrix2, rows2_1, columns2_1);
        validateNonogram(matrix2, rows2_2, columns2_2);
        validateNonogram(matrix2, rows2_3, columns2_3);
        validateNonogram(matrix2, rows2_4, columns2_4);
        validateNonogram(matrix2, rows2_5, columns2_5);
        validateNonogram(matrix2, rows2_6, columns2_6);
        validateNonogram(matrix3, rows3_1, columns3_1);
        validateNonogram(matrix3, rows3_2, columns3_2);

    }

    public static void validateNonogram(char[][] input, int[][] rowInst, int[][] colInst) {
        for (int i = 0; i < rowInst.length; i++) {
            List<Integer> rowInstructions = findRowInstructions(input, i);
            int[] rowInstructionsArray = rowInstructions.stream().mapToInt(c -> c).toArray();
            if (!Arrays.equals(rowInstructionsArray, rowInst[i])) {
                System.out.println("false");
                return;
            }
        }
        for (int i = 0; i < colInst.length; i++) {
            List<Integer> colInstructions = findColumnInstructions(input, i);
            int[] colInstructionsArray = colInstructions.stream().mapToInt(c -> c).toArray();
            if (!Arrays.equals(colInstructionsArray, colInst[i])) {
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
        return;
    }

    public static List<Integer> findRowInstructions(char[][] input, int row) {
        List<Integer> result = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < input[row].length; i++) {
            if (input[row][i] == 'B') {
                count++;
            } else if (count > 0) {
                result.add(count);
                count = 0;
            }
        }
        if (count > 0) {
            result.add(count);
        }
        return result;
    }

    public static List<Integer> findColumnInstructions(char[][] input, int col) {
        List<Integer> result = new LinkedList<>();
        int count = 0;
        for (int j = 0; j < input.length; j++) {
            if (input[j][col] == 'B') {
                count++;
            } else if (count > 0) {
                result.add(count);
                count = 0;
            }
        }
        if (count > 0) {
            result.add(count);
        }
        return result;
    }

}
