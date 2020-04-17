package jo.edu.htu.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

public class MatrixTest {

    @RepeatedTest(10)
    public void givenArrayWithNullRow_whenConstructMatrix_thenThrowIllegalArgumentException() {
        int[][] matrix = new int[][]{
                {3, 4, 5},
                {9, 6, 4},
                {10, 6, 7}
        };
        int rowToCorrupt = new Random().nextInt(matrix.length);
        matrix[rowToCorrupt] = null;
        IllegalArgumentException thrown = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Matrix(matrix), "The constructor should throw IllegalArgumentException");
        Assertions.assertEquals("row " + rowToCorrupt + " is null", thrown.getMessage(),
                "the exception message is not as expected");
    }

    @Test
    public void givenArrayWithInConsistentRows_whenConstructMatrix_thenFail() {
        int[][] matrix = new int[][]{
                {3, 4, 5},
                {9, 6, 4},
                {10, 6, 7}
        };
        int rowToCorrupt = new Random().nextInt(matrix.length);
        matrix[rowToCorrupt] = Arrays.copyOf(matrix[rowToCorrupt], matrix[rowToCorrupt].length + 1);
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Matrix(matrix), "The constructor should throw IllegalArgumentException");
        Assertions.assertEquals("Inconsistent rows", thrown.getMessage(),
                "the exception message is not as expected");
    }

    @Test
    public void givenAValidArrayWhenConstructing_thenMatrixInstanceIsCreated() {
        int[][] array = {
                {3, 4, 6},
                {9, 8, 7},
                {90, 100, 90},
                {6, 8, 9}
        };
        Matrix matrix = new Matrix(array);

        Assertions.assertEquals(array.length, matrix.rows(), "invalid rows count");
        Assertions.assertEquals(array[0].length, matrix.cols(), "invalid rows count");
        Random random = new Random();
        int invalidRow = array.length + random.nextInt(3);
        int invalidCol = array[0].length + random.nextInt(array[0].length);
        IllegalArgumentException
                thrown = Assertions.assertThrows(IllegalArgumentException.class,
                () -> matrix.value(invalidRow, invalidCol));
        Assertions.assertEquals("invalid cell index: " + invalidRow + "," + invalidCol, thrown.getMessage());

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                Assertions.assertEquals(array[row][col], matrix.value(row, col));
            }
        }

        int row = random.nextInt(array.length);
        int col = random.nextInt(array[0].length);
        int oldValue = array[row][col];
        array[row][col] = oldValue - 10;
        Assertions.assertTrue(matrix.value(row, col) != array[row][col], "I was able to modify your matrix from outside");
        array[row][col] = oldValue;

        int[][] consumed = new int[array.length][array[0].length];
        matrix.forEach((r, c, v) -> {
            consumed[r][c] = v;
        });
        Assertions.assertArrayEquals(array, consumed, "it seems not all cells were visited");

    }
}
