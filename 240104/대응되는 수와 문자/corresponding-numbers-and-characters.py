n, m = map(int, input().split())
cnt = {}
i = 1
for _ in range(n):
    s = input()
    cnt[s] = str(i)
    cnt[str(i)] = s
    i += 1

for _ in range(m):
    print(cnt[input()])