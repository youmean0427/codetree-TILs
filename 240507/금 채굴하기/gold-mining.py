n, m  = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

bfs_count = [0, 1]
start = 4
while len(bfs_count) != 10:
    bfs_count.append(bfs_count[-1] + start)
    start += 4

def bfs(sn, sm, c):
    dir = [(0, 1), (1, 0), (0, -1), (-1, 0)]
    visited = [[0 for _ in range(n)] for _ in range(n)]
    visited[sn][sm] = 1
    visited_dict = {}
   
    gold = 0
    gold_count = 0
    if arr[sn][sm] == 1:
        gold = 1
        gold_count = 1

    cnt = 0
    q = [(sn, sm)]

    while q:
        if c == cnt:
            return (gold, gold_count)
        
        x, y = q.pop(0)

        for dn, dm in dir:
            dnx , dmy = dn + x, dm + y

            if 0 <= dnx < n and 0 <= dmy < n:
                if visited[dnx][dmy] == 0:
                    if arr[dnx][dmy] == 1:
                        gold_count += 1
                        gold += m
                    visited[dnx][dmy] = 1
                    q.append((dnx, dmy))
            else:
                if (dnx, dmy) not in visited_dict:
                    visited_dict[(dnx, dmy)] = 1
                    q.append((dnx, dmy))
        cnt += 1

ans = 0
for x in range(n):
    for y in range(n):
        for i in range(len(bfs_count)):
            g = bfs(x, y, bfs_count[i])
            cost = i * i + (i + 1) * (i + 1)
            if g[0] >= cost:
                ans = max(ans, g[1])
print(ans)