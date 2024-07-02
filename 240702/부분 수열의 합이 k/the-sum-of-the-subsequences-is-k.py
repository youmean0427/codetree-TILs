n, k = map(int, input().split())
arr = [0] + list(map(int, input().split()))

prefix = [0] * (n+1)
prefix[0] = arr[0]
for i in range(1, n+1):
    prefix[i] = arr[i] + prefix[i-1]




ans = 0
for i in range(n+1):
    for j in range(0, i):
        x = prefix[i] - prefix[j]
        if x == k:
            ans += 1

print(ans)