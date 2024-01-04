from collections import defaultdict

n = int(input())
cnt = defaultdict(int)
ans = 0
for _ in range(n):
    k = input()
    cnt[k] += 1
    ans = max(ans, cnt[k])

print(ans)