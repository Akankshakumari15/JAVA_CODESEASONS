public class BooleanMatrixProblem {
    public static void main(String[] args) {
        int[][] mat = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };
        setZeroes(mat);
        for (int[] row : mat) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
    }

    static void setZeroes(int[][] mat) {
        int r = mat.length, c = mat[0].length;
        boolean[] row = new boolean[r];
        boolean[] col = new boolean[c];

        // Mark rows and columns that have a 0
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                if (mat[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }

        // Set entire row to 0
        for (int i = 0; i < r; i++)
            if (row[i])
                for (int j = 0; j < c; j++)
                    mat[i][j] = 0;

        // Set entire column to 0
        for (int j = 0; j < c; j++)
            if (col[j])
                for (int i = 0; i < r; i++)
                    mat[i][j] = 0;
    }
}


