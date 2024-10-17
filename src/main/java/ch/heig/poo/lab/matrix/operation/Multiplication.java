package ch.heig.poo.lab.matrix.operation;

import ch.heig.poo.lab.matrix.Matrix;

public class Multiplication extends Operation {

	@Override
	public Matrix apply(Matrix a, Matrix b) {
		Matrix result = super.apply(a, b);

		if (a.getM() != b.getN()) {
			throw new RuntimeException("Incorrect dimensions for matrix multiplication");
		}

		for (int i = 0; i < a.getM(); ++i) {
			for (int j = 0; j < b.getN(); ++j) {
				int r = 0;
				for (int k = 0; k < a.getN(); ++k) {
					r += a.get(i, k) * b.get(k, j);
				}

				result.set(i, j, r % result.getModulus());
			}
		}

		return result;
	}
}
