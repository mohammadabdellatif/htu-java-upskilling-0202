package jo.edu.htu.utils;

public class Matrix {
    public Matrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row] == null)
                throw new IllegalArgumentException("row " + row + " is null");
            if (matrix[row].length != matrix[0].length)
                        throw new IllegalArgumentException("Inconsistent rows");
            }
            this.matrix=new int[matrix.length][matrix[0].length];
        }

        public int rows() {

            return matrix.length;
        }

        public int cols() {

            return matrix[0].length;
        }

        public int value(int row, int col) {

            if (row <0 || col <0)
                throw new IllegalArgumentException("it must be positive ");
            if ((row >= matrix.length) || ( col >= matrix[0].length))
                throw new IllegalArgumentException("cell index not exist: (" + row + ',' + col+')');

            return matrix[row][col];
        }

        public void forEach(ValueConsumer valueConsumer) {

            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    valueConsumer.accept(row, col, matrix[row][col]);
                }
            }
        }

        public interface ValueConsumer {
            void accept(int row, int col, int value);
        }}