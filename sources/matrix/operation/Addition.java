package matrix.operation;

public class Addition extends Operation {
	@Override
	protected int componentOperation(int a, int b) {
		return a + b;
	}
}