n = int(input())

pos = {}
for i in range(n):
    x, y = map(int, input().split())

    if x in pos:
        if pos[x][1] > y:
            pos[x] = (x, y)
    else:
        pos[x] = (x, y)

total = 0
for v in pos.values():
    total += v[1]
print(total)