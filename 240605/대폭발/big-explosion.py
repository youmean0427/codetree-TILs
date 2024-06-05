n, m, r, c = map(int, input().split())
r, c = r-1, c-1
arr = [[0 for _ in range(n)] for _ in range(n)]
arr[r][c] = 1

def find_bomb(arr):
    bomb = []
    
    for i in range(n):
        for j in range(n):
            if arr[i][j]:
                bomb.append((i, j))
    return bomb
    
time = 0
while time < m:
    
    dir = [(0, 2**time), (2**time, 0), (-(2**time), 0), (0, -(2**time))]
    bomb = find_bomb(arr)

    for x, y in bomb:
        for dn, dm in dir:
            xn, ym = x + dn, y + dm
            if (0 <= xn < n and 0 <= ym < n):
                if (arr[xn][ym] == 0):
                    arr[xn][ym] = 1

    time += 1

ans = 0
for i in arr:
    ans += sum(i)
print(ans)