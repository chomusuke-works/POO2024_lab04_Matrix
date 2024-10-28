package ch.heig.poo.lab.matrix;

public class Matrix {
	private final int m;
	private final int n;
	private final int modulus;
	private final int[][] values;

	public Matrix(int m, int n, int modulus) {
		this.m = m;
		this.n = n;
		this.modulus = modulus;

		if (m <= 0 || n <= 0 || modulus <= 0) throw new IllegalArgumentException("Invalid arguments.");

		this.values = new int[m][n];
		for (int y = 0; y < m; y++) {
			for (int x = 0; x < n; x++) {
				values[y][x] = (int) Math.round(Math.random() * modulus) % modulus;
			}
		}
	}

	public Matrix(int m, int n, int modulus, int[] values) {
		this(m, n, modulus);

		if (values.length != m * n) throw new IllegalArgumentException("Invalid amount of values.");

		for (int y = 0; y < m; y++) {
            System.arraycopy(values, y * n, this.values[y], 0, n);
		}
	}

	public Matrix(int m, int n, int modulus, int[][] values) {
		this(m, n, modulus);

		if (values.length != m || (values.length != 0 && values[0].length != n)) throw new IllegalArgumentException("Invalid amount of values.");

		System.arraycopy(values, 0, this.values, 0, m);
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
		if (x < 0 || x >= n || y < 0 || y >= m) throw new IllegalArgumentException("Invalid coordinates.");

		return values[y][x];
	}

	public void set(int x, int y, int value) {
		if (x < 0 || x >= n || y < 0 || y >= m) throw new IllegalArgumentException("Invalid coordinates.");

		values[y][x] = value;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int y = 0; y < m; ++y) {
			for (int x = 0; x < n; ++x) {
				sb.append(values[y][x]);

				if (x < n - 1) sb.append(' ');
			}

			if (y < m -1) sb.append('\n');
		}

		return sb.toString();
	}
}
