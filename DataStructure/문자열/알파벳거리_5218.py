n = int(input())

for i in range(n):
    str1, str2 = map(str, input().split())
    length = len(str1)
    result = "Distances:"
    for j in range(length):
        diff = ord(str2[j]) - ord(str1[j])
        if diff < 0:
            diff = ord(str2[j]) + 26 - ord(str1[j])
        result += " " + str(diff)
    print(result)
