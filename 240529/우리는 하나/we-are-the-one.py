from itertools import combinations

n, k, u, d = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
dir = [(1, 0), (-1, 0), (0, 1), (0, -1)]
pos = []

for i in range(n):
    for j in range(n):
        pos.append([i, j])

select = list(combinations(pos, k))

def bfs(pos):
    q = []
    for i in pos:
        q.append(i)
    
    cnt = 0
    while q:
        x, y= q.pop(0)

        for dx, dy in dir:
            dxx = dx + x
            dyy = dy + y

            if 0 <= dxx < n and 0 <= dyy < n:
                if (u <= abs(arr[x][y] - arr[dxx][dyy]) <= d):
                    if visited[dxx][dyy] == 0:
                        visited[dxx][dyy] = 1
                        q.append([dxx, dyy])

ans = 0
for x in select:
    visited = [[0 for _ in range(n)] for _ in range(n)]
    bfs(x)
    total = 0
    for i in visited:
        total += sum(i)
    ans = max(ans, total)
print(ans)