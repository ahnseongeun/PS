a = int(input())
b = int(input())
s = a * b
while b != 0:
    print(a * (b % 10))
    b //= 10
print(s)
