package ch.heig.poo.lab.matrix.operation;

import ch.heig.poo.lab.matrix.Matrix;

public abstract class Operation {

	/**
	 * Applies the current operation on the two given matrices.
	 *
	 * @param A the first matrix
	 * @param B the second matrix
	 *
	 * @return the resulting matrix
	 */
	public Matrix apply(Matrix A, Matrix B) {
		checkMatrixPreconditions(A, B);

		int resultM = Math.max(A.getM(), B.getM());
		int resultN = Math.max(A.getN(), B.getN());
		Matrix result = new Matrix(resultM, resultN, A.getModulus());

		for (int y = 0; y < resultM; ++y) {
			for (int x = 0; x < resultN; ++x) {
				int valueA = y < A.getM() && x < A.getN() ? A.get(x, y) : 0;
				int valueB = y < B.getM() && x < B.getN() ? B.get(x, y) : 0;
				result.set(x, y, absMod(componentOperation(valueA, valueB), result.getModulus()));
			}
		}

		return result;
	}

	protected abstract int componentOperation(int a, int b);



	/**
	 * Returns the absolute modulus of a value.
	 * Implementation found on <a href="https://stackoverflow.com/questions/4467539/javascript-modulo-gives-a-negative-result-for-negative-numbers">StackOverflow</a>
	 *
	 * @param value an integer value
	 * @param mod the modulus
	 *
	 * @return the absolute modulus
	 */
	private int absMod(int value, int mod) {
		return ((value % mod) + mod) % mod;
	}

	/**
	 * Checks if the two given matrices correspond to the following criteria:
	 * - none of them is null
	 * - their modulos are the same
	 *
	 * @param A the first matrix
	 * @param B the second matrix
	 *
	 * @throws NullPointerException if a matrix is null
	 * @throws IllegalArgumentException if the matrices' modulos are different
	 */
	private static void checkMatrixPreconditions(Matrix A, Matrix B) {
		if (A == null || B == null) {
			throw new NullPointerException("Matrix cannot be null");
		}
		if (A.getModulus() != B.getModulus()) {
			throw new IllegalArgumentException("Matrices have different modulos");
		}
	}
}
