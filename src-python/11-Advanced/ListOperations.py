

def list_slicing():
    print("\n --- List Slicing ---")
    l = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]

    # get first elements from index 1 to 4 without slicing
    print("First 4 elements in l (without list slicing): ")
    new_list = []
    for i in range(1, 5):
        new_list.append(l[i])
    print("Without slicing: ", new_list)

    # get first elements from index 1 to 4 with list slicing
    new_list = l[1:5]  #[2, 3, 4, 5]
    print("l[1:5] ", new_list)

    # simplified syntax from index 0
    new_list = l[:5]
    print("l[:5]", new_list)

    # simplified syntax to list end
    new_list = l[7:]
    print("l[7:]", new_list)

    # negative indices
    new_list = l[-1]
    print("l[-1]", new_list)

    new_list = l[-3:]
    print("l[-3:]", new_list)

    new_list = l[:-3]
    print("l[:-3]", new_list)

    new_list = l[2:-3]
    print("l[2:-3]", new_list)

    # using step attribute
    new_list = l[::-2]
    print("l[::2]", new_list)

    new_list = l[3:9:2]
    print("l[3:9:2]", new_list)

def my_enumerate():
    print("\n --- Enumerate ---")
    fruit_buckets = ["apples", "bananas", "cherrys"]

    for index, frucht in enumerate(fruit_buckets):
        print(f"We put {frucht} in bucket {index}")

def my_zip():
    print("\n --- ZIP ---")
    names = ["Anna", "Ben", "Carla", "Fritz"]
    lecture_grades = [1, 2, 4, 1]
    prac_grades = [3, 2, 2]
    new_list = list(zip(names, lecture_grades, prac_grades))
    print(new_list)

def my_map():
    print("\n --- MAP ---")
    l = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
    new_list = list(map(add_two, l))
    print(new_list)

def add_two(val):
    return val + 2

def my_filter():
    print("\n --- FILTER ---")
    l = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
    new_list = list(filter(divide_three, l))
    print(new_list)

def divide_three(val):
    return val % 3 == 0

def my_map_lambda():
    print("\n --- MAP with lambda ---")
    l = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
    new_list = list(map(lambda x: x+2, l))
    print(new_list)

def my_filter_lambda():
    print("\n --- FILTER with lambda ---")
    l = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
    new_list = list(filter(lambda x: x % 3 == 0, l))
    print(new_list)

if __name__ == "__main__":
    list_slicing()
    my_enumerate()
    my_zip()
    my_map()
    my_map_lambda()
    my_filter()
    my_filter_lambda()
