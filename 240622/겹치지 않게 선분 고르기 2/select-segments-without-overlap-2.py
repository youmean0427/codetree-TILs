n = int(input())
line = []

# dp[i] : i까지의 겹치는 선분
dp = [0] * 1001

for _ in range(n):
    x, y = map(int, input().split())
    line.append((x, y, y-x+1))

line.sort(key = lambda x: x[0])

for x, y, z in line:
    for i in range(x, y+1):
        dp[i] += 1

ans = n - max(dp) + 1
print(ans)