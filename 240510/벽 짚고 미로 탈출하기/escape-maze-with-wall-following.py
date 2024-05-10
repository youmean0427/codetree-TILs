n = int(input())
x, y = map(int, input().split())
arr = [list(input()) for _ in range(n)]
visited = [[[0 for _ in range(5)] for _ in range(n)] for _ in range(n)]

d = 1
T = 0
x, y = x - 1, y- 1

change_dir = {1: 2, 2: 3, 3: 4, 4: 1}
change_dir_re = {1: 4, 2: 1, 3: 2, 4: 3}
dir = {1: (0, 1), 2: (-1, 0), 3: (0, -1), 4: (1, 0)}
right_dir = {1: (1, 0), 2: (0, 1), 3: (-1, 0), 4: (0, -1)}
    
def in_range(x, y):
    return 0 <= x < n and 0 <= y < n

def is_wall(x, y):
    return in_range(x, y) and arr[x][y] == "#"
        
def move():
    global x, y, d, T
    if visited[x][y][d] == 1:
        print(-1)
        exit(0)

    visited[x][y][d] = 1
    next_x, next_y = x + dir[d][0], y + dir[d][1]

    if is_wall(next_x, next_y):
        d = change_dir[d]

    elif not in_range(next_x, next_y):
        x, y = next_x, next_y
        T += 1

    else:
        rx = next_x + right_dir[d][0]
        ry = next_y + right_dir[d][1]

        if is_wall(rx, ry):
            x, y = next_x, next_y
            T += 1
        
        else:
            d = change_dir_re[d]
            x, y = rx, ry
            T += 2

while in_range(x, y):
    move()

print(T)