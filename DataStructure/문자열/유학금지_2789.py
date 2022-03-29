
words = sorted(list("CAMBRIDGE"))
s = input()
result = ""

for i in range(len(s)):
    if s[i] not in words:
        result += s[i]
print(result)
