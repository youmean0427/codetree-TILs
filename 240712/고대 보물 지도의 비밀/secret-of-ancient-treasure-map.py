n, k = map(int, input().split())
arr = list(map(int, input().split()))


dp = [[0 for _ in range(n)] for _ in range(n)]

for i in range(n):
    dp[i][i] = arr[i]


for i in range(n):
    count = k
    for j in range(i, n):
        if arr[j] < 0 and count > 0:
            count -= 1 
            dp[i][j] = dp[i][j-1] + arr[j]
        elif arr[j] > 0:
            dp[i][j] = dp[i][j-1] + arr[j]


ans = 0
for i in dp:
    ans = max(ans, max(i))
print(ans)