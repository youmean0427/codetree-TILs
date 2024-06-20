n = int(input())
arr = list(map(int, input().split()))

dp = [1] * n


for i in range(1, n):
    
    max_v = 1
    for j in range(i):
        if arr[j] > arr[i]:
            max_v = max(max_v, dp[j])
    dp[i] += max_v 
print(max(dp))