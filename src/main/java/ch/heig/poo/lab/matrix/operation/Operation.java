package ch.heig.poo.lab.matrix.operation;

import ch.heig.poo.lab.matrix.Matrix;

public abstract class Operation {
	public Matrix apply(Matrix A, Matrix B) {
		checkMatrixPreconditions(A, B);

		int resultM = Math.max(A.getM(), B.getM());
		int resultN = Math.max(A.getN(), B.getN());
		Matrix result = new Matrix(resultM, resultN, A.getModulus());

		for (int y = 0; y < resultM; ++y) {
			for (int x = 0; x < resultN; ++x) {
				int valueA = y < A.getM() && x < A.getN() ? A.get(x, y) : 0;
				int valueB = y < B.getM() && x < B.getN() ? B.get(x, y) : 0;
				result.set(x, y, absMod(operate(valueA, valueB), result.getModulus()));
			}
		}

		return result;
	}

	// https://stackoverflow.com/questions/4467539/javascript-modulo-gives-a-negative-result-for-negative-numbers
	private int absMod(int value, int mod) {
		return ((value % mod) + mod) % mod;
	}

	private static void checkMatrixPreconditions(Matrix A, Matrix B) {
		if (A == null || B == null) {
			throw new NullPointerException("Matrix cannot be null");
		}
		if (A.getModulus() != B.getModulus()) {
			throw new RuntimeException("Matrices have different modulos");
		}
	}

	protected abstract int operate(int a, int b);
}
