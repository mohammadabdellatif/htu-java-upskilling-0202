package jo.edu.htu.utils;

public class Matrix {

    public Matrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row] == null)
                throw new IllegalArgumentException("row " + row + " is null");
            if (matrix[row].length != matrix[0].length)
                throw new IllegalArgumentException("Inconsistent rows");
        }
    }

    public int rows() {
        return -1;
    }

    public int cols() {
        return -1;
    }

    public int value(int row, int col) {
        return 0;
    }

    public void forEach(ValueConsumer valueConsumer) {

    }

    public interface ValueConsumer {

        void accept(int row, int col, int value);
    }
}
