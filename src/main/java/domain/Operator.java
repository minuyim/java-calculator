package domain;

import java.util.Arrays;

public enum Operator {
	ADD("+") {
		@Override
		public int calculate(int operand1, int operand2) {
			return operand1 + operand2;
		}
	},
	SUBTRACT("-") {
		@Override
		public int calculate(int operand1, int operand2) {
			return operand1 - operand2;
		}
	},
	MULTIPLY("*") {
		@Override
		public int calculate(int operand1, int operand2) {
			return operand1 * operand2;
		}
	},
	DIVIDE("/") {
		@Override
		public int calculate(int operand1, int operand2) {
			return operand1 / operand2;
		}
	};

	private final String symbol;

	Operator(String symbol) {
		this.symbol = symbol;
	}

	public static Operator findBySymbol(String value) {
		return Arrays.stream(values())
			.filter(operator -> value.equals(operator.symbol))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException());
	}

	public abstract int calculate(int operand1, int operand2);

	public static boolean isOperatorSymbol(String symbol) {
		return Arrays.stream(Operator.values())
			.anyMatch(operator -> symbol.equals(operator.symbol));
	}
}
