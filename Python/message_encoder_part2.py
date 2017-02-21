'''David Moed
November 10, 2015
Tuesday/Thursday 2pm
Final Secret Message Encoder/Decoder Program'''

import message_encoder_part1

#set a loop to ask the user to input e or d until they input q
while True:

    #ask the user to choose what they would like to do
    command = input ("(e)ncode, (d)ecode or (q)uit: ")

    #if the user wants to encode a word
    if command == "e":

        #ask the user what word they want to input
        word = input ("Enter a phrase to encode: ")

        #ask the user for a number between 1 and 5 to choose the level of encoding
        num = int (input ("Enter a number between 1 and 5: "))

        #validate the user input
        while num < 1 or num > 5:
            
            print ("Sorry, your number must be between 1 and 5.")
            num = int (input ("Enter a number between 1 and 5: "))

        #call the function that will add letters to the user's word and save it as added
        added = Moed_David_Assign7_Part3a.add_letters(word, num)
        #call the funtion that will shift the letters of "added," the word with the extra characters
        shifted = Moed_David_Assign7_Part3a.shift_characters(added, num)

        #print the final encoded word
        print ("Your encoded word is ", shifted)

    #if the user wants to decode a word
    elif command == "d":

        #ask the user what word they want to input
        word = input ("Enter a phrase to decode: ")

        #ask the user for a number between 1 and 5 to choose the level of decoding
        num = int (input ("Enter a number between 1 and 5: "))

        #validate the user input
        while num < 1 or num > 5:
            
            print ("Sorry, your number must be between 1 and 5.")
            num = int (input ("Enter a number between 1 and 5: "))

        #call the function that will remove all letters that are not in the original user input
        removed = Moed_David_Assign7_Part3a.remove_letters(word, num)
        
        #call the function that will shift the letters back to their original postition
        reshifted = Moed_David_Assign7_Part3a.shift_characters(removed, -num)

        #print the final decoded word
        print ("Your decoded word is ", reshifted)

    #break the loop if the user enters q
    else:
        break
