phoneNumber = input()

numbers = ["3", "3", "3"
    , "4", "4", "4"
    , "5", "5", "5"
    , "6", "6", "6"
    , "7", "7", "7"
    , "8", "8", "8", "8"
    , "9", "9", "9"
    , "10", "10", "10", "10"]
time = 0
for word in phoneNumber:
    time += int(numbers[int((ord(word) - 65))])
print(time)
