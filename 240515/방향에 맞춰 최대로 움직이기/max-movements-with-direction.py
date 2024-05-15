N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
dir_arr = [list(map(int, input().split())) for _ in range(N)]
r, c = map(int, input().split())
r, c = r - 1, c - 1

dir = {1: (-1, 0), 2: (-1, 1), 3: (0, 1), 4: (1, 1), 5: (1, 0), 6: (1, -1), 7: (0, -1), 8: (-1, -1)}
ans = 0

def back(cnt, sn, sm, his):
    global ans
    ans = max(cnt , ans)

    for i in range(1, N):
        dn = dir[dir_arr[sn][sm]][0] * i
        dm = dir[dir_arr[sn][sm]][1] * i
        next_n = dn + sn
        next_m = dm + sm
        if 0 <= next_n < N and 0 <= next_m < N:
            if arr[next_n][next_m] > arr[sn][sm]:
                back(cnt+1, next_n, next_m, his+[arr[next_n][next_m]])
  

back(0, r, c, [arr[r][c]])
print(ans)