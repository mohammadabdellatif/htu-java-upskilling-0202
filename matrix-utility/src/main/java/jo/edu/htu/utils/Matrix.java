package jo.edu.htu.utils;

public class Matrix {
    public Matrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row] == null)
                throw new IllegalArgumentException("row" + row + "is null");
            if (matrix[row].length != matrix[0].length) {
                throw new IllegalArgumentException("Inconsistent rows");
            }
        }
    }

    public int rows() {
        return -1;
    }

    public int cols() {
        return -1;
    }

    public int value(int row, int col) {
        int[][] matrix = new int[0][];
        int invalidRow = matrix.length;
        int invalidCol = matrix[0].length;
        for (row = 0; row < matrix.length; row++) {
            for (col = 0; col < matrix[row].length; col++) {
                if (row > matrix.length - 1 || col > matrix.length) {
                    throw new IllegalArgumentException("invalid cell index: " + invalidRow + "," + invalidCol);
                }
            }
        }
        return matrix[row][col];
    }

    public void forEach(ValueConsumer valueConsumer) {
        ValueConsumer a = new ValueConsumer() {
            @Override
            public void accept(int row, int col, int value) {

            }
        };
    }

    interface ValueConsumer {
        void accept(int row, int col, int value);
    }
}



