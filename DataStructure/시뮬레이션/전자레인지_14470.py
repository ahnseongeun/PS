A = int(input())
B = int(input())
C = int(input())
D = int(input())
E = int(input())

result = 0
if A < 0:
    result = C * abs(A) + D + E * B
elif A == 0:
    result = D + B * E
else:
    result = (B - A) * E
print(result)



