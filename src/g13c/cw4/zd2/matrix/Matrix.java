package g13c.cw4.zd2.matrix;

import java.util.function.BiFunction;

public class Matrix {

    private static int[][] matrixTemp=null;
    private static int insertCursor=0;

    /* static create */
    public static void setUpMatrix(int rowSize, int columnSize){
        if(rowSize<=1 || columnSize<=1)throw new IllegalArgumentException("Jeden z rozmiarów macierzy jest niepoprawny");
        if(matrixTemp!=null) throw new RuntimeException("Macierz jest w trakcie tworzenia");
        matrixTemp = new int[rowSize][columnSize];
    }

    public static void insertRow(int[] row){
        if(matrixTemp == null) throw new RuntimeException("Nie rozpoczęto tworzenia macierzy");
        if(insertCursor >= matrixTemp.length) throw new RuntimeException("Macierz jest już pełna");
        if(matrixTemp[insertCursor].length != row.length) throw new IllegalArgumentException("Wprowadzony wiersz jest niepoprawny, ma niepoprawny rozmiar ");
        matrixTemp[insertCursor]=row.clone();
        insertCursor++;
    }

    public static Matrix create(){
        if(matrixTemp==null)throw new RuntimeException("Nie rozpoczęto tworzenia macierzy");
        if(matrixTemp.length != insertCursor)throw new RuntimeException("Nie zakończono tworzenia macierzy");
        Matrix result = new Matrix();
        matrixTemp = null;
        insertCursor = 0;
        return result;
    }
    /* end static create */

    /* static checks */
    private static void checkEquals(Matrix m1, Matrix m2){
        if(!m1.equals(m2)) throw new RuntimeException("Macierze nie są równe");
    }

    private static void checkToMultiply(Matrix m1, Matrix m2){
        if(m1.getSize().getX() != m2.getSize().getY()) throw new RuntimeException("Macierzy nie można mnożyć");
    }
    /* end static checks */

    /* static operations */
    public static Matrix add(Matrix m1, Matrix m2){
        checkEquals(m1,m2);
        return new Matrix(getMatrixByFunction(m1, m2, (y,x)-> m1.getValue(y,x) + m2.getValue(y,x)));
    }

    public static Matrix subtract(Matrix m1, Matrix m2){
        checkEquals(m1,m2);
        return new Matrix(getMatrixByFunction(m1, m2, (y,x)-> m1.getValue(y,x) - m2.getValue(y,x)));
    }

    public static Matrix multiply(Matrix m1, Matrix m2){
        checkToMultiply(m1, m2);
        return new Matrix(getMatrixByFunction(m1,m2, (y, x)->getMatrixCellAfterMultiply(m1,m2, y, x)));
    }

    private static int[][] getMatrixByFunction(Matrix m1, Matrix m2, BiFunction<Integer, Integer, Integer> biFunction){
        int[][] result = new int[m1.getSize().getY()][m2.getSize().getX()];
        for(int y=0; y<result.length; y++){
            for(int x=0; x<result[y].length; x++){
                result[y][x] = biFunction.apply(y,x);
            }
        }
        return result;
    }

    private static int getMatrixCellAfterMultiply(Matrix m1, Matrix m2, int y, int x) {
        int cell = 0;
        for (int i = 0; i < m2.getSize().getY(); i++) {
            cell += m1.getValue(y, i) * m2.getValue(i, x);
        }
        return cell;
    }
    /* end static operations */


    private int[][] matrix=null;
    private final Size size;

    private Matrix(){
        this(matrixTemp);
    }

    private Matrix(int[][] matrix){
        this.matrix = matrix;
        size = new Size(this.matrix.length, this.matrix[0].length);
    }

    public void print(){
        int[] maxColumns = new int[getSize().getX()];
        boolean[] isMinus = new boolean[getSize().getX()];

        for(int x=0; x<getSize().getX(); x++){
            int maxY=0;
            for(int y=0; y<getSize().getY(); y++){
                int value = getValue(y, x);
                if(value<0)isMinus[x]=true;
                String val = String.valueOf(Math.abs(value));
                if(maxY<val.length())maxY=val.length();
            }
            maxColumns[x]=maxY;
        }

        for(int y=0; y<getSize().getY(); y++){
            System.out.print("|");
            for(int x=0; x<getSize().getX(); x++){
                int val = getValue(y,x);
                System.out.printf(isMinus[x]?(val<0?" -":"  ")+"%-"+maxColumns[x]+"d":" %-"+maxColumns[x]+"d", Math.abs(val));
            }
            System.out.println(" |");
        }

    }

    public Matrix add(Matrix m){
        checkEquals(this, m);
        return getAndSetMatrix(m, (y, x)-> this.getValue(y,x) + m.getValue(y,x));
    }

    public Matrix subtract(Matrix m){
        checkEquals(this, m);
        return getAndSetMatrix(m, (y, x)-> this.getValue(y,x) - m.getValue(y,x));
    }

    public Matrix multiply(Matrix m){
        checkToMultiply(this, m);
        return getAndSetMatrix(m, (y, x)->getMatrixCellAfterMultiply(this, m, y, x));
    }

    private Matrix getAndSetMatrix(Matrix m2, BiFunction<Integer, Integer, Integer> biFunction){
        matrix = getMatrixByFunction(this, m2, biFunction);
        return this;
    }

    Size getSize(){
        return size;
    }

    int getValue(int y, int x){
        if(getSize().getX() <= x || getSize().getY() <= y) throw new IllegalArgumentException("Niepoprawna pozycja y:"+y+" x:"+x + " size: "+getSize());
        return matrix[y][x];
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Matrix)) return false;
        Matrix objectMatrix = (Matrix) object;
        return objectMatrix.getSize().equals(getSize());
    }

    private class Size {
        private final int y;
        private final int x;
        public Size(int y, int x){
            this.y=y;
            this.x=x;
        }
        public int getY(){
            return y;
        }

        public int getX(){
            return x;
        }

        @Override
        public boolean equals(Object object){
            if(!(object instanceof Size))return false;
            Size objectSize = (Size) object;
            if(getY() != objectSize.getY())return false;
            if(getX() != objectSize.getX())return false;
            return true;
        }

        @Override
        public String toString(){
            return "y: "+getY()+" x:"+getX();
        }
    }

}
