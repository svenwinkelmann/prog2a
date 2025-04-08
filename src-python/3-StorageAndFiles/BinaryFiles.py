
def read_width_length_from_png(filename: str) -> (int, int):
    with open(filename, "rb") as f:
        print("First byte: ", f.read(1))
        if f.read(3) != b'PNG':
            raise TypeError("Not a valid PNG format. Exit")
        not_relevant = f.read(12)
        width = int.from_bytes(f.read(4))
        height = int.from_bytes(f.read(4))
        return width, height

def write_number_to_file(filename: str, nr: int):
    with open(filename, "wb") as f:
        f.write(int.to_bytes(nr))
        f.write(str.encode("Hallo Welt"))


if __name__ == "__main__":
    filename = "bild.png"
    width, height = read_width_length_from_png(filename)
    print(f"The image file {filename} has width={width} and height={height}")

    write_number_to_file("text.dat", 65)