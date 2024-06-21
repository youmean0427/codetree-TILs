# 최솟값을 1부터 100까지 가정

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
dp = [[0 for _ in range(n)] for _ in range(n)]


def solve(lower):
    # lower보다 작은 값은 무한으로 변경    
    for i in range(n):
        for j in range(n):
            if arr[i][j] < lower:
                arr[i][j] = float('inf')
    
    for i in range(n):
        for j in range(n):
            dp[i][j] = float('inf')

    dp[0][0] = arr[0][0]
    
    for i in range(1, n):
        dp[i][0] = max(dp[i-1][0], arr[i][0])

    for i in range(1, n):
        dp[0][i] = max(dp[0][i-1], arr[0][i])

    for i in range(1, n):
        for j in range(1, n):
            dp[i][j] = max(min(dp[i-1][j], dp[i][j-1]), arr[i][j])
    
    return dp[n-1][n-1]

ans = float('inf')
for low in range(1, 101):
    # 최대값 중 최소
    x = solve(low)

    if x == float('inf'):
        continue

    # |최댓값 - 최솟값|의 최솟값
    ans = min(ans, x - low )

print(ans)