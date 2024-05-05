n, k = map(int, input().split())
arr = list(map(int, input().split()))
ps = [0] * (n+1)
ans = 0

for i in range(1, n+1):
    ps[i] = ps[i-1] + arr[i-1]

for i in range(k, n+1):
    res = ps[i] - ps[i-k]
    ans = max(ans, res)
print(ans)