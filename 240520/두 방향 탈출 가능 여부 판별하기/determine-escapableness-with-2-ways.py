n, m  = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

dir = [(1, 0), (0, 1)]
visited = [[0 for _ in range(n)] for _ in range(m)]

def dfs(nn, mm):

    for dn, dm in dir:
        dnn, dmm = nn + dn, mm + dm
        if 0 <= dnn < n and 0 <= dmm < m:
            if arr[dnn][dmm] == 1 and visited[dnn][dmm] == 0:
                visited[dnn][dmm] = visited[nn][mm] + 1
                dfs(dnn, dmm)

dfs(0, 0)
if visited[n-1][m-1]:
    print(1)
else:
    print(0)