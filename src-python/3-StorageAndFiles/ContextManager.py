class MyContextManager:
    def __init__(self, filename, mode):
        print("Fkt: __init__")
        self.filename = filename
        self.mode = mode

    def __enter__(self):
        print("Fkt: __enter__")
        self.file = open(self.filename, self.mode)
        return self.file

    def __exit__(self, exc_type, exc_val, exc_tb):
        print("Fkt: __exit__")
        self.file.close()


if __name__ == "__main__":

    content = ""
    with MyContextManager("textdatei.txt", "r") as f:
        print("Enter ContextManager")
        content = f.read()
    print("Exit ContextManager")
    print(content)