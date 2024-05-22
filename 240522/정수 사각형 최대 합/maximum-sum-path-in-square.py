n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

dp = [[0 for _ in range(n)] for _ in range(n)]

dp[0][0] = arr[0][0]


for i in range(n):
    for j in range(n):
        down, right = 0, 0
        if 0 <= i-1 < n:
            down = dp[i-1][j] + arr[i][j]
        if 0 <= j-1 < n:
            right = dp[i][j-1] + arr[i][j]
        dp[i][j] = max(down, right, dp[i][j])

print(dp[n-1][n-1])