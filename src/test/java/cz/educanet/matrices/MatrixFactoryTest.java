package cz.educanet.matrices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MatrixFactoryTest {

    @Test
    void create() {
        double[][] data = new double[][]{
                {1, 2, 3},
                {4, 5, 6}
        };
        IMatrix matrix = MatrixFactory.instance.create(data);
        for (int i = 0; i < data.length; i++) {
            double[] row = data[i];
            for (int j = 0; j < row.length; j++) {
                double value = row[j];
                Assertions.assertEquals(value, matrix.get(i, j));
            }
        }
    }

    @Test
    void createDiagonal() {
        double[] diagonal = new double[]{1, 2, 3};
        IMatrix matrix = MatrixFactory.instance.createDiagonal(diagonal);
        for (int i = 0; i < diagonal.length; i++) {
            Assertions.assertEquals(diagonal[i], matrix.get(i, i));
        }
    }

    @Test
    void createIdentity() {
        IMatrix matrix = MatrixFactory.instance.createIdentity(3);
        for (int i = 0; i < 3; i++) {
            Assertions.assertEquals(1, matrix.get(i, i));
        }
    }

    @Test
    void createZero() {
        IMatrix matrix = MatrixFactory.instance.createZero(3);
        for (int i = 0; i < 3; i++) {
            Assertions.assertEquals(0, matrix.get(i, i));
        }
    }
}