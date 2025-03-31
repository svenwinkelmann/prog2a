

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


def modify_in_loops():
    print("\nmodify_in_loops()")
    my_list1 = [1, 2, 3, 4, 5, 6]

    for i in my_list1.copy():
        if i % 2 != 0:
            my_list1.remove(i)
    print("my_list1: ", my_list1)

    my_list2 = [1, 2, 3, 4, 5, 6]
    my_even_list = [x for x in my_list2 if x % 2 == 0]
    print("my_even_list: ", my_even_list)


if __name__ == "__main__":
    #mutable()
    #immutable()
    modify_in_loops()
