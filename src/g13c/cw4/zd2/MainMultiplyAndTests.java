package g13c.cw4.zd2;

import g13c.cw4.zd2.matrix.Matrix;

public class MainMultiplyAndTests {


    public static void main(String[] args){
        System.out.println("Mnożenie:");
        Matrix.setUpMatrix(2,3);
        Matrix.insertRow(new int[]{1,2,3});
        Matrix.insertRow(new int[]{4,5,6});
        Matrix matrixAM = Matrix.create();
        System.out.println("Matrix AM:");
        matrixAM.print();
        Matrix.setUpMatrix(3,2);
        Matrix.insertRow(new int[]{9,8});
        Matrix.insertRow(new int[]{6,5});
        Matrix.insertRow(new int[]{3,2});
        Matrix matrixBM = Matrix.create();
        System.out.println("Matrix BM:");
        matrixBM.print();

        System.out.println("Matrix AM x BM:");
        Matrix.multiply(matrixAM, matrixBM).print();
        System.out.println("Matrix BM x AM:");
        Matrix.multiply(matrixBM, matrixAM).print();

        Matrix.setUpMatrix(2,4);
        Matrix.insertRow(new int[]{1,2,3,9});
        Matrix.insertRow(new int[]{4,5,6,5});
        Matrix matrixAXM = Matrix.create();
        System.out.println("Matrix AXM:");
        matrixAXM.print();
        Matrix.setUpMatrix(4,2);
        Matrix.insertRow(new int[]{9,8});
        Matrix.insertRow(new int[]{6,5});
        Matrix.insertRow(new int[]{3,2});
        Matrix.insertRow(new int[]{7,1});
        Matrix matrixBXM = Matrix.create();
        System.out.println("Matrix BXM:");
        matrixBXM.print();

        System.out.println("Matrix AXM x BM:");
        try {
            Matrix.multiply(matrixAXM, matrixBM).print();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Matrix AM x BXM:");
        try {
            Matrix.multiply(matrixAM, matrixBXM).print();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        //Testy niepoprawnego tworzenia macierzy
        System.out.println("Testy niepoprawnego tworzenia macierzy:");

        //Jeden z rozmiarów macierzy jest niepoprawny
        try {
            Matrix.setUpMatrix(1,1);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        //Jeden z rozmiarów macierzy jest niepoprawny
        try {
            Matrix.setUpMatrix(0,2);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        //"Nie rozpoczęto tworzenia macierzy"
        try {
            Matrix.insertRow(new int[]{7, 8, 9});
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        //"Nie rozpoczęto tworzenia macierzy"
        try {
            Matrix.create();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        Matrix.setUpMatrix(3,3);
        //"Macierz jest w trakcie tworzenia"
        try {
            Matrix.setUpMatrix(3,3);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        Matrix.insertRow(new int[]{1,2,3});
        Matrix.insertRow(new int[]{4,5,6});

        //"Wprowadzony wiersz jest niepoprawny, ma niepoprawny rozmiar"
        try {
            Matrix.insertRow(new int[]{7, 8, 9, 8});
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        try {
            Matrix.insertRow(new int[]{7, 8});
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        //"Nie zakończono tworzenia macierzy"
        try {
            Matrix.create();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        Matrix.insertRow(new int[]{7,8,9});

        //"Macierz jest już pełna"
        try {
            Matrix.insertRow(new int[]{7, 8, 9});
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        Matrix.create();
    }
}
