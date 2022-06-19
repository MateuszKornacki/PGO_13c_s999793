package g13c.cw6.zd3;

class LinearFunction extends Function{

    private double a;
    private double b;

    public LinearFunction(double a, double b){
        this.a=a;
        this.b=b;
    }

    @Override
    public double f(double x) {
        return (a*x)+b;
    }

    @Override
    void increaseCoefficientsBy(double delta) {
        a+=delta;
        b+=delta;

    }

    @Override
    void decreaseCoefficientsBy(double delta) {
        a-=delta;
        b-=delta;
    }

    protected double getA(){
        return a;
    }

    protected double getB(){
        return b;
    }

}
