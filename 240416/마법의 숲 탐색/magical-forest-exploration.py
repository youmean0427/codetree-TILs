# import sys
# sys.stdin = open("input.txt", 'r')
# from pprint import pprint
from collections import deque

#  [-1, -1] [-1, 0] [-1, 1]
#  [0, -1] [0, 0] [0, 1]
#  [1, -1] [1, 0] [1, 1]

# [0, 1, 2, 3] # 상우하좌

dir = {0: (-1, 0), 1: (0, 1), 2: (1, 0), 3: (0, -1)}
ten = [(-1, 0), (0, 1), (1, 0), (0, -1)]
left_dir = {0: 3, 3: 2, 2: 1, 1: 0}
right_dir = {0: 1, 1: 2, 2: 3, 3: 0}


def down_can_go(r, c, e):
    # 십자가의 중간을 기준
    check = [[r + 2, c], [r + 1, c - 1], [r + 1, c + 1]]
    # 이동 할 칸이 있을떄
    cnt = 0
    for cn, cm in check:
        if 0 <= cn < R + 3 and 0 <= cm < C:
            if arr[cn][cm] == 0:
                cnt += 1

    # 아래로 이동할 수 있음
    if cnt == 3:
        return (r + 1, c)
    # 아래로 이동할 수 없음
    else:
        return (r, c)


def left_right_down_check(r, c, e, key):
    if key == "left":
        down_check = [[r + 1, c - 2], [r + 2, c - 1]]
    else:
        down_check = [[r + 1, c + 2], [r + 2, c + 1]]

    cnt = 0
    for dcn, dcm in down_check:
        if 0 <= dcn < R + 3 and 0 <= dcm < C:
            if arr[dcn][dcm] == 0:
                cnt += 1
    return cnt


def left_can_go(r, c, e):
    check = [[r, c - 2], [r + 1, c - 1], [r - 1, c - 1]]
    cnt = 0
    for cn, cm in check:
        if 0 <= cn < R + 3 and 0 <= cm < C:
            if arr[cn][cm] == 0:
                cnt += 1

    cnt += left_right_down_check(r, c, e, "left")
    # 왼쪽 이동 가능
    if cnt == 5:
        return down_move(r + 1, c - 1, left_dir[e])
    # 왼쪽 이동 불가능, 오른쪽 이동
    else:
        return right_can_go(r, c, e)


def right_can_go(r, c, e):
    check = [[r, c + 2], [r + 1, c + 1], [r - 1, c + 1]]
    cnt = 0
    for cn, cm in check:
        if 0 <= cn < R + 3 and 0 <= cm < C:
            if arr[cn][cm] == 0:
                cnt += 1


    cnt += left_right_down_check(r, c, e, "right")

    # 오른쪽 이동 가능
    if cnt == 5:
        return down_move(r + 1, c + 1, right_dir[e])
    # 오른쪽 이동 불가능, 아래,왼쪽,오른쪽 모두 불가능
    else:
        return False


def down_move(r, c, e, ):  # 행, 열, 출구
    # 십자가의 가운데를 기준
    global did
    global cnt
    global start
    # 이동 여부 확인 : r, c가 그대로 나온다면? 이동 불가능
    move_r, move_c = down_can_go(r, c, e)

    if move_r == r and move_c == c:
        if not left_can_go(r, c, e) and did == 0:
            arr[move_r][move_c] = cnt
            start = [move_r, move_c]
            for tn, tm in ten:
                arr[move_r + tn][move_c + tm] = cnt
            arr[dir[e][0] + move_r][dir[e][1] + move_c] = cnt
            exit_arr[dir[e][0] + move_r][dir[e][1] + move_c] = 1
            did = 1
            cnt += 1
            return
        else:
            left_can_go(r, c, e)
    else:
        down_move(move_r, move_c, e)


def dfs(start):
    result = 0
    q = deque([(start[0], start[1])])
    visited = [[0] * C for _ in range(R + 3)]
    visited[start[0]][start[1]] = 1
    while q:
        x, y = q.popleft()
        for n, m in ten:
            nx = n + x
            my = m + y
            # 같은 골렘 내에서만 이동 가능, 출구일 경우 이동 가능
            if 0 <= nx < R + 3 and 0 <= my < C and visited[nx][my] == 0:
                if arr[x][y] == arr[nx][my] or (arr[nx][my] != 0 and exit_arr[x][y] == 1):
                    q.append((nx, my))
                    visited[nx][my] = 1
                    result = max(result, nx - 2)
    return result


def out_of_range(arr):
    global exit_arr
    # 범위 넘어가면 배열 초기화
    for n in range(3):
        for m in range(C):
            if arr[n][m]:
                arr = [[0] * C for _ in range(R + 3)]
                exit_arr = [[0] * C for _ in range(R + 3)]
                return (arr, 0)
    return (arr, 1)


# R : 행, C : 열, K : 경우
R, C, K = map(int, input().split())
arr = [[0] * C for _ in range(R + 3)]
exit_arr = [[0] * C for _ in range(R + 3)]

# 각 골렘의 중심 좌표
start = [0, 0]
# 결과값
res = 0
# 골렘 갯수
cnt = 1

for _ in range(K):
    did = 0  # 중복 방지
    col, ex = map(int, input().split())  # col번째에서 내려옴
    down_move(1, col - 1, ex)
    arr, y = out_of_range(arr)
    if y:
        res += dfs(start)

print(res)