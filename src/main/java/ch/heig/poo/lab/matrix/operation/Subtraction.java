package ch.heig.poo.lab.matrix.operation;

import ch.heig.poo.lab.matrix.Matrix;

public class Subtraction extends Operation {
	@Override
	public Matrix apply(Matrix A, Matrix B) {
		 checkMatrixPreconditions(A, B);

		 return new Addition().apply(A, B.inverse());
	}
}
