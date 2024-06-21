n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
dp = [[0 for _ in range(n)] for _ in range(n)]

dp[0][0] = arr[0][0]

# 가로
for i in range(1, n):
    dp[0][i] = max(dp[0][i-1], arr[0][i])
# 세로
for i in range(1, n):
    dp[i][0] = max(dp[i-1][0], arr[i][0])

for i in range(1, n):
    for j in range(1, n):
        # 위쪽칸과 왼쪽칸까지의 최대값 중에 최솟값을 가져옴
        x = min(dp[i-1][j], dp[i][j-1])
        # 그 값이랑 현재칸 중에 최대값을 찾음
        dp[i][j] = max(x, arr[i][j])
        # 결과 : 현재칸 까지의 최대값의 최솟값

print(dp[n-1][n-1])