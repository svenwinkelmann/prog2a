
class UserTooDumpError(Exception):
    def be_polite_and_explain_to_user(self):
        return f"Oops! That’s not how division works: {self.args[0]}\n"


class PlayingWithExceptions:

    def divide(self, numerator: int, divisor: int) -> float:
        if divisor == 0:
            raise Exception("Do not divide /0")
        return float(numerator) / divisor

    def divide2(self, numerator: int, divisor: int) -> float:
        if divisor == 0:
            raise ZeroDivisionError("Do not divide /0")
        return float(numerator) / divisor

    def divide3(self, numerator: int, divisor: int) -> float:
        if divisor == 0:
            raise UserTooDumpError("Do not divide /0")
        return float(numerator) / divisor

    def call_divide3(self, numerator: int, divisor: int) -> float:
        return self.divide3(numerator, divisor)


if __name__ == "__main__":
    ex = PlayingWithExceptions()

    try:
        numerator = int(input("Enter numerator: "))
        divisor = int(input("Enter denominator: "))

        # Wähle aus, welche Methode du testen möchtest:
        #result = ex.divide(numerator, divisor)
        #result = ex.divide2(numerator, divisor)
        #result = ex.divide3(numerator, divisor)
        result = ex.call_divide3(numerator, divisor)

        print(f"Result: {result}")

    except ZeroDivisionError as e:
        print(f"ArithmeticError: {e}")
    except UserTooDumpError as e:
        print(e.be_polite_and_explain_to_user())
    except Exception as e:
        print(f"General exception: {e}")
    finally:
        print("Goodbye!")