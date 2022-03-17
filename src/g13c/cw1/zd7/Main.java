package g13c.cw1.zd7;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scaner = new Scanner(System.in);

        int n = -1;

        while (n == -1) {
            System.out.println("Podaj liczbę n większą od 4 i nieparzystą");
            try {
                int temp = scaner.nextInt();
                if (temp > 4 && temp % 2 != 0) {
                    n = temp;
                } else {
                    System.out.println("Podałeś złą liczbę");
                }
            } catch (InputMismatchException e) {
                System.out.println("Podałeś złą wartość");
                scaner.next();
            }
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                System.out.print(getChar(x, y, n - 1));
            }
            System.out.print("\n");
        }
    }

    private static String getChar(int x, int y, int n) {
        return y == 0 || y == n || x == 0 || x == n || x == y ? "*" : " ";
    }
}
