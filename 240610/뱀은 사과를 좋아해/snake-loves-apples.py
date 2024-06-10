n, m, k = map(int, input().split())
apple = []
snake = []
for _ in range(m):
    line = list(map(int, input().split()))
    apple.append((line[0]-1, line[1]-1))
for _ in range(k):
    line = list(input().split())
    snake.append((line[0], int(line[1])))

arr = [[0 for _ in range(n)] for _ in range(n)]
temp = [[0 for _ in range(n)] for _ in range(n)]

visited = [(0, 0)]

for ax, ay in apple:
    arr[ax][ay] = 1

time = 0
dir = {"R": (0, 1), "L": (0, -1), "U": (-1, 0), "D": (1, 0)}
for d, c in snake:
    for _ in range(c):
        time += 1
        now_visited = []
        temp = [[0 for _ in range(n)] for _ in range(n)]
        x, y = visited.pop(0)
        now_x, now_y = x, y
        
        dx, dy = x + dir[d][0], y + dir[d][1]
 
        if (0 <= dx < n and 0 <= dy < n):
            

            now_visited.append((dx, dy))
            temp[dx][dy] = 1

            while visited:
                vx, vy = visited.pop(0)
                if (temp[now_x][now_y]):
                    print(time)
                    exit(0)
                    
                now_visited.append((now_x, now_y))
                temp[now_x][now_y] = 1
                now_x, now_y = vx, vy

            if (arr[dx][dy] == 1):
                arr[dx][dy] = 0
                temp[now_x][now_y] = 1
                now_visited.append((now_x, now_y))
        else:
            print(time)
            exit(0)
            break

        visited = now_visited
    
print(time)