n, r, c = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
r, c = r - 1, c- 1
ans = [arr[r][c]]

def is_range(x, y):
    return 0 <= x < n and 0 <= y < n
        
def can_go(x, y, now):
    return is_range(x, y) and arr[x][y] > now

def move(r, c):
    dxs, dys = [-1, 1, 0, 0], [0, 0, -1, 1]

    for dx, dy in zip(dxs, dys):
        dxr, dyc = dx + r, dy + c
        if can_go(dxr, dyc, arr[r][c]):
            ans.append(arr[dxr][dyc])
            return (dxr, dyc)
    
    return False

while True:
    x = move(r, c)
    if x:
        r, c = x[0], x[1]
    else:
        break

print(*ans)