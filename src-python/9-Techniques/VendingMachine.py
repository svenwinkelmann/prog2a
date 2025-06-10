# We've learned that binary search trees are highly efficient data structures for
# maintaining ordered data. For our vending machine implementation, it would be
# very helpful if our dictionary maintained its keys in descending order. Java
# provides a built-in data structure called TreeMap for this purpose.
# Does Python offer something similar?

# Let's ask an LLM: "I need a size-ordered dictionary in Python. What data structure
# is efficient? Give an example."

# In Python, the built-in dict does not maintain the keys in sorted order — it maintains
# insertion order (since Python 3.7+). If you need a dictionary with keys automatically
# kept in sorted order, the most efficient solution is:
#   - use SortedDict from the sortedcontainers library
#   - keys stay automatically sorted.
#   - efficient operations: O(log n) for insert, delete, and lookup.
# Install it: pip install sortedcontainers
from sortedcontainers import SortedDict

class VendingMachine:
    def init_change_money(self, coins: list[int]) -> SortedDict:
        coins_desc = SortedDict(lambda x: -x)

        for coin in coins:
            coins_desc[coin] = coins_desc[coin] + 1 if coin in coins_desc else 1

        print(coins_desc)
        return coins_desc

    def give_change_greedy(self, coins: SortedDict, amount: int):
        for coin in coins.keys():
            nr_of_coins = coins[coin]
            while nr_of_coins > 0 and (amount - coin) >= 0:
                amount -= coin
                nr_of_coins -= 1
                print(coin, end=", ")
            coins[coin] = nr_of_coins

    def run(self):
        coins = [5, 5, 5, 10, 10, 20, 20, 20, 50, 50, 100, 100, 200]
        coins_sorted = self.init_change_money(coins)

        # just counting the number of coins, we do not care what their value is
        num_coins = sum(coins_sorted.values())

        print("Coins:", coins, "\n")
        print("Number of coins:", num_coins)
        print("Brute force:")
        num_combinations = 2 ** num_coins
        print("Number of combinations:", num_combinations)
        print("Takes roughly (1ns / calculation):", num_combinations / (1000 * 1000), "sec")

        # so brute force is no option, let's have a look at greedy
        print("Greedy:")
        self.give_change_greedy(coins_sorted, 85)

if __name__ == "__main__":
    vm = VendingMachine()
    vm.run()