n = int(input())

dp = [1, 1, 3, 5]

for i in range(4, n+1):
    dp.append((dp[i-1] + 2 * dp[i-2] ) % 10007)

print(dp[n])