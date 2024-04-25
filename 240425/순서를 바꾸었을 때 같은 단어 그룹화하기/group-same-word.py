from collections import defaultdict

N = int(input())
total = defaultdict(int)
ans = 0
for i in range(N):
    S = input()
    S = sorted(S)
    total["".join(S)] += 1

x = sorted(total.values(), reverse=True)
print(x[0])