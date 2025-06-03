class Finisher:

    def __init__(self, name: str, time: float):
        self.name = name
        self.time = time

    def __str__(self):
        return f"Snail {self.name} finished in {self.time} seconds"