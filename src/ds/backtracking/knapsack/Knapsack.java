package ds.backtracking.knapsack;

public class Knapsack {

    /**
     * From Geeks for Geeks
     * <p>
     * A simple solution is to consider all subsets of items and calculate the total weight and profit of all subsets. Consider the only subsets whose total weight is smaller than W. From all such subsets, pick the subset with maximum profit.
     * Optimal Substructure: To consider all subsets of items, there can be two cases for every item.
     * Case 1: The item is included in the optimal subset.
     * Case 2: The item is not included in the optimal set.
     * </p>
     *
     * <p>
     * Follow the below steps to solve the problem:
     * The maximum value obtained from ‘N’ items is the max of the following two values.
     * Case 1 (include the Nth item):
     * Value of the Nth item plus maximum value obtained by remaining N-1 items and remaining weight i.e. (W minus weight of the Nth item).
     * Case 2 (exclude the Nth item):
     * Maximum value obtained by N-1 items and W weight.
     * If the weight of the ‘Nth‘ item is greater than ‘W’, then the Nth item cannot be included and Case 2 is the only possibility.
     * </p>
     *
     * @param W      - Total weight
     * @param wt     - Array of weights
     * @param profit - Array of profits
     * @param n      - number of items
     **/
    public int solveProblem(int W, int[] wt, int[] profit, int n) {
        if (W == 0 || n == 0) {
            return 0;
        }

        // If weight of the nth item is
        // more than Knapsack capacity W,
        // then this item cannot be included
        // in the optimal solution
        if (wt[n - 1] > W) {
            return solveProblem(W, wt, profit, n - 1);
        }

        // Return the maximum of two cases:
        // (1) nth item included
        // (2) not included
        return Math.max(
                solveProblem(W, wt, profit, n - 1), // not included
                solveProblem(W - wt[n - 1], wt, profit, n - 1) + profit[n - 1] // included
        );
    }
}
