package cz.educanet.matrices;

public class MatrixFactory implements IMatrixFactory {

    public static final IMatrixFactory instance = new MatrixFactory();

    private MatrixFactory() {
    }

    @Override
    public IMatrix create(double[][] data) {
        return new Matrix(data);
    }

    @Override
    public IMatrix createDiagonal(double[] diagonal) {
        if (diagonal.length < 0)
            throw new IllegalArgumentException();

        double[][] data = new double[diagonal.length][diagonal.length];

        for (int i = 0; i < diagonal.length; i++) {
            data[i][i] = diagonal[i];
        }

        return new Matrix(data);
    }

    @Override
    public IMatrix createIdentity(int size) {
        if (size < 0)
            throw new IllegalArgumentException();

        double[][] data = new double[size][size];

        for (int i = 0; i < size; i++) {
            data[i][i] = 1;
        }

        return new Matrix(data);

    }

    @Override
    public IMatrix createZero(int size) {

        if (size < 0) {throw new IllegalArgumentException();}

        double[][] data = new double[size][size];

        for (int i = 0; i < size; i++) {
            data[i][i] = 0;
        }

        return new Matrix(data);
    }
}
