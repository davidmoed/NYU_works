'''David Moed
November 10, 2015
Tuesday/Thursday 2pm
Secret Message Encoder/Decoder Program'''

import random

def add_letters(word, num):

    new_word = ""
    
    #set the loop to iterate for the length of the word
    for i in word:

        #set a variable for the final word being returned
        new_word += i

        #set a loop to iterate the number of random letters
        for s in range (1,num + 1):
            
            #set a randomizer to variate between lowercase and uppercase letters
            randomizer = random.randint(1,2)

            #set random number values for the values of upper and lowercase letters in the ASCII index
            rand_num1 = random.randint(65,90)
            rand_num2 = random.randint(97,122)

            #convert the random numbers to their character values on the ASCII
            rand_char1 = chr (rand_num1)
            rand_char2 = chr (rand_num2)

            #print out either lowercase or uppercase
            if randomizer == 1:
                new_word += rand_char1

            elif randomizer == 2:
                new_word += rand_char2
                
    return new_word

#set the function for removing letters
def remove_letters(word, num):
    #set a variable for the final word to be returned
    new_word = ""

    #set the loop for selescting only the letters that are originally in the word
    for i in word [::num+1]:

        new_word += i

    return new_word


#set the function for shifting characters
def shift_characters(word, num):
    #set a variable for the final word being returned
    new_word = ""

    #set a for loop to shift each letter in the word      
    for i in word:

        #convert each letter to its ASCII value
        new_value = ord (i)

        #adjust the value of the letter based on the number of shifts to be done
        new_value += num

        #convert each value back to an ASCII character
        new_letter = chr (new_value)

        #add each new letter to the word being returned
        new_word += new_letter
        
    return new_word
