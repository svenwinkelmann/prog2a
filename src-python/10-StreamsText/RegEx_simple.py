import re

text = "Hallo, wie geht es dir? Meine Nummer ist +4915861256451. Rufe mich an, wenn es bei dir passt. VG"
match = re.search(r"Hallo", text)
if match:
    print(match.group())

match = re.search(r"\+49\d{10,12}", text)
if match:
    print(match.group())