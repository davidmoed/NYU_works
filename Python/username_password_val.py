#username validation
while True:
    #have user input a username
    username = input ("Please enter a username: ")

    #check that username is proper length
    if (len(username) >= 8) and (len(username) <= 15):

        #check that username does not have characters
        if username.isalnum():

            #check that the first character of the username is not a digit
            if not username[0].isnumeric():

                #check that the username contains at least 1 uppercase and lowercase letter, and 1 number
                upper = 0
                lower = 0
                numeric = 0
                for i in username:
                    if i.isupper():
                        upper += 1
                    elif i.islower():
                        lower += 1
                    elif i.isnumeric():
                        numeric += 1
                if upper == 0:
                    print ("Your username must contain at least one uppercase character.")
                    continue
                elif lower == 0:
                    print ("Your username must contain at least one lowercase character.")
                    continue
                elif numeric == 0:
                    print ("Your username must contain at least one digit.")
                    continue
                else:
                    print ("Your username is valid!")
                    break
                
            #if there is a digit as the first character go back to the input
            else:
                print ("The first character in your username cannot be a digit")
                continue
        
        #if there is a non-letter or non-number character go back to the input
        else:
            print ("Username must contain only alphanumeric characters.")
            continue

    #if the username is too long or too short go back to the input
    else:
        print ("Username must be between 8 and 15 characters.")
        continue

#password validation
while True:
    #have user input a password
    password = input ("Please enter a password: ")

    #check that password is a proper length
    if (len(password) >= 8):

        #check that the username is not in the password
        if password.find(username) < 0:

            #Check that the password has 1 lowercase and uppercase letter, 1 number, and 1 of four valid characters
            upper = 0
            lower = 0
            numeric = 0
            char = 0
            valid_char = 0
            for i in password:
                if i.isupper():
                    upper += 1
                elif i.islower():
                    lower += 1
                elif i.isnumeric():
                    numeric += 1
                elif not i.isalnum():
                    char += 1
                for s in password:
                    if ("#" in password) or ("%" in password) or ("$" in password) or ("&" in password):
                        valid_char += 1
            if upper == 0:
                print ("Your password must contain at least one uppercase character.")
                continue
            elif lower == 0:
                print ("Your password must contain at least one lowercase character.")
                continue
            elif numeric == 0:
                print ("Your password must contain at least one digit.")
                continue
            elif char == 0:
                print ("Your password must contain at least one 'special' character.")
                continue
            elif valid_char == 0:
                print ("Your password contains at least one invalid character.")
                continue
            else:
                print ("Your password is valid!")
                break 

        #if the username is in the password go back to the input
        else:
            print ("You cannot use your username as part of your password.")
            continue

    #if the password is too short go back to the input
    else:
        print ("Passwords must be at least 8 characters long.")
        continue
