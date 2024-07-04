n, m = map(int, input().split())

arr = [[0 for _ in range(n)] for _ in range(m+1)]
dp = [[0 for _ in range(n)] for _ in range(m+1)]


for i in range(n):
    s, e, v = map(int, input().split())

    for j in range(s, e+1):
        arr[j][i] = v

for i in range(2, m+1):
    for j in range(n):
        for l in range(n):
            if arr[i][j] and arr[i-1][l]:
                dp[i][j] = max(dp[i][j], dp[i-1][l]+abs(arr[i-1][l] - arr[i][j]))

print(max(dp[m]))