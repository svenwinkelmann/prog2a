import pandas as pd

# we generate a dataset with ChatGPT
dataframe = pd.read_csv('person_data.csv')

# head gives us the first 5 rows of our dataframe
print(dataframe.head())

# similar we can use slicing (dataframe is an iterable)
print(dataframe[:5])

# with [colum_name] wie select only one column
print(dataframe['Name'].head(50))

# we can use the number in a single column with internal python functions, e.g.
print("\nAnzahl an Kinder: ", sum(dataframe['Kinder']))
print("\nDurchschnittliche Kinderanzahl: ", sum(dataframe['Kinder']) / len(dataframe['Kinder']))

# we can select rows based on the content (expression needs to be True)
print("\nVerheirate Personen: ", len(dataframe[dataframe['Verheiratet']]))
print("\nNamen beginnen mit 'A':\n", dataframe[dataframe['Name'].str.startswith('A')])
print("\nPersonen mit Googlemail:\n", dataframe[dataframe.apply(lambda x: 'googlemail.com' in x['Email'], axis=1)])
