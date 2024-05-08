n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

def find(x, y):
    
    dir = [(0, 1), (1, 0), (-1, 0), (0, -1)]
    res = [0]
    visited = [[0 for _ in range(n)] for _ in range(n)]
    while True:
        total = 0
        for dn, dm in dir:
            dnx, dmy = dn + x, dm + y
            if 0 <= dnx < n and 0 <= dmy < n:
                if visited[dnx][dmy] == 0:
                    total += arr[dnx][dmy]
                    visited[dnx][dmy] = 1
            else:
                total =  0
                break
        if total != 0:
            res.append(res[-1]+total)

        x -= 1
        y += 1

        if 0 <= x < n and  0 <= y < n:
            continue
        else:
            break
    
    return res

ans = 0
for i in range(1, n-1):
    for j in range(1, n-1):
        res = find(i, j)
        ans = max(ans, max(res))

print(ans)