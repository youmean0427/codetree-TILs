n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

dp = [[float('inf') for _ in range(n)] for _ in range(n)]
dp[0][0] = arr[0][0]

for i in range(n):
    for j in range(n):
        res = []
        for dn, dm in [(0, -1), (-1, 0)]:
            dni, dmj = dn + i, dm + j
            if 0 <= dni < n and 0 <= dmj < n:
                x = min(dp[i][j], dp[dni][dmj], arr[i][j])
                res.append(x)
        if res:
            dp[i][j] = max(res)

print(dp[n-1][n-1])