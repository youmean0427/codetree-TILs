n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

dp = [[1 for _ in range(n)] for _ in range(n)]


dir = [(0, 1), (1, 0), (-1, 0), (0, -1)]

cells = []
for i in range(n):
    for j in range(n):
        cells.append((arr[i][j], i, j))

cells.sort()

for a, i, j in cells: 
        step = 1
        for dn, dm in dir:
            dnx, dmy = dn + i, dm + j
            
            if 0 <= dnx < n and 0 <= dmy < n:
                if arr[i][j] > arr[dnx][dmy]:
                    step = max(step, dp[dnx][dmy] + 1)
            
        dp[i][j] = step

ans = 0
for i in dp:
    ans = max(ans, max(i))
print(ans)