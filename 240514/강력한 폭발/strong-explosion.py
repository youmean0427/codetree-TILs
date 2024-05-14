n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

bomb = []

for i in range(n):
    for j in range(n):
        if arr[i][j] == 1:
            bomb.append((i, j))


def bomb_arr(arr):

    dir = {1 : [(1, 0), (2, 0), (-1, 0), (-2, 0)], 2 : [(1, 0), (0, 1), (0, -1), (-1, 0)], 3 : [(1, 1), (-1, 1), (1, -1), (-1, -1)]}
    new_arr = [[0 for _ in range(n)] for _ in range(n)]
    
    for i in range(n):
        for j in range(n):
            if arr[i][j] in dir:
                new_arr[i][j] = 1
                for dn, dm in dir[arr[i][j]]:
                    dni, dmj = dn + i, dm + j
                    if 0 <= dni < n and 0 <= dmj < n:
                        new_arr[dni][dmj] = 1

    cnt = 0
    for i in range(n):
        for j in range(n):
            if new_arr[i][j]:
                cnt += 1
    
    return cnt

def back(cnt, arr):
    global ans

    if cnt >= len(bomb):
        ans = max(ans, bomb_arr(arr))
        return

    
    for i in range(1, 4):
        x, y, = bomb[cnt][0], bomb[cnt][1]
        arr[x][y] = i
        back(cnt+1, arr)
        arr[x][y] = 0

ans = 0
back(0, arr)
print(ans)