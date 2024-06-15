from sortedcontainers import SortedSet

n, m = map(int, input().split())
s = SortedSet()

for _ in range(n):
    x, y = map(int, input().split())
    s.add((x, y))

for _ in range(m):
    k = int(input())
    # tuple도 활용 가능
    idx = s.bisect_left((k, -1))

    if idx == len(s):
        print(-1, -1)
    else:
        print(s[idx][0], s[idx][1])
        s.remove(s[idx])