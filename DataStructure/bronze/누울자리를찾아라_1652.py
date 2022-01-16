n = int(input())
arr = [list(map(str, input())) for i in range(n)]

rowCount = 0
colCount = 0

#가로검사
for i in range(n):
    tempList = arr[i]
    cnt = 0
    for idx in range(len(tempList)):
        value = tempList[idx]
        if value == ".":
            cnt += 1
        else:
            if cnt >= 2:
                rowCount += 1
            cnt = 0
    if cnt >= 2:
        rowCount += 1

#세로검사
for i in range(n):
    #2차원 배열에서 열을 가져오는 방법
    # arr을 for문 돌면서 한줄을 가져오기 위에서 정한 idx로 원소 한개 가져오기
    tempList = [j[i] for j in arr]
    cnt = 0
    for idx in range(len(tempList)):
        value = tempList[idx]
        if value == ".":
            cnt += 1
        else:
            if cnt >= 2:
                colCount += 1
            cnt = 0
    if cnt >= 2:
        colCount += 1

print(rowCount, colCount)


