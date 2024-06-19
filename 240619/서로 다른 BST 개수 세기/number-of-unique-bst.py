n = int(input())
dp = [1, 1, 2, 5]

for m in range(4, n+1):
    x = 0
    for i in range(m):
        x += dp[i] * dp[m-1-i]
    dp.append(x)
print(dp[n])