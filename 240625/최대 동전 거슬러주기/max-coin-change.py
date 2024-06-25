n, m = map(int, input().split())
arr = list(map(int, input().split()))

dp = [0] * (m+1)

# 동전의 합
for i in range(m+1):
    # 동전의 종류
    for j in range(n):
        if i >= arr[j]:
            dp[i] = max(dp[i], dp[i-arr[j]] + 1)

print(dp[m])