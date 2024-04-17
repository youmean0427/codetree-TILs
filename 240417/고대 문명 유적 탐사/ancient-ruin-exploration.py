import sys

# sys.stdin = open("input.txt", 'r')
# from pprint import pprint
from collections import deque

#  [-1, -1] [-1, 0] [-1, 1]
#  [0, -1] [0, 0] [0, 1]
#  [1, -1] [1, 0] [1, 1]


K, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(5)]
wall = deque(list(map(int, input().split())))

dir = [(-1, 0), (0, -1), (0, 1), (1, 0)]


def dfs(arr, visited, r, c):
    stack = [(r, c)]
    his = [(r, c)]
    cnt = 1
    while stack:

        x, y = stack.pop()

        if visited[x][y] == 0:
            visited[x][y] = 1

        for n, m in dir:
            xn, ym = x + n, y + m
            if 0 <= xn < 5 and 0 <= ym < 5:
                if visited[xn][ym] == 0 and arr[x][y] == arr[xn][ym]:
                    stack.append((xn, ym))
                    his.append((xn, ym))
                    cnt += 1

    if cnt >= 3:
        return (cnt, his)
    return (0, [])


def select(arr, r, c):
    # 중심 좌표 기준
    # 3x3 선택 좌표
    new_arr = [[0] * 5 for _ in range(5)]
    for i in range(5):
        for j in range(5):
            new_arr[i][j] = arr[i][j]

    pos_arr = [(r - 1, c - 1), (r - 1, c), (r - 1, c + 1), (r, c + 1), (r + 1, c + 1), (r + 1, c), (r + 1, c - 1),
               (r, c - 1)]
    select_arr = deque(
        [arr[r - 1][c - 1], arr[r - 1][c], arr[r - 1][c + 1], arr[r][c + 1], arr[r + 1][c + 1], arr[r + 1][c],
         arr[r + 1][c - 1], arr[r][c - 1]])

    deg = 0
    # 각도 회전 (0 : 90, 1: 180, 2: 270)
    while deg < 3:
        select_arr.rotate(2)

        deg += 1

        for i in range(8):
            new_arr[pos_arr[i][0]][pos_arr[i][1]] = select_arr[i]

        # 회전 결과 arr
        # pprint(new_arr)
        # print(r, c)
        get(new_arr, deg, r, c)


def get(new_arr, deg, r, c):
    global goal
    global deg_r_c, his_res, max_arr

    visited = [[0] * 5 for _ in range(5)]

    # 1차 획득

    total = 0
    his = []

    # 좌표 마다 DFS 실행
    for n in range(5):
        for m in range(5):
            dfs_ans = dfs(new_arr, visited, n, m)
            total += dfs_ans[0]
            his += dfs_ans[1]

    # print(new_arr, total, his)

    if goal < total:
        goal = total
        deg_r_c = [deg, r, c]
        his_res = his
        max_arr = arr_copy(new_arr)
    elif goal == total:
        if deg < deg_r_c[0]:
            goal = total
            deg_r_c = [deg, r, c]
            his_res = his
            max_arr = arr_copy(new_arr)
        elif deg == deg_r_c[0]:
            if c < deg_r_c[2]:
                goal = total
                deg_r_c = [deg, r, c]
                his_res = his
                max_arr = arr_copy(new_arr)

            if c == deg_r_c[2]:
                if r < deg_r_c[1]:
                    goal = total
                    deg_r_c = [deg, r, c]
                    his_res = his
                    max_arr = arr_copy(new_arr)


def arr_copy(arr):
    max_arr = [[0] * 5 for _ in range(5)]

    for n in range(5):
        for m in range(5):
            max_arr[n][m] = arr[n][m]

    return max_arr


goal = 0
ans = 0
# 각도, 행, 열
deg_r_c = [0, 0, 0]
his_res = []
max_arr = []

for i in range(K):
    for n in range(1, 4):
        for m in range(1, 4):
            select(arr, n, m)

    ans += goal
    while True:
        his_res.sort(key=lambda x: (x[1], -x[0]))

        for hn, hm in his_res:
            max_arr[hn][hm] = wall[0]
            wall.rotate(-1)
        goal = 0
        his_res = []
        get(max_arr, deg_r_c[0], deg_r_c[1], deg_r_c[2])

        ans += goal
        if goal == 0 and his_res == []:
            break
    arr = max_arr

    if ans != 0:
        print(ans, end=" ")
    ans = 0