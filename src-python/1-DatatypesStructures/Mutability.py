

def mutable():
    print("\nmutable()")
    my_list = [1, 2, 3]
    print("ID before append: ", id(my_list))

    my_list.append(4)
    print("ID after append: ", id(my_list))


def immutable():
    print("\nimmutable()")
    my_string = "Hello"
    print("ID before append: ", id(my_string))

    my_string = my_string + " World"
    print("ID after append: ", id(my_string))


if __name__ == "__main__":
    mutable()
    immutable()
