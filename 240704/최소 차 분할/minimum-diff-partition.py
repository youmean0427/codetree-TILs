n = int(input())
arr = list(map(int, input().split()))
m = sum(arr)
dp = [[0 for _ in range(m+1)] for _ in range(n)]

dp[0][arr[0]] = 1

for i in range(1, n):

    for j in range(m):
        if dp[i-1][j]:
            if j + arr[i] < m:
                dp[i][j+arr[i]] = 1
            dp[i][abs(j-arr[i])] = 1
        
for i in range(m):
    if dp[n-1][i]:
        print(i)
        break