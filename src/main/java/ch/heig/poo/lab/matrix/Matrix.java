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

	@Override
	public String toString() {
		return "";
	}
}
