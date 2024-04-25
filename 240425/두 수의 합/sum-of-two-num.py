n, k = map(int, input().split())
arr = list(map(int, input().split()))
count = dict()
ans = 0
for i in arr:
    diff = k - i

    if diff in count:
        ans += count[diff]

    if i in count:
        count[i] += 1
    else:
        count[i] = 1

print(ans)