package ds.backtracking.knapsack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Total Allowed Weight: ");
        int W = sc.nextInt();

        System.out.println("Enter Total number of elements in your weight/profit array: ");
        int n = sc.nextInt();

        int[] profit = new int[n];
        int[] weight = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter weight of item: " + (i + 1));
            int enteredWeight = sc.nextInt();
            weight[i] = enteredWeight;

            System.out.println("Enter profit of item: " + (i + 1));
            int enteredProfit = sc.nextInt();
            profit[i] = enteredProfit;
        }

        Knapsack knapsack = new Knapsack();
        int answer = knapsack.solveProblem(W, weight, profit, n);
        System.out.println("------------------------------------------------");
        System.out.println("Here is the answer for your input: " + answer);

        sc.close();
    }
}
