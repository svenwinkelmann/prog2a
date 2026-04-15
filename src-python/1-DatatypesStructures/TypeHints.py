def some_fkt(a: int, b: dict[str, float]) -> tuple[int, str, float]:
    c = a
    print(b)
    return (4, "sdt", 4.0)

if __name__ == "__main__":
    print(some_fkt(3, "str"))