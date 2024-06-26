N, M = map(int, input().split())
arr= [list(map(int, input().split())) for _ in range(N)]

dp = [float("-inf")] * (M+1)
dp[0]= 0
# 무게의 합
for i in range(M+1):
    # 보석
    for j in range(N):
        if i >= arr[j][0]:
            dp[i] = max(dp[i], dp[i-arr[j][0]] + arr[j][1])

print(max(dp))