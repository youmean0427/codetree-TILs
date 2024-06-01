from collections import deque
from itertools import combinations

n, k = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

r1, c1 = map(int, input().split())
r2, c2 = map(int, input().split())

visited = [[float('inf') for _ in range(n)] for _ in range(n)]
dir = [(0, 1), (1, 0), (-1, 0), (0, -1)]


walls = []
for i in range(n):
    for j in range(n):
        if arr[i][j] == 1:
            walls.append((i, j))

walls_case = list(combinations(walls, k))

def bfs(sn, sm, arr):
    visited = [[float('inf') for _ in range(n)] for _ in range(n)]
    q = deque([])
    q.append((sn, sm))
    visited[sn][sm] = 1

    while q:

        x, y = q.popleft()

        for dn, dm in dir:
            dx = dn + x
            dy = dm + y

            if 0 <= dx < n and 0 <= dy < n:
                if arr[dx][dy] == 0 and visited[dx][dy] >= visited[x][y] + 1:
                    visited[dx][dy] = visited[x][y] + 1
                    q.append((dx, dy))                     
    return visited

ans = float('inf')
for w in walls_case:
    wall_arr = [[0 for _ in range(n)] for _ in range(n)]
    for i in range(n):
        for j in range(n):
            wall_arr[i][j] = arr[i][j]
    for k in w:
        wall_arr[k[0]][k[1]] = 0

    res = bfs(r1-1, c1-1, wall_arr)
    ans = min(ans, res[r2-1][c2-1] - 1)

if ans == float('inf'):
    print(-1)
else:
    print(ans)