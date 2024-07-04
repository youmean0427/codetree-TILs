n = int(input())
arr = list(map(int, input().split()))
m = sum(arr)
dp = [[0 for _ in range(sum(arr)+1)] for _ in range(n)]

dp[0][arr[0]] = 1

for i in range(1, n):
    for j in range(m-1, -1, -1):
        if arr[i] > j:
            dp[i][j] = dp[i-1][j]
        if arr[i] == j:
            dp[i][j] = 1
        if dp[i-1][j-arr[i]]:
            dp[i][j] = dp[i-1][j-arr[i]] + 1
         

ans = 0
for i in range(m):
    if i >= arr[n-1]:
        if dp[n-1][i] and dp[n-2][i]:
            if dp[n-1][i] + dp[n-2][i] <= n:
                ans = max(ans, i)

print(ans)