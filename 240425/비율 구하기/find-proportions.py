from sortedcontainers import SortedDict
n = int(input())
cnt = SortedDict()
for i in range(n):
    x = input()
    if x in cnt:
        cnt[x] += 1
    else:
        cnt[x] = 1

for i, v in cnt.items():
    r = format((v / n) * 100, ".4f")
    print(i, r)