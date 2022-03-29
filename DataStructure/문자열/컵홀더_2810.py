n = int(input())

count = input().count("LL")
if count <= 1:
    count = 0
else:
    count -= 1
print(n - count)