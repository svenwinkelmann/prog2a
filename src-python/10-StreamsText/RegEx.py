import re

def parse_re_nr(text: str) -> str:
    re_nr = re.search(r'R\s\d{3}_20\d{4}-[W|E|D]', text)
    return re_nr.group() if re_nr else " nicht gefunden"

if __name__ == "__main__":

    with open("bill.txt", "r") as f:
        text = f.read()
        re_nr = parse_re_nr(text)
        print("Rechnungsnummer ist: ", re_nr)