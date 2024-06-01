from collections import deque

n, k = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

r1, c1 = map(int, input().split())
r2, c2 = map(int, input().split())

visited = [[float('inf') for _ in range(n)] for _ in range(n)]
dir = [(0, 1), (1, 0), (-1, 0), (0, -1)]

def bfs(sn, sm, w):

    q = deque([])
    q.append((sn, sm, w))
    visited[sn][sm] = 1

    while q:

        x, y, wall = q.popleft()

        for dn, dm in dir:
            dx = dn + x
            dy = dm + y

            if 0 <= dx < n and 0 <= dy < n:
                if arr[dx][dy] == 0 and visited[dx][dy] >= visited[x][y] + 1:
                    visited[dx][dy] = visited[x][y] + 1
                    q.append((dx, dy, wall))
                elif arr[dx][dy] == 1 and visited[dx][dy] >= visited[x][y] + 1:
                    if wall < k:
                        visited[dx][dy] = visited[x][y] + 1
                        q.append((dx, dy, wall+1))
                        


bfs(r1-1, c1-1, 0)
ans = visited[r2-1][c2-1]-1

if ans == float('inf'):
    print(-1)
else:
    print(ans)