from AppWindowPruefziffer import AppWindowPruefziffer
from ConsoleApplicationPruefziffer import ConsoleApplicationPruefziffer


class PruefzifferAlgorithm:
    def __init__(self):
        pass

    def check_isbn(self, isbn: str) -> bool:
        # TODO: Implement the ISBN validation here. You know enough python from prog1 to
        # implement the algorithm
        pass

    def check_iban(self, iban: str) -> bool:
        # TODO: Implement the IBAN validation here.

        # you can use the following code to move the first 4 digits to the end:
        iban = list(iban[4:] + iban[0:4])

        # to test if a character is alphanumeric (A, B, C, D, E, ..) or a number you can use the isalpha() function
        # https://docs.python.org/3.11/library/stdtypes.html#str.isalpha
        print(f"alphanumeric: D={'D'.isalpha()}, 4={'4'.isalpha()}")

        # to replace the Länderkürzel (e.g. DE) with numbers you can use the following code:
        # https://docs.python.org/3.11/library/functions.html#ord
        chars = ['D', 'E']
        for c in chars:
            char_num = str(10 + ord(c) - ord('A'))
            print(f"char_num: {char_num}")

        iban_number = ''

        # TODO: Some code goes in here

        return int(iban_number) % 97 == 1


if __name__ == "__main__":
    # p = PruefzifferAlgorithm()
    # test_isbn = '3-446-19313-8', '3-499-13599-X'
    # for i in test_isbn:
    #     print(p.check_isbn(i))
    #
    # test_iban = ['DE68 2105 0170 0012 3456 78', 'DE65 7005 0000 1301 1903 15']
    # for i in test_iban:
    #     print(p.check_iban(i))

    # TODO: you can switch between the console application and GUI by setting the flag CONSOLE to True or False
    CONSOLE = False

    pz_algorithm = PruefzifferAlgorithm()

    if CONSOLE:
        app = ConsoleApplicationPruefziffer(pz_algorithm)
        app.run()
    else:
        app = AppWindowPruefziffer(pz_algorithm, 320, 200, "Prüfziffer")
        app.run()