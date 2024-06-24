n = int(input())
arr = [1, 2, 5]

dp = [0] * (n+1)
dp[0] = 1

for i in range(n+1):
    for j in range(3):
        if i >= arr[j]:
            dp[i] += dp[i-arr[j]]
print(dp[n])