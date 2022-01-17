string = input()

result = []
stack = []
reverseFlag = True

for ch in string:

    #정방향
    if ch == '<':
        reverseFlag = False
        stack.append(ch)
    #스택에 있는거 result에 넣어주기
    elif ch == '>':
        reverseFlag = True
        stack.append(ch)
        result += stack
        stack = []
    #<word>test test 방지 -> ' 'result에 넣어주기
    elif ch == ' ':
        stack.append(ch)
        result += stack
        stack = []
    else:
        if reverseFlag:
            stack.insert(0, ch)
        elif not reverseFlag:
            stack.append(ch)

result += stack
print(''.join(result))










