n, m = map(int, input().split())
arr = list(map(int, input().split()))

dp = [float('-inf')] * (m+1)
dp[0] = 0

# 동전의 합
for i in range(m+1):
    # 동전의 종류
    for j in range(n):
        if i >= arr[j]:
            dp[i] = max(dp[i], dp[i-arr[j]] + 1)


if dp[m]:
    print(dp[m])
else:
    print(-1)