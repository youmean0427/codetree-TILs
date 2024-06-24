N, M = map(int, input().split())
coin = list(map(int, input().split()))

dp = [float('inf')] * (M+1)
dp[0] = 0
for i in range(M+1):
    for j in range(N):
        if i >= coin[j]:
            dp[i] = min(dp[i], dp[i-coin[j]] + 1)
    
if dp[M] == float('inf'):
    print(-1)
else:
    print(dp[M])