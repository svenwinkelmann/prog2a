from datetime import date

def dict_sample():
    passport = {
        "name": "Mustermann",
        "given_name": "Erika",
        "date_of_birth": date(1983, 8, 12),
        "can": 938568
    }

    # adding a new key-value pair
    passport["place_of_birth"] = "Berlin"

    # iterate over all key-value pairs
    for (k, v) in passport.items():
        print(f"Key: {k} and Value: {v}")

    print("All keys in the dictionary: ", passport.keys())
    print("All values in the dictionary: ", passport.values())

    # be careful, keys need to be hashable!
    # passport[["a", "b"]] = "ldkfj" # ==> does not work!


def set_sample():
    # Example from:
    # https: // docs.python.org / 3 / tutorial / datastructures.html  # sets
    a = set('abracadabra')
    b = set('alacazam')

    print("Unique letters in a: ", a)

    print("Letters in a but not in b: ", a - b)

    print("Letters in a or b or both: ", a | b)

    print("Letters in both a and b: ", a & b)

    print("Letters in both a and b: ", a ^ b)


if __name__ == "__main__":
    dict_sample()
    set_sample()
    print("finished")
