package jo.edu.htu.utils;

import java.util.Arrays;

class Matrix {


    private int[][] matrix;

    Matrix(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row] == null)
                throw new IllegalArgumentException("row " + row + " is null");
        }

        for (int row = 0; row < matrix.length; row++) {
            
                if (matrix[row].length != matrix[0].length)
                    throw new IllegalArgumentException("Inconsistent rows");
        }
        this.matrix = matrix;


    }

    int value(int row, int col) {
        if (row < 0 || row > matrix.length || col < 0 || col > matrix.length)
            throw new IllegalArgumentException("invalid cell index: " + row + "," + col);

        return this.matrix[row][col];
    }


    int rows() {
        return matrix.length;
    }

    int cols() {
        return matrix[0].length;
    }


    void forEach(ValueConsumer valueConsumer) {
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                valueConsumer.accept(i,j,matrix[i][j]);



    }

    public interface ValueConsumer {

        void accept(int row, int col, int value);
    }
}
