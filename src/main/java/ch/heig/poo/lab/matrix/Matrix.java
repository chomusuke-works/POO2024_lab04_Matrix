package ch.heig.poo.lab.matrix;

public class Matrix {
	private final int m;
	private final int n;
	private final int modulus;

	public Matrix(int m, int n, int modulus) {
		this.m = m;
		this.n = n;
		this.modulus = modulus;
	}

	public int getM() {
		return m;
	}

	public int getN() {
		return n;
	}

	public int getModulus() {
		return modulus;
	}

	public int get(int x, int y) {
		return 0;  // TODO implemented in different branch
	}

	public Matrix copy() {
		Matrix result = new Matrix(m, n, modulus);

		return result;  // TODO implemented in different branch
	}

	@Override
	public String toString() {
		return "";
	}
}
