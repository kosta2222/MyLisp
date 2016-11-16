class NumberExpAst{
double val;

    public NumberExpAst(double val) {
        this.val = val;
    }

}

class VariableExpAst{
String name;

    public VariableExpAst(String name) {
        this.name = name;
    }


}

class BinaryExpAst{

char op;
double lhs;
double rhs;

    public BinaryExpAst(char op, double lhs, double rhs) {
        this.op = op;
        this.lhs = lhs;
        this.rhs = rhs;
    }

}