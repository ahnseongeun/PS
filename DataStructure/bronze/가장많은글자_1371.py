import sys

count = [0] * 26
words = sys.stdin.read()
for word in words:
    if word.islower():
        count[ord(word) - ord('a')] += 1

maxValue = max(count)
result = ""
for i in range(len(count)):
    if count[i] == maxValue:
        result += chr(ord('a') + i)
print(result)






