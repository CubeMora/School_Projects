

character =  [
          'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 
          'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 
          'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 
          'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 
          '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
          ]

digits = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
logic_operators = ['!', '<', '>', '=']
openers = ['[', '{', '(']
closers = [']', '}', ')', ';', ':']
arithmetic_operators = ['+', '-', '*']


automata = dict(
    
initialState = '0',
finalState = ['2','3','5','8','9','13','14','15','16','18','20','21'
        ,'22','23', '24', '25', '26'],

transitions = [
    {
      'state' : '0',
      'symbol' : ['$'],
      'nextState' : '1',
      'type':'id'
    },{
      'state' : '0',
      'symbol' : digits,
      'nextState' : '3', 
       'type':'int'
    },{
      'state' : '0',
      'symbol' : ["'"],
      'nextState' : '6',
      'type':'string' 
    },{
      'state' : '0',
      'symbol' : ['/'],
      'nextState' : '9',
      'type':'Arithmetic Operator' 
    },{
      'state' : '0',
      'symbol' : logic_operators,
      'nextState' : '15',
       'type':'Logic Operator' 
    },{
      'state' : '0',
      'symbol' : ['|'],
      'nextState' : '17',
       'type':'Logic Operator'  
    },{
      'state' : '0',
      'symbol' : ['&'],
      'nextState' : '19',
       'type':'Relational Operator'  
    },{
      'state' : '0',
      'symbol' : openers,
      'nextState' : '21',
       'type':'Container Opener'  
    },{
      'state' : '0',
      'symbol' : closers,
      'nextState' : '22',
       'type':'Container Closers'  
    },{
      'state' : '0',
      'symbol' : arithmetic_operators,
      'nextState' : '23',
       'type':'Arithmetic Operator' 
    },{
      'state' : '0',
      'symbol' : ['\t'],
      'nextState' : '24',
       'type':'Identation'  
    },{
      'state' : '0',
      'symbol' : ['\n'],
      'nextState' : '25',
       'type':'Identation'  
    },{
      'state' : '0',
      'symbol' : [' '],
      'nextState' : '26',
       'type':'Identation'  
    },{
      'state' : '1',
      'symbol' : character,
      'nextState' : '2', 
       'type':'id'  
    },{
      'state' : '2',
      'symbol' : character,
      'nextState' : '2', 
       'type':'id'  
    },{
      'state' : '3',
      'symbol' : digits,
      'nextState' : '3', 
       'type':'int'  
    },{
      'state' : '3',
      'symbol' : ['.'],
      'nextState' : '4', 
       'type':'decimal'  
    },{
      'state' : '4',
      'symbol' : digits,
      'nextState' : '5', 
       'type':'decimal'  
    },{
      'state' : '5',
      'symbol' : digits,
      'nextState' : '5', 
       'type':'decimal'  
    },{
      'state' : '6',
      'symbol' : character,
      'nextState' : '7', 
       'type':'string'  
    },{
      'state' : '6',
      'symbol' : [' '],
      'nextState' : '7',
      'type':'string' 
    },{
      'state' : '7',
      'symbol' : [' '],
      'nextState' : '7',
      'type':'string' 
    },{
      'state' : '7',
      'symbol' : character,
      'nextState' : '7',
      'type':'string' 
    },
    {
      'state' : '7',
      'symbol' : ["'"],
      'nextState' : '8',
      'type':'string' 
    },#{
      #'state' : '8',
      #'symbol' : ["'"],
      #'nextState' : '8',
      #'type':'string' 
    #}
    {
      'state' : '9',
      'symbol' : ['*'],
      'nextState' : '10',
      'type':'comment' 
    },{
      'state' : '10',
      'symbol' : character,
      'nextState' : '11',
      'type':'comment'  
    },{
      'state' : '10',
      'symbol' : [' '],
      'nextState' : '11',
      'type':'comment'  
    },{
      'state' : '11',
      'symbol' : character,
      'nextState' : '11',
      'type':'comment' 
    },{
      'state' : '11',
      'symbol' : [' '],
      'nextState' : '11',
      'type':'comment'  
    },{
      'state' : '11',
      'symbol' : ['*'],
      'nextState' : '12',
      'type':'comment'  
    },{
      'state' : '12',
      'symbol' : ['/'],
      'nextState' : '13',
      'type':'comment'  
    },{
      'state' : '15',
      'symbol' : ['='],
      'nextState' : '16',
      'type':'Relational Operator'   
    },{
      'state' : '17',
      'symbol' : ['|'],
      'nextState' : '18',
      'type':'OR Operator' 
    },{
      'state' : '19',
      'symbol' : ['&'],
      'nextState' : '20',
      'type':'AND Operator' 
    },
],

tokens = {
        '2' :'id',
        '3':'int',
        '5':'decimal',
        '8':'string',
        '9':'division',
        '13':'comment',
        '14':'assignationOperator',
        '15':'relationalOperator_equal',
        '14':'reserved_word',
        '15':'relationalOperator',
        '16':'relationalOperator_equal',
        '18':'OR operator',
        '20':'AND operator',
        '21':'Delimiter opener',
        '22':'Delimiter closer',
        '23':'Arithmetic operators',
        '24':'Tab',
        '25':'Enter',
        '26':'Space',
})

def verifyTransition(sourceCode):
  source = sourceCode
  currentState = automata['initialState']
  lastState = automata['initialState']
  word = ""
  pasddransition = False
  transition = False
  lasddype = ""
  currenddype = ""

  dd = 0


  for ch in sourceCode:
    dd = 0
    for t in automata['transitions']:
      dd += 1
      if(ch in t['symbol'] and currentState == t['state']):
        transition, pasddransition = True, transition
       
        currenddype = t['type']
        currentState = t['nextState']
        word += ch
      
        break
      
      if(dd == len(automata['transitions'])):
        transition = False
        if(currentState in automata['finalState']):
          if(word in [' ','\n']):
            for l in word:
              source.remove(l)
            return source
          print(word + ' _ ' + automata['tokens'][currentState])
          with open('tokens.txt','a') as code:
            code.write(word + ' - ' + automata['tokens'][currentState] + '\n')
          code.close()
          for l in word:
            source.remove(l)
          
          return source
        #Error showing
        else:
          word += ch
          if currenddype == '':
            with open('errors.txt','a') as code:
              code.write(word + ' - syntaxis error'  + '\n')
            code.close()
            for l in word:
              source.remove(l)
          else:
            with open('errors.txt','a') as code:
              code.write(word + ' - ' + currenddype + ' error' '\n')
            code.close()
            for l in word:
              source.remove(l)
          print(word + " -> "   + currenddype + " error")
 
            
          return source


    if((not transition) and (pasddransition) and (currentState in automata['finalState'])):
      with open('tokens.txt','a') as code:
        code.write(word + ' - ' + automata['tokens'][currentState] + '\n')
      code.close()
      print(transition, pasddransition, currentState in automata['finalState'])
      print(word + ' - ' + automata['tokens'][currentState]) # + " transition done")
      for l in word:
            source.remove(l)
      currentState = automata['initialState']
      lastState = automata['initialState']
      word = ""
      pasddransition = False
      transition = False

  if(word != ""):
    with open('tokens.txt','a') as code:
      code.write(word + ' - ' + automata['tokens'][currentState] + '\n')
    code.close()
    print(word + ' - ' + automata['tokens'][currentState]) # + " transition done")
    for l in word:
            source.remove(l)      
    print('Characters ended')
    return source

    

#//////////////////////////////////////////
with open('tokens.txt','w') as tokens:
  tokens.write('tokens list\n\n\n')
tokens.close()
file = open("code.txt","r")  # path or name of file
# read the text file
contenido = file.read()
# create an array to save the characters
sc = list(contenido)
# print the list of characters
file.close()

with open('errors.txt','w') as code:
  code.write("errors list\n\n\n")
code.close()

repeat = verifyTransition(sc)
while(len(repeat) > 0):
  repeat = verifyTransition(sc)