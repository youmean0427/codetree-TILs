n, k = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

bad = []

for i in range(n):
    for j in range(n):
        if arr[i][j] == 2:
            bad.append((i, j))


visited = [[0 for _ in range(n)] for _ in range(n)]
def bfs():
    
    q = []
    for i in bad:
        visited[i[0]][i[1]] = 1
        q.append((i[0], i[1]))

    dir = [(0, 1), (1, 0), (0, -1), (-1, 0)]

    while (q):
        x, y = q.pop(0)
        

        for dn, dm in dir:
            dx, dy = dn + x, dm + y

            if 0 <= dx < n and  0 <= dy < n:
                if arr[dx][dy] == 1 and visited[dx][dy] == 0:
                    visited[dx][dy] =  visited[x][y] + 1
                    q.append((dx, dy))

bfs()
for i in range(n):
    for j in range(n):
        visited[i][j] -= 1
        if arr[i][j] and visited[i][j] == -1:
            visited[i][j] = -2

for v in visited:
    print(*v)