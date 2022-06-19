package g13c.cw6.zd3;

class SquareFunction extends LinearFunction{

    private double c;

    public SquareFunction(double a, double b, double c){
        super(a,b);
        this.c=c;
    }


    @Override
    public double f(double x) {
        return (getA()*(Math.pow(x,2)))+(getB()*x)+c;
    }

    @Override
    void increaseCoefficientsBy(double delta) {
        super.increaseCoefficientsBy(delta);
        c+=delta;

    }

    @Override
    void decreaseCoefficientsBy(double delta) {
        super.decreaseCoefficientsBy(delta);
        c-=delta;

    }
}
