from collections import defaultdict

n = int(input())
cnt = defaultdict(int)
for _ in range(n):
    cnt[input()] += 1
sorted_cnt = sorted(cnt.items(), key=lambda x: -x[1])
print(sorted_cnt[0][1])