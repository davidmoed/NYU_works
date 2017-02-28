'''David Moed
November 10, 2015
Tuesday/Thursday 2pm
Name Value Program'''

#have the user input their name
orig_name = input ("Name: ")

#convert the name to lowercase
orig_name = orig_name.lower()

#remove any spaces from the name
name = orig_name.replace(" ","")

#remove any special characters or numbers from the name
for i in name:
    if not i.isalpha():
        name = name.replace(i,"")

#show the user their cleaned up name
print ("Your cleaned up name is", name)

total_val = 0
for i in name:
    i = ord (i)
    total_val += i

print ("Reduction: ", total_val)
