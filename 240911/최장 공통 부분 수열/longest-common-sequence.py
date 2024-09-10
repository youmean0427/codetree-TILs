A = input()
B = input()

A_len = len(A)
B_len = len(B)

dp = [[0 for _ in range(A_len)] for _ in range(B_len)]
ans = 0

for i in range(A_len):
    if (A[i] == B[0]):
        dp[0][i] = 1
    else:
        if (i-1 >= 0):
            dp[0][i] = dp[0][i-1]

for j in range(B_len):
    if (A[0] == B[j]):
        dp[j][0] = 1
    else:
        if (j-1 >= 0):
            dp[j][0] = dp[0][j-1]

for i in range(1, B_len):
    for j in range(1, A_len):
        if (A[j] == B[i]):
            dp[i][j] = dp[i-1][j-1] + 1
        else:
            dp[i][j] = max(dp[i-1][j], dp[i][j-1])

for i in dp:
    ans = max(ans, max(i))
    
print(ans)