package ds.backtracking.nqueen;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of N: ");
        int n = sc.nextInt();

        Nqueen queen = new Nqueen();
        queen.solveNQ(n);
    }
}
