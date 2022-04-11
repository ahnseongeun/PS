result = []
for i in range(5):
    if input().find("FBI") != -1:
        result.append(int(i + 1))
if result: #값이 존재하면
    print(*result)
else:
    print("HE GOT AWAY!")


