n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
move = list(map(int, input().split()))

temp = [[[] for _ in range(n)] for _ in range(n)]

for i in range(n):
    for j in range(n):
        temp[i][j].append(arr[i][j])

dir = [(-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1)]

for m in move:
    now_n = 0
    now_m = 0
    for i in range(n):
        for j in range(n):
            for idx in range(len(temp[i][j])):
                if m == temp[i][j][idx]:
                    now_idx = idx
                    now_n = i
                    now_m = j

    max_num = -1
    move_n = -1
    move_m = -1
    
    for dn, dm in dir:
        dx, dy = now_n + dn, now_m + dm

        if (0 <= dx < n and 0 <= dy < n):
            if (temp[dx][dy]):
                if (max_num < max(temp[dx][dy])):
                    max_num = max(temp[dx][dy])
                    move_n, move_m = dx, dy

    if move_n == -1 and move_m == -1:
        pass
    else:
        temp[move_n][move_m] = temp[now_n][now_m][:now_idx+1] + temp[move_n][move_m]
        temp[now_n][now_m] = temp[now_n][now_m][now_idx+1:]


for i in temp:
    for j in i:
        if (j == []):
            print("None")
        else:
            print(*j)