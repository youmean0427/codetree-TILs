n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

# 밟을 수 있는 최대 칸의 수
dp = [[0 for _ in range(m)] for _ in range(n)]
# 초기값
dp[0][0] = 1

for i in range(1, n):
    for j in range(1, m):

        for x in range(0, i):
            for y in range(0, j):

                # 시작점이 변경될 수 있음
                # dp[x][y] > 0 조건으로 (0, 0)에서 출발했음을 판단
                if arr[i][j] > arr[x][y] and dp[x][y] > 0:
                    dp[i][j] = max(dp[i][j], dp[x][y] + 1 )
ans = 0
for i in dp:
    ans = max(ans, max(i))
print(ans)

# TEST CASE 6

# 4 4
# 9 1 1 1
# 1 2 1 4
# 1 1 3 1
# 1 1 1 5