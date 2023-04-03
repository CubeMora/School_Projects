import nltk


G1 = nltk.CFG.fromstring("""
  S ->  S S | '(' S ')' | '(' ')'
 """)

def grammarValidation(word, grammar):
    try:
        
        parser = nltk.parse.EarleyChartParser(grammar)
        chart = parser.chart_parse(word)
        parses = list(chart.parses(grammar.start()))
        
        
        return len(parses) > 0
        
    except ValueError:
        
        
        return False

word = input("Enter the word: ")

if grammarValidation(word, G1):
        print(f"{word} is valid.")
else:
        print(f"{word} is not valid.")