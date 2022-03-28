s = input()
result = 0

def check(s):
    length = int(len(s))
    for i in range(length):
        if s[i] == s[length - i - 1]:
            continue
        return False
    return True

for i in range(int(len(s))):
    if check(s[i:]):
        result = 2 * len(s) - len(s[i:])
        break
print(result)