N, M = map(int, input().split())
arr= [list(map(int, input().split())) for _ in range(N)]


dp = [[float('-inf') for _ in range(M+1)] for _ in range(N)]
dp[0][0] = 0
# 보물
for i in range(N):
    w, c = arr[i]
    # 무게의 합
    for j in range(M+1):
        if j >= w:
            if j % w == 0:
                dp[i][j] = max(dp[i][j], c * (j // w), dp[i][j - w] + c, dp[i-1][j])
            else:
                dp[i][j] = max(dp[i][j], dp[i-1][j], dp[i][j-w] + c)
        else:
            dp[i][j] = dp[i-1][j]

ans = 0
for i in dp:
    ans = max(ans, max(i))
print(ans)