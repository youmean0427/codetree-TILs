n, k = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

dp = [[0 for _ in range(n+1)] for _ in range(n+1)]
res = [[0 for _ in range(n+1)] for _ in range(n+1)]

for i in range(1, n+1):
    for j in range (1, n+1):
        dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + arr[i-1][j-1] 

for i in range(n+1):
    for j in range(n+1):
        res[i][j] = dp[i][j]

for i in range(k, n+1):
    for j in range(k, n+1):
        res[i][j] = res[i][j] - dp[i-k][j] - dp[i][j-k] + dp[i-k][j-k]

ans = 0
for i in res:
    ans = max(ans, max(i))
print(ans)