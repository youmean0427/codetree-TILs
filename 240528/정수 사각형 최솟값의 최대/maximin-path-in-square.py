n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

dp = [[[0, 0] for _ in range(n)] for _ in range(n)]

# [top, left]
dp[0][0] = [arr[0][0], arr[0][0]]

for i in range(n):
    for j in range(n):

        # top
        if 0 <= i-1 < n:
            if arr[i][j] < dp[i-1][j][0]:
                dp[i][j][0] = arr[i][j] 
            else:
                dp[i][j][0] = dp[i-1][j][0]


        if 0 <= j-1 < n:
            if arr[i][j] < dp[i][j-1][1]:
                dp[i][j][1] = arr[i][j]
            else:
                dp[i][j][1] = dp[i][j-1][0]
            
        if 0 > i-1 or i-1 >= n:
            dp[i][j][0] = dp[i][j][1]

        if 0 >= j-1 or j-1 >= n:
            dp[i][j][1] = dp[i][j][0]


ans = []
for i in dp[n-2][n-1]:
    if arr[n-1][n-1] < i:
        ans.append(arr[n-1][n-1])
    else:
        ans.append(i)

for i in dp[n-1][n-2]:
    if arr[n-1][n-1] < i:
        ans.append(arr[n-1][n-1])
    else:
        ans.append(i)

print(max(ans))