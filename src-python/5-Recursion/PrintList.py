from collections import deque

def print_list(queue: deque[int]):
    if len(queue) <= 0:  # base case
        return

    i = queue.popleft()
    print(f"{i}, ", end='')  # insertion order
    print_list(queue)  # recursive case
    print(f"{i}, ", end='')  # reverse order

def main():
    queue = deque([4, 9, 2, 10, 34, 76])
    print_list(queue)

if __name__ == "__main__":
    main()