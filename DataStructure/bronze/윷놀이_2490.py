for i in range(3):
    arr = list(map(int, input().split()))
    total = sum(arr)
    if total == 0:
        print('D')
    elif total == 1:
        print('C')
    elif total == 2:
        print('B')
    elif total == 3:
        print('A')
    else:
        print('E')
