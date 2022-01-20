n = int(input())

#문자열 특정 값 삭제하는 방법 list변경 후 삭제 후 join
for i in range(n):
    num, sentence = input().split(" ")
    listValue = list(sentence)
    listValue.pop(int(num) - 1)
    print(''.join(listValue))


