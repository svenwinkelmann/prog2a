class Student:

    def __init__(self, number, name, email):
        self.number = number
        self.name = name
        self.email = email

    def __str__(self):
        return f"Student: {self.name} ({self.email}, {self.number})"