n = int(input())
commands = input()

maze = [[0] * 101 for _ in range(101)]
dx = [0,  1, 0, -1] #상우하좌
dy = [-1, 0, 1, 0]
x, min_x, max_x, y, min_y, max_y = 50, 50, 50, 50, 50, 50
direction = 2
maze[50][50] = 1

for command in commands:
    if command == 'R':
        direction = (direction + 1) % 4
    elif command == 'L':
        direction = (direction - 1) % 4
    else:
        x += dx[direction]
        y += dy[direction]
        maze[y][x] = 1
        min_x = min(x, min_x)
        min_y = min(y, min_y)
        max_x = max(x, max_x)
        max_y = max(y, max_y)


for i in range(min_y, max_y + 1):
    for j in range(min_x, max_x + 1):
        if maze[i][j] == 0:
            maze[i][j] = '#'
        else:
            maze[i][j] = '.'
        print(maze[i][j],end="")
    print()

