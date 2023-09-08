// Visitor
interface ExpressionVisitor {
    String visit(Number number);
    String visit(Sum sum);
    String visit(NegativeExpression negExpr);
}

// Element
interface Expression {
    String accept(ExpressionVisitor visitor);
}

// Concrete Elements
class Number implements Expression {
    private int value;

    public Number(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String accept(ExpressionVisitor visitor) {
        return visitor.visit(this);
    }
}

class Sum implements Expression {
    private Expression leftExpression;
    private Expression rightExpression;

    public Sum(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public String accept(ExpressionVisitor visitor) {
        return visitor.visit(this);
    }

    public Expression getLeftExpression() {
        return leftExpression;
    }

    public Expression getRightExpression() {
        return rightExpression;
    }
}

class NegativeExpression implements Expression {
    private Expression expression;

    public NegativeExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public String accept(ExpressionVisitor visitor) {
        return visitor.visit(this);
    }

    public Expression getExpression() {
        return expression;
    }
}

// Concrete Visitor
class ExpressionToStringVisitor implements ExpressionVisitor {
    @Override
    public String visit(Number number) {
        return Integer.toString(number.getValue());
    }

    @Override
    public String visit(Sum sum) {
        String left = sum.getLeftExpression().accept(this);
        String right = sum.getRightExpression().accept(this);
        return "(" + left + "+" + right + ")";
    }

    @Override
    public String visit(NegativeExpression negExpr) {
        String expr = negExpr.getExpression().accept(this);
        return "(-" + expr + ")";
    }
}

public class ArithmeticExpressionToString {
    public static void main(String[] args) {
        // Erstellen des Beispiel-Ausdrucks: ((-2)+5)-2
        Expression expr = new Sum(new Sum(new NegativeExpression(new Number(2)), new Number(5)), new NegativeExpression(new Number(2)));

        ExpressionVisitor visitor = new ExpressionToStringVisitor();
        String expressionString = expr.accept(visitor);

        System.out.println("Repräsentation des Ausdrucks: " + expressionString);
    }
}
