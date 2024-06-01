n = int(input())
arr = list(map(int, input().split()))
dp = [1] * n
dp[0] = 1
for i in range(1, n):
    if arr[i] > arr[i-1]:
        dp[i] = dp[i-1] + 1
    else:
        for j in range(0, i):
            if arr[j] < arr[i]:
                dp[i] = dp[j] + 1
                
print(max(dp))