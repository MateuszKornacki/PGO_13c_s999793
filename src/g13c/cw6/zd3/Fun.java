package g13c.cw6.zd3;

interface Fun {

    double f(double x);

    static double minimum(Fun func, double a, double b, double alpha){
        double x=a;
        double min=func.f(x);
        while(x<=b){
            double y=func.f(x);
            if(y<min) min=y;
            x+=alpha;
        }
        return min;
    }

}
