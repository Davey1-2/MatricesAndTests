package cz.educanet.matrices;

public class Matrix implements IMatrix {

    private final double[][] rawArray;

    public Matrix(double[][] rawArray) {
        this.rawArray = rawArray;
    }

    @Override
    public IMatrix times(IMatrix matrix) {
        if (getColumns() != matrix.getRows()) {
            throw new IllegalArgumentException();
        }

        double[][] data = new double[getRows()][matrix.getColumns()];

        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                data[i][j] = 0;
                for (int k = 0; k < matrix.getRows(); k++) {
                    data[i][j] += rawArray[i][k] * matrix.get(k, j);
                }
            }
        }

        return new Matrix(data);
    }

    @Override
    public IMatrix times(Number scalar) {
        double[][] data = new double[getRows()][getColumns()];

        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                data[i][j] = rawArray[i][j] * scalar.doubleValue();
            }
        }

        return new Matrix(data);
    }

    @Override
    public IMatrix add(IMatrix matrix) {
        double[][] data = new double[getRows()][getColumns()];

        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                data[i][j] = rawArray[i][j] + matrix.get(i, j);
            }
        }

        return new Matrix(data);
    }

    /**
     * TODO: Implement
     */
    @Override
    public IMatrix transpose() {
        double[][] data = new double[getColumns()][getRows()];

        for (int i = 0; i < getColumns(); i++) {
            for (int j = 0; j < getRows(); j++) {
                data[i][j] = rawArray[j][i];
            }
        }

        return new Matrix(data);
    }

    /**
     * TODO: Implement
     */
    @Override
    public double determinant() {
        return 0;
    }

    /**
     * TODO: Implement
     */
    @Override
    public boolean isSquare() {
        if (getRows() != getColumns()) {
            return false;
        }

        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                if (i != j && rawArray[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * TODO: Implement
     */
    @Override
    public boolean isDiagonal() {

        double trace = 0;
        for (int i = 0; i < getRows(); i++) {
            trace += rawArray[i][i];
        }

        return getTrace().doubleValue() == trace;
    }

    /**
     * TODO: Implement
     */
    @Override
    public Number getTrace() {

        double[][] data = new double[getRows()][getColumns()];
        double sum = 0;
        for (int i = 0; i < getRows(); i++) {
            sum += rawArray[i][i];
        }
        return sum;

    }

    @Override
    public int getRows() {
        return rawArray.length;
    }

    @Override
    public int getColumns() {
        if (getRows() > 0)
            return rawArray[0].length;

        return 0;
    }

    @Override
    public double get(int n, int m) {
        if(n >= getRows() || n < 0 || m >= getColumns() || m < 0)
            throw new IllegalArgumentException();

        return rawArray[n][m];
    }
}
