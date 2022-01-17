string = input()

result = ""
word = ""
reverseFlag = True

for ch in string:
    if ch == '<':
        reverseFlag = False
        result += ch
    elif ch == '>':
        reverseFlag = True
        result





