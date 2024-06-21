n = int(input())
arr = list(map(int, input().split()))

dp = [0] * n
dp[0] = 1


for i in range(1, n):
    max_v = 0
    for j in range(i):
        if j + arr[j] >= i:
            max_v = max(max_v, dp[j]+1)
    dp[i] = max_v

print(dp[n-1]-1)