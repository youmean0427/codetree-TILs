n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

dp = [[float('inf') for _ in range(n)] for _ in range(n)]

dp[0][n-1] = arr[0][n-1]

for i in range(n):
    for j in range(n-1, -1, -1):
        left, down = float('inf'), float('inf')
        if 0 <= j+1 < n:
            left = arr[i][j] + dp[i][j+1]
        if 0 <= i-1 < n:
            down = arr[i][j] + dp[i-1][j]
        dp[i][j] = min(dp[i][j], left, down)
        
print(dp[n-1][0])