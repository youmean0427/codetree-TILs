n, m = map(int, input().split())
arr = list(map(int, input().split()))

dp = [float('inf')] * (m+1)
dp[0] = 0

# 중복을 제거하는 것이 문제

for i in range(n):
    
    for j in range(m, -1, -1):
        if j >= arr[i]:
            if dp[j - arr[i]] == float('inf'):
                continue
            dp[j] = min(dp[j], dp[j - arr[i]]+1)

if dp[m] == float('inf'):
    print(-1)
else:
    print(dp[m])