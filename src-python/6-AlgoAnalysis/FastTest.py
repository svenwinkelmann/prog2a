import math
import time
import numpy as np

FACT_N = 20
NUM_ITERATIONS = 1_000_000

# Lookup Tabellen
lookup_table = {}
lookup_table_array = np.zeros(FACT_N + 1)


def iterative_fac(n):
    product = 1
    for k in range(1, n + 1):
        product *= k
    return product


def recursive_fac(n):
    if n == 0:
        return 1
    return n * recursive_fac(n - 1)


def stirling_fac(n):
    return round(math.sqrt(2 * math.pi * n) * (n / math.e) ** n)


def lookup_table_fac(n):
    if n not in lookup_table:
        lookup_table[n] = iterative_fac(n)
    return lookup_table[n]


def lookup_table_array_fac(n):
    if lookup_table_array[n] == 0:
        lookup_table_array[n] = iterative_fac(n)
    return lookup_table_array[n]


def run():
    print("Running factorial performance tests...\n")

    # Iterative
    start = time.time()
    for _ in range(NUM_ITERATIONS):
        fac = iterative_fac(FACT_N)
    duration = (time.time() - start) * 1000
    print(f"Iterative: {fac} ({int(duration)}ms)")

    # Recursive
    start = time.time()
    for _ in range(NUM_ITERATIONS):
        fac = recursive_fac(FACT_N)
    duration = (time.time() - start) * 1000
    print(f"Recursive: {fac} ({int(duration)}ms)")

    # Stirling
    start = time.time()
    for _ in range(NUM_ITERATIONS):
        fac = stirling_fac(FACT_N)
    duration = (time.time() - start) * 1000
    print(f"Approximation: {fac} ({int(duration)}ms)")

    # Lookup mit dict
    start = time.time()
    for _ in range(NUM_ITERATIONS):
        fac = lookup_table_fac(FACT_N)
    duration = (time.time() - start) * 1000
    print(f"Lookup table with map: {fac} ({int(duration)}ms)")

    # Lookup mit Array
    start = time.time()
    for _ in range(NUM_ITERATIONS):
        fac = lookup_table_array_fac(FACT_N)
    duration = (time.time() - start) * 1000
    print(f"Lookup table with numpy array: {int(fac)} ({int(duration)}ms)")


if __name__ == "__main__":
    run()