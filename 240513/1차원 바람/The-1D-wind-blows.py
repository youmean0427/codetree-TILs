from collections import deque
N, M, Q = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
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

def wind_up(R, D):
    dir_change = {"L": "R", "R": "L"}
    now_r = R
    next_r = R-1

    while True:
        if next_r >= 0:
            if wind_check(now_r, next_r):
                wind_flow(next_r, dir_change[D])
                now_r = next_r
                next_r = now_r - 1
                D = dir_change[D]
            else:
                return
        else:
            return


def wind_down(R, D):
    dir_change = {"L": "R", "R": "L"}
    now_r = R
    next_r = R+1

    while True:
        if next_r < N:
            if wind_check(now_r, next_r):
                wind_flow(next_r, dir_change[D])
                now_r = next_r
                next_r = now_r + 1
                D = dir_change[D]
            else:
                return
        else:
            return

for R, D in wind_arr:
    wind_flow(R, D)
    wind_up(R, D)
    wind_down(R, D)
for i in arr:
    print(*i)