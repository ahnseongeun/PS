king, stone, n = input().split()
king_x = ord(king[0]) - 65
king_y = int(king[1]) - 1
stone_x = ord(stone[0]) - 65
stone_y = int(stone[1]) - 1

for _ in range(int(n)):
    command = input()
    if command == 'R':
        if king_x + 1 == stone_x and king_y == stone_y:
            if stone_x + 1 == 8:
                continue
            stone_x += 1
            king_x += 1
        else:
            if king_x + 1 == 8:
                continue
            king_x += 1
    elif command == 'L':
        if king_x - 1 == stone_x and king_y == stone_y:
            if stone_x - 1 == -1:
                continue
            stone_x -= 1
            king_x  -= 1
        else:
            if king_x - 1 == -1:
                continue
            king_x -= 1
    elif command == 'B': #아래
        if king_y - 1 == stone_y and king_x == stone_x:
            if stone_y - 1 == -1:
                continue
            stone_y -= 1
            king_y  -= 1
        else:
            if king_y - 1 == -1:
                continue
            king_y -= 1
    elif command == 'T': #위로
        if king_y + 1 == stone_y and king_x == stone_x:
            if stone_y + 1 == 8:
                continue
            stone_y += 1
            king_y += 1
        else:
            if king_y + 1 == 8:
                continue
            king_y += 1
    elif command == 'RT':
        if king_y + 1 == stone_y and king_x + 1 == stone_x:
            if stone_x + 1 == 8 or stone_y + 1 == 8:
                continue
            stone_x += 1
            stone_y += 1
            king_x += 1
            king_y += 1
        else:
            if king_y + 1 == 8 or king_x + 1 == 8:
                continue
            king_y += 1
            king_x += 1
    elif command == 'LT':
        if king_y + 1 == stone_y and king_x - 1 == stone_x:
            if stone_y + 1 == 8 or stone_x - 1 == -1:
                continue
            stone_x -= 1
            stone_y += 1
            king_x -= 1
            king_y += 1
        else:
            if king_y + 1 == 8 or king_x - 1 == -1:
                continue
            king_y += 1
            king_x -= 1
    elif command == 'RB':
        if king_y - 1 == stone_y and king_x + 1 == stone_x:
            if stone_y - 1 == -1 or stone_x + 1 == 8:
                continue
            stone_x += 1
            stone_y -= 1
            king_x += 1
            king_y -= 1
        else:
            if king_y - 1 == -1 or king_x + 1 == 8:
                continue
            king_y -= 1
            king_x += 1
    else:
        if king_y - 1 == stone_y and king_x - 1 == stone_x:
            if stone_y - 1 == -1 or stone_x - 1 == -1:
                continue
            stone_x -= 1
            stone_y -= 1
            king_x -= 1
            king_y -= 1
        else:
            if king_y - 1 == -1 or king_x - 1 == -1:
                continue
            king_y -= 1
            king_x -= 1
print(chr(king_x + 65) + (str(king_y + 1)))
print(chr(stone_x + 65) + (str(stone_y + 1)))