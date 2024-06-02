n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]


def dfs(sn, sm):
    global ans
    stack = [(sn, sm, 0, arr[sn][sm])]
    dir = {0 : (-1, 1, 0), 1: (-1, 1, 1), 2 :(-1, -1, 2), 3: (1, -1, 3), 4: (1, 1, 4)}
    while stack:

        x, y, z, a = stack.pop()
        # print(x, y, z, a)
        if sn == x and sm == y:
            if z == 4:
                ans = max(ans, a-arr[sn][sm])

        if z < 4:
            d = [dir[z], dir[z+1]]
        else:
            d = [dir[z]]
        for i in range(len(d)):
            dn, dm = d[i][0], d[i][1]
            dx, dy = x + dn, y + dm

            if (0 <= dx < n) and (0 <= dy < n):
                stack.append((dx, dy, d[i][2], arr[dx][dy] + a))

ans = 0
for i in range(n):
    for j in range(n):
        dfs(i, j)

print(ans)