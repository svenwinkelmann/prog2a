import tkinter as tk

class AppWindowPruefziffer:
    def __init__(self, pz_algorithm, width, height, title="Title"):
        self.root = tk.Tk()
        self.root.title(title)
        self.root.geometry(f"{width}x{height}")
        self.pz_algorithm = pz_algorithm

    def run(self):
        self.init_widgets()
        self.root.mainloop()
        self.close()

    def init_widgets(self):
        # TODO: Add your widgets here
        pass

    def close(self):
        pass

    def on_button_click_isbn(self):
        # TODO: validate the ISBN here, call self.pz_algorithm.check_isbn(isbn)
        pass

    def on_button_click_iban(self):
        # TODO: validate the IBAN here, call self.pz_algorithm.check_iban(isbn)
        pass
