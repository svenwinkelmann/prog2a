def iterative_fac(n):
    product = 1
    for k in range(1, n + 1):
        product *= k
    return product

def recursive_fac(n):
    if n == 0:      # base case
        return 1
    return n * recursive_fac(n - 1)  # recursive case

def sum_recursive(n):
    if n == 0:      # base case
        return 0
    return n + sum_recursive(n - 1)  # recursive case

if __name__ == "__main__":
    fact_n = 5

    print("Iterative output:", iterative_fac(fact_n))
    print("Recursive output:", recursive_fac(fact_n))
    print(f"Sum from 1 to {fact_n}: {sum_recursive(fact_n)}")