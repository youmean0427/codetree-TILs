n, m  = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

def gold(i, j, k):
    gold = 0
    for a in range(n):
        for b in range(n):
            if abs(a-i) + abs(b-j) <= k:
                if arr[a][b] == 1:
                    gold += 1
    return gold

ans = 0
for i in range(n):
    for j in range(n):
        for k in range(2 * (n-1) + 1):
            g = gold(i, j, k)
            gc = g * m
            cost = k * k + (k + 1) * (k + 1)
            if gc > cost:
                ans = max(ans, g)
print(ans)