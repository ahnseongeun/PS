n = int(input())

group = set()
result = ""
for _ in range(n):
    s = input()
    reversed_s = s[::-1]
    if s in group:
        result = s
        break
    group.add(s)
    if reversed_s in group:
        result = reversed_s
        break
    group.add(reversed_s)
length = len(result)
print(length, result[int(length / 2)])

