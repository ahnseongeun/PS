s = list(input())

for i in range(len(s)):
    index = ord(s[i]) - 3
    if index < 65:
        index += 26
    s[i] = chr(index)
print("".join(s))
