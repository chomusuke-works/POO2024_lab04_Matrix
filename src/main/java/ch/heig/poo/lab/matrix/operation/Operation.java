package ch.heig.poo.lab.matrix.operation;

import ch.heig.poo.lab.matrix.Matrix;

public abstract class Operation {

	public Matrix apply(Matrix A, Matrix B) {
		if (A == null || B == null) {
			throw new NullPointerException("Matrix cannot be null");
		}
		if (A.getModulus() != B.getModulus()) {
			throw new RuntimeException("Matrices have different modulos");
		}

		return A.copy();
	}
}
