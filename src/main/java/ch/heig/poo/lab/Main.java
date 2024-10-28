package ch.heig.poo.lab;

import ch.heig.poo.lab.matrix.Matrix;
import ch.heig.poo.lab.matrix.operation.Addition;
import ch.heig.poo.lab.matrix.operation.Multiplication;
import ch.heig.poo.lab.matrix.operation.Subtraction;

public class Main {
	public static void main(String[] args) {
		if (args.length != 5) throw new IllegalArgumentException("Usage: <m1> <n1> <m2> <n2> <modulus>");

		int m1 = Integer.parseInt(args[0]);
		int n1 = Integer.parseInt(args[1]);
		int m2 = Integer.parseInt(args[2]);
		int n2 = Integer.parseInt(args[3]);
		int modulus = Integer.parseInt(args[4]);

		Matrix first = new Matrix(m1, n1, modulus);
		Matrix second = new Matrix(m2, n2, modulus);

		System.out.printf("The module is: %d\n", modulus);

		System.out.printf("one\n%s\n\n", first);

		System.out.printf("two\n%s\n\n", second);

		System.out.printf("one + two\n%s\n\n", new Addition().apply(first, second));

		System.out.printf("one - two\n%s\n\n", new Subtraction().apply(first, second));

		System.out.printf("one x two\n%s\n\n", new Multiplication().apply(first, second));
	}
}