import nltk


G1 = nltk.CFG.fromstring("""
  S -> A B | C
  A -> 'a' A 'b' | 'a' 'b'
  B -> 'c' B 'd' | 'c' 'd'
  C -> 'a' C 'd' | 'a' D 'd'
  D -> 'b' D 'c' | 'b' 'c'
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