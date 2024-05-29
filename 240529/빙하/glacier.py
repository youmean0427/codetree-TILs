from collections import deque
n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]



def bfs():
    q = deque([])
    visited = [[0 for _ in range(m)] for _ in range(n)]
    q.append([0, 0])
    dir = [(0, 1), (1, 0), (0, -1), (-1, 0)]
    
    ice = []

    while(q):
        x, y = q.popleft()

    
        for dx, dy in dir:
            dxx = x + dx
            dyy = y + dy

            if 0 <= dxx < n and 0 <= dyy < m:
                if (arr[dxx][dyy] == 0 and visited[dxx][dyy] == 0):
                    visited[dxx][dyy] = 1
                    q.append([dxx, dyy])
                elif (arr[dxx][dyy] == 1 and visited[dxx][dyy] == 0):
                    visited[dxx][dyy] = 1
                    ice.append((dxx, dyy))

    return ice

t = 0
last = 0
while True:

    ice = bfs()
    if ice:
        last = len(ice)
        for x, y in ice:
            arr[x][y] = 0
    else:
        break
                  
    t += 1

print(t, last)