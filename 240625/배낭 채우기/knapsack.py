n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
dp = [[float('-inf') for _ in range(m+1)] for _ in range(n)]

dp[0][arr[0][0]] = arr[0][1] 
dp[0][0] = 0
for i in range(1, n):
    
    for j in range(m+1):
        if j < arr[i][0]:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(dp[i][j], dp[i-1][j-arr[i][0]] + arr[i][1])

ans = 0
for i in range(n):
    ans = max(ans, dp[i][m])
print(ans)