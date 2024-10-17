package ch.heig.poo.lab.matrix.operation;

import ch.heig.poo.lab.matrix.Matrix;

public abstract class Operation {
	public Operation() {}

	public Matrix apply(Matrix a, Matrix b) {
		if (a.getModulus() != b.getModulus()) {
			throw new RuntimeException("Matrices have different modulos");
		}

		return new Matrix(
			Math.max(a.getM(), b.getM()),
			Math.max(a.getN(), b.getN()),
			a.getModulus()
		);
	}
}