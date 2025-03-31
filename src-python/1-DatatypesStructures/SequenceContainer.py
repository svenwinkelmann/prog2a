import numpy as np
import time
import random

from collections import deque

from Student import Student
from ListElement import ListElement

def using_numpy_arrays():
    print("----- using_numpy_arrays() -----")

    # with objects
    student_paul = Student(3234, 'Paul', 'paul@th-nuernberg.de')
    student_max = Student(4983, 'Max', 'max@th-nuernberg.de')
    student_maria = Student(7886, 'Maria', 'maria@th-nuernberg.de')

    student_array = np.array([student_paul, student_max, student_maria])

    print(f"First student: {student_array[0].name}")
    for s in student_array:
        print(s.name)

    # simple datatypes, usually used in machine learning
    weights = np.array([0.35, 0.24, 0.35, 0.45])
    print(f"Number of elements: {len(weights)}, Second element: {weights[1]}")

    n_dim = np.array([[0, 4, 2],
                      [3, 4, 5]])
    print(f"content of n_dim: \n{n_dim}")
    print(f"shape of n_dim: {n_dim.shape}")

    print("\n\n")


def linked_list():
    print("----- linked_list() -----")

    student_paul = Student(3234, 'Paul', 'paul@th-nuernberg.de')
    student_max = Student(4983, 'Max', 'max@th-nuernberg.de')
    student_maria = Student(7886, 'Maria', 'maria@th-nuernberg.de')

    start = ListElement(student_paul)
    start.next = ListElement(student_max)
    start.next.next = ListElement(student_maria)

    list_element = start
    while list_element:
        print(f"Student name: {list_element.object.name}")
        list_element = list_element.next

    print("\n\n")


def stack():
    print("----- stack() -----")

    student_paul = Student(3234, 'Paul', 'paul@th-nuernberg.de')
    student_max = Student(4983, 'Max', 'max@th-nuernberg.de')
    student_maria = Student(7886, 'Maria', 'maria@th-nuernberg.de')

    stack = []

    # push students on stack
    stack.append(student_paul)
    stack.append(student_max)
    stack.append(student_maria)

    # pop students from stack
    print("1. Student ", stack.pop().name)
    print("2. Student ", stack.pop().name)
    print("3. Student ", stack.pop().name)

    # as pop removes the list element the stack is now empty
    print(f"List length: {len(stack)}")

    print("\n\n")


def queue():
    print("----- queue() -----")

    student_paul = Student(3234, 'Paul', 'paul@th-nuernberg.de')
    student_max = Student(4983, 'Max', 'max@th-nuernberg.de')
    student_maria = Student(7886, 'Maria', 'maria@th-nuernberg.de')

    # we can use a built-in list, however, this is not recommended due to runtime of pop(0) O(n)
    # Therefore, we use the deque implementation from collections
    queue = deque()

    # push students on queue
    queue.append(student_paul)
    queue.append(student_max)
    queue.append(student_maria)

    # pop students from queue
    print("1. Student ", queue.popleft().name)
    print("2. Student ", queue.popleft().name)
    print("3. Student ", queue.popleft().name)

    # as pop removes the list element the queue is now empty
    print(f"List length: {len(queue)}")

    print("\n\n")


def performance_testing():
    print("----- performance_testing() -----")
    NUM_ELEMENTS = 100000

    random_list_of_ints = [random.randint(-2000, 2000) for _ in range(NUM_ELEMENTS)]

    # ------ adding an element ------
    # numpy array
    np_array = np.array([])
    ms_before = int(time.time() * 1000)
    for i in random_list_of_ints:
        np_array = np.append(np_array, i)
    ms_after = int(time.time() * 1000)
    print(f"Adding {len(np_array)} integers to a numpy array takes \t {ms_after-ms_before} ms")

    # python list
    built_in_list = []
    ms_before = int(time.time() * 1000)
    for i in random_list_of_ints:
        built_in_list.append(i)
    ms_after = int(time.time() * 1000)
    print(f"Adding {len(built_in_list)} integers to a built-in list takes \t\t {ms_after-ms_before} ms")

    # ------ get element at position ------
    # numpy array
    stupid_sum = 0
    ms_before = int(time.time() * 1000)
    for i in random_list_of_ints:
        stupid_sum += np_array[i]
    ms_after = int(time.time() * 1000)
    print(f"Getting {len(random_list_of_ints)} integers of a numpy array takes \t\t {ms_after - ms_before} ms")

    # python list
    stupid_sum = 0
    ms_before = int(time.time() * 1000)
    for i in random_list_of_ints:
        stupid_sum += built_in_list[i]
    ms_after = int(time.time() * 1000)
    print(f"Getting {len(random_list_of_ints)} integers of a build-in list takes \t {ms_after - ms_before} ms")

    print("\n\n")

if __name__ == "__main__":
    using_numpy_arrays()

    performance_testing()

    linked_list()

    queue()
    stack()