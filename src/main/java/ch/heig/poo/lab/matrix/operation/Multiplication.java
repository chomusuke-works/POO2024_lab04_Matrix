package ch.heig.poo.lab.matrix.operation;

import ch.heig.poo.lab.matrix.Matrix;

public class Multiplication extends Operation {

	@Override
	public Matrix apply(Matrix A, Matrix B) {
		Matrix result = super.apply(A, B);

		if (A.getM() != B.getN()) {
			throw new RuntimeException("Incorrect dimensions for matrix multiplication");
		}

		for (int i = 0; i < A.getM(); ++i) {
			for (int j = 0; j < B.getN(); ++j) {
				int r = 0;
				for (int k = 0; k < A.getN(); ++k) {
					r += A.get(i, k) * B.get(k, j);
				}

				result.set(i, j, r % result.getModulus());
			}
		}

		return result;
	}
}
