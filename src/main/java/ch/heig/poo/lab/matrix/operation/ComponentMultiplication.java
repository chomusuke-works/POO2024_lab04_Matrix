package ch.heig.poo.lab.matrix.operation;

import ch.heig.poo.lab.matrix.Matrix;

public class ComponentMultiplication extends Operation {

    @Override
    public Matrix apply(Matrix A, Matrix B) {
        checkMatrixPreconditions(A, B);

        int resultM = Math.max(A.getM(), B.getM());
        int resultN = Math.max(A.getN(), B.getN());
        Matrix result = new Matrix(resultM, resultN, A.getModulus());

        for (int y = 0; y < resultM; ++y) {
            for (int x = 0; x < resultN; ++x) {
                int valueA = y < A.getM() && x < A.getN() ? A.get(x, y) : 1;
                int valueB = y < B.getM() && x < B.getN() ? B.get(x, y) : 1;
                result.set(x, y, (valueA * valueB) % result.getModulus());
            }
        }

        return result;
    }
}
