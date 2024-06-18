n = int(input())
dp = [1, 2, 7, 22]

cnt = 0
for i in range(4, n+1):
    dp.append((3 * dp[i-2] + 2 * dp[i-1] - cnt + dp[i-2] - dp[i-4]) % 1000000007)
print(dp[n])