n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

# 밟을 수 있는 최대 칸의 수
dp = [[0 for _ in range(m)] for _ in range(n)]
# 초기값
dp[0][0] = 1

# # 가로 초기값
# for i in range(1, m):
#     for j in range(i):
#         if arr[0][i] > arr[0][j]:
#             dp[0][i] = max(dp[0][i], dp[0][j]+1)

# print(dp)

# # 세로 초기값

# for i in range(1, n):
#     for j in range(i):
#         if arr[i][0] > arr[j][0]:
#             dp[i][0] = max(dp[i][0], dp[j][0] + 1)

# print(dp)

for i in range(1, n):
    for j in range(1, m):

        for x in range(0, i):
            for y in range(0, j):

                if arr[i][j] > arr[x][y] and arr[0][0] < arr[x][y]:
                    dp[i][j] = max(dp[i][j], dp[x][y] + 1 )
ans = 0
for i in dp:
    ans = max(ans, max(i))
print(ans)