n = int(input())
arr = list(map(int, input().split()))
dp = [1] * n

for i in range(n):
    max_val = 0
    for j in range(i):
        if arr[j] < arr[i]:
            max_val= max(max_val, dp[j])
    dp[i] = max_val + dp[i]

print(max(dp))