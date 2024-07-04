n = int(input())

dp = [0] * (n+1)

dp[1] = 9

for i in range(2, n+1):
    dp[i] =((dp[i-1] * 2) - (i-1)) % (10 ** 9 + 7)

print(dp[n])