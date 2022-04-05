n = input()

check = set()
result = "HAPPY"
while n not in check:
    if n == 1:
        break
    check.add(n)
    n = sum(int(i) ** 2 for i in str(n))
if n != 1:
    result = "UN" + result
print(result)
