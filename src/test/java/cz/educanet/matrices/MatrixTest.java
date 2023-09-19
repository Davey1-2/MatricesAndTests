package cz.educanet.matrices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MatrixTest {

    @Test
    void times() {
        double[][] data = new double[][]{
                {1, 2, 3},
                {4, 5, 6}
        };
        double[][] data2 = new double[][]{
                {1, 2},
                {4, 5},
                {7, 8}
        };
        IMatrix matrix = MatrixFactory.instance.create(data);
        IMatrix matrix2 = MatrixFactory.instance.create(data2);
        IMatrix matrix3 = matrix.times(matrix2);
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix2.getColumns(); j++) {
                double value = 0;
                for (int k = 0; k < matrix.getColumns(); k++) {
                    value += matrix.get(i, k) * matrix2.get(k, j);
                }
                Assertions.assertEquals(value, matrix3.get(i, j));
            }
        }

    }

    @Test
    void testTimesScalar() {
        double[][] data = new double[][]{
                {1, 2, 3},
                {4, 5, 6}
        };
        IMatrix matrix = MatrixFactory.instance.create(data);
        IMatrix matrix2 = matrix.times(10);
        for (int i = 0; i < data.length; i++) {
            double[] row = data[i];
            for (int j = 0; j < row.length; j++) {
                double value = row[j] * 10;
                Assertions.assertEquals(value, matrix2.get(i, j));
            }
        }
    }

    @Test
    void add() {
        double[][] data = new double[][]{
                {1, 2, 3},
                {4, 5, 6}
        };
        double[][] data2 = new double[][]{
                {1, 2, 3},
                {4, 5, 6}
        };
        IMatrix matrix = MatrixFactory.instance.create(data);
        IMatrix matrix2 = MatrixFactory.instance.create(data2);
        IMatrix matrix3 = matrix.add(matrix2);
        for (int i = 0; i < data.length; i++) {
            double[] row = data[i];
            double[] row2 = data2[i];
            for (int j = 0; j < row.length; j++) {
                double value = row[j] + row2[j];
                Assertions.assertEquals(value, matrix3.get(i, j));
            }
        }
    }

    @Test
    void transpose() {
        double[][] data = new double[][]{
                {1, 2, 3},
                {4, 5, 6}
        };
        IMatrix matrix = MatrixFactory.instance.create(data);
        IMatrix matrix2 = matrix.transpose();
        for (int i = 0; i < matrix2.getRows(); i++) {
            for (int j = 0; j < matrix2.getColumns(); j++) {
                Assertions.assertEquals(matrix2.get(i, j), matrix.get(j, i));
            }
        }

    }

    @Test
    void isSquare() {
        double[][] data = new double[][]{
                {1, 2, 3},
                {4, 5, 6}
        };
        IMatrix matrix = MatrixFactory.instance.create(data);
        boolean square = matrix.isSquare();
        Assertions.assertEquals(false, square);
    }

    @Test
    void isDiagonal() {
        double[][] data = new double[][]{
                {1, 0, 0},
                {0, 5, 0},
                {0, 0, 6}
        };
        IMatrix matrix = MatrixFactory.instance.create(data);
        boolean diagonal = matrix.isDiagonal();
        Assertions.assertTrue(diagonal);
    }

    @Test
    void getTrace() {
        double[][] data = new double[][]{
                {1, 0, 0},
                {0, 5, 0},
                {0, 0, 6}
        };
        IMatrix matrix = MatrixFactory.instance.create(data);
        double trace = matrix.getTrace().doubleValue();
        Assertions.assertEquals(12, trace);

    }
}