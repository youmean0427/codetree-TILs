n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
visited = [[0 for _ in range(m)] for _ in range(n)]
dir = [(0, 1), (1, 0), (0, -1), (-1, 0)]
def bfs(sn, sm):

    q = [(sn, sm)]
    while q:
        x, y = q.pop(0)
        for dn, dm in dir:
            xn, ym  = x + dn, y + dm 
            if 0 <= xn < n and 0 <= ym < m:
                if arr[xn][ym] == 1 and visited[xn][ym] == 0:
                    visited[xn][ym] = 1
                    q.append((xn, ym))

bfs(0, 0)
if visited[n-1][m-1]:
    print(1)
else:
    print(0)