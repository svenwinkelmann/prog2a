package techniques;

import acm.program.ConsoleProgram;

import java.util.*;

public class VendingMachine extends ConsoleProgram {

    public void initChangeMoney(TreeMap<Integer, Integer> coins) {
        coins.put(5, 3);  // three 5ct coins
        coins.put(10, 2);  // two 10ct coins
        coins.put(20, 3);  // ..
        coins.put(50, 2);
        coins.put(100, 2);
        coins.put(200, 1);
    }

    public void giveChangeGreedy(TreeMap<Integer, Integer> coins, int amount) {
        for (int coin: coins.keySet()) {
            int nrOfCoins = coins.get(coin);
            while((nrOfCoins > 0) && ((amount - coin) >= 0)) {
                amount = amount - coin;
                nrOfCoins--;
                print(coin + ", ");
            }
            coins.put(coin, nrOfCoins);
        }
    }

    public void run() {
        TreeMap<Integer, Integer> coins = new TreeMap<>(Collections.reverseOrder());

        initChangeMoney(coins);

        // just counting the number of coins, we do not care what their value is
        int numCoins = 0;
        for (int val: coins.values())
            numCoins += val;

        println("Coins: " + coins + "\n");
        println("Number of coins: " + numCoins);
        println("Brute force:");
        double numCombinations = Math.pow(2, numCoins);
        println("Number of combinations: " + numCombinations);
        println("Takes roughly (1ns / calculation): " + (numCombinations / (1000 * 1000)) + " sec");

        // so brute force is no option, let's have a look at greedy
        giveChangeGreedy(coins, 85);
    }
}
