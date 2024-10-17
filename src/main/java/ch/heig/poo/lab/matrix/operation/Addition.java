package ch.heig.poo.lab.matrix.operation;

import ch.heig.poo.lab.matrix.Matrix;

public class Addition extends Operation {
	@Override
	public Matrix apply(Matrix A, Matrix B) {
		checkMatrixPreconditions(A, B);

		Matrix result = new Matrix(
			A.getM(),
			A.getN(),
			A.getModulus()
		);

		if (A.getM() != B.getM() || A.getN() != B.getN()) {
			throw new RuntimeException("Matrix dimensions do not match");
		}

		for (int i = 0; i < result.getM(); ++i) {
			for (int j = 0; j < result.getN(); ++j) {
				result.set(i, j, (A.get(i, j) + B.get(i, j)) % A.getModulus());
			}
		}

		return result;
	}
}
