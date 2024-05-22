n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
visited = [[0 for _ in range(m)] for _ in range(n)]

def bfs():
    q = [(0, 0)]
    dir = [(0, 1), (1, 0), (-1, 0), (0, -1)]
    visited[0][0] = 1
    while q:
        x, y = q.pop(0)
     
        for dn, dm in dir:
            xdn, ydm = x + dn, y + dm
            if 0 <= xdn < n and 0 <= ydm < m:
                if visited[xdn][ydm] == 0 and arr[xdn][ydm] == 1:
                    visited[xdn][ydm] += visited[x][y] + 1
                    q.append((xdn, ydm))


bfs()
if visited[n-1][m-1]:
    print(visited[n-1][m-1]-1)
else:
    print(-1)