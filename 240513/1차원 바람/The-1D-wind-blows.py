from collections import deque
N, M, Q = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
dir_change = {"L": "R", "R": "L"}
wind_arr = []

for _ in range(Q):
    R, D = input().split()
    R = int(R) - 1
    wind_arr.append((R, D))

def wind_flow(R, D):
    dir = {"L": 1, "R": -1}
    wind_row = deque(arr[R])
    wind_row.rotate(dir[D])
    
    for i in range(M):
        arr[R][i] = wind_row[i]

def wind_check(now_r, next_r):
    for i in range(M):
        if arr[now_r][i] == arr[next_r][i]:
            return True
    return False

def wind_move(R, D, UD):
    now_r = R
    next_r = R+1

    if UD == "U":
        next_r = R-1

    while True:
        if 0 <= next_r < N:
            if wind_check(now_r, next_r):
                wind_flow(next_r, dir_change[D])
                now_r = next_r
                next_r = now_r + 1
                if UD == "U":
                    next_r = now_r - 1
                D = dir_change[D]
            else:
                return
        else:
            return

for R, D in wind_arr:
    wind_flow(R, D)
    wind_move(R, D, "U")
    wind_move(R, D, "D")
for i in arr:
    print(*i)