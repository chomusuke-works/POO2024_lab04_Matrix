package ch.heig.poo.lab;

import ch.heig.poo.lab.matrix.Matrix;
import ch.heig.poo.lab.matrix.operation.Multiplication;

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

		System.out.println("The module is: " + modulus);
		System.out.println();

		System.out.println("one");
		System.out.println(first);
		System.out.println();

		System.out.println("two");
		System.out.println(second);
		System.out.println();

		System.out.println("one x two");
		System.out.println(new Multiplication().apply(first, second));
	}
}