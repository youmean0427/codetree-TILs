N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

k_arr = [1]
m_count = 3
while True:
    if m_count > N:
        break
    k_arr.append(m_count)
    m_count += 2

bfs_count = [0, 1]
bc = 4

while True:
    if len(bfs_count) == len(k_arr):
        break
    bfs_count.append(bfs_count[-1] + bc)
    bc += 4

def bfs(n, m, bfs_c):

    q = [(n, m)]
    cnt = 0
    gold = 0
    gold_cnt = 0
    dir = [(1, 0), (0, 1), (-1, 0), (0, -1)]
    visited = [[0 for _ in range(N)] for _ in range(N)]
    visited[n][m] = 1

    if arr[n][m] == 1:
        gold += M
        gold_cnt += 1
    
    while q:
        if bfs_c == cnt:
            return (gold, gold_cnt)
     
        x, y = q.pop(0)
    
        for dn, dm in dir:
            xdn, ydm = x + dn, y + dm

            if 0 <= xdn < N and 0 <= ydm < N:
                if visited[xdn][ydm] == 0:
                    visited[xdn][ydm] = 1
                    if arr[xdn][ydm] == 1:
                        gold += M
                        gold_cnt += 1
                    q.append((xdn, ydm))
        cnt += 1
    
ans = 0
for x in range(N):
    for y in range(N):
        for i in range(len(bfs_count)):

            g = bfs(x, y, bfs_count[i])
            cost = i * i + (i + 1) * (i +1)
            if g[0] > cost:
                ans = max(ans, g[1])

print(ans)