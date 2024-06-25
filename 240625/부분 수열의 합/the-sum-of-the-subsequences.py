n, m = map(int, input().split())
arr = list(map(int, input().split()))
dp = [float('inf')] * (m+1)
dp[0] = 0
# 숫자
for i in range(n):

    # 합
    for j in range(m, -1, -1):
        if j >= arr[i]:
            dp[j] = min(dp[j], dp[j-arr[i]] + 1)

if dp[m] == float('inf'):
    print("No")
else:
    print("Yes")