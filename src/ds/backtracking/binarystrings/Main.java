package ds.backtracking.binarystrings;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        BinaryStrings binaryStrings = new BinaryStrings(n);
        binaryStrings.binary(n);

        sc.close();
    }
}
