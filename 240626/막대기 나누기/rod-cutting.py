n = int(input())
arr = [0] + list(map(int, input().split()))

dp = [0] * (n+1)
for i in range(n):
    dp[i] = arr[i]

for i in range(1, n+1):

    for j in range(1, n+1):
        if i >= j:
            if i % j == 0:
                dp[i] = max(dp[i], dp[j] * (i // j))

            else:
                x = i // j
                y = i % j
                dp[i] = max(dp[i], dp[j] * (i // j) + dp[y]) 
    
print(dp[n])