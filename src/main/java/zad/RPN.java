package zad;

public class RPN {
    private Stack stack;

    public RPN() {
        stack = new Stack();
    }

    public int evaluate(String expression) {
        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            if (isOperator(token)) {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                int result = applyOperator(token, a, b);
                stack.push(String.valueOf(result));
            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    private boolean isOperator(String token) {
        return "+".equals(token) || "-".equals(token) || "*".equals(token);
    }

    private int applyOperator(String operator, int a, int b) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            default:
                throw new IllegalArgumentException("Nieznany operator: " + operator);
        }
    }
}
