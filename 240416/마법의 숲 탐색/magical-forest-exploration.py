# import sys
# sys.stdin = open("input.txt", 'r')


#  -1 -1 -1 0 -1, 1
#  0 -1 0 0  0 1
#  1 -1 1 0 1 1

# 0, 1, 2, 3

dir = {0: (-1, 0), 1: (0, 1), 2: (1, 0), 3: (0, -1)}
ten = [(-1, 0), (0, 1), (1, 0), (0, -1)]
left_dir = {0: 3, 3: 2, 2: 1, 1: 0}
right_dir = {0: 1, 1: 2, 2: 3, 3: 0}

def down_can_go(r, c, e):
    # 중간을 기준
    check = [[r+2, c], [r+1, c-1], [r+1, c+1]]
    # 다음 칸이 있을떄
    cnt = 0
    for cn, cm in check:
        if 0 <= cn < R+3 and 0 <= cm < C:
            if arr[cn][cm] == 0:
                cnt += 1

    # 아래로 이동할 수 있음
    if cnt == 3:
        return (r+1, c)
    else:
        return (r, c)

def left_can_go(r, c, e, flag):
    check = [[r, c-2], [r+1, c-1], [r-1, c-1]]
    cnt = 0
    for cn, cm in check:
        if 0 <= cn < R+3 and 0 <= cm < C:
            if arr[cn][cm] == 0:
                cnt += 1

    down_check = [[r+1, c-2], [r+2, c-1]]

    for dcn, dcm in down_check:
        if 0 <= dcn < R+3 and 0 <= dcm < C:
            if arr[dcn][dcm] == 0:
                cnt += 1

    # 왼쪽 이동 가능
    if cnt == 5:
        return down_move(r+1, c-1, left_dir[e], flag)
    else:
        # 오른쪽
        return right_can_go(r, c, e, flag+1)

def right_can_go(r, c, e, flag):
    check = [[r, c+2], [r+1, c+1], [r-1, c+1 ]]
    cnt = 0
    for cn, cm in check:
        if 0 <= cn < R+3 and 0 <= cm < C:
            if arr[cn][cm] == 0:
                cnt += 1

    down_check = [[r + 1, c + 2], [r + 2, c + 1]]

    for dcn, dcm in down_check:
        if 0 <= dcn < R + 3 and 0 <= dcm < C:
            if arr[dcn][dcm] == 0:
                cnt += 1
    # 오른쪽 이동 가능
    if cnt == 5:
        return down_move(r+1, c+1, right_dir[e], flag)
    else:
        # 전부다 불가능
        return False



# 가운데를 기준으로
def down_move(r, c, e, flag): # 행, 열, 출구
    global start
    # r, c랑 같으면 이동 못함
    move_r, move_c = down_can_go(r, c, e)
    if move_r == R+1:
        arr[move_r][move_c] = 3
        start = [move_r, move_c]
        for tn, tm in ten:
            arr[move_r + tn][move_c + tm] = 1
        arr[dir[e][0] + move_r][dir[e][1] + move_c] = 2
        return

    if move_r == r and move_c == c:
         if left_can_go(r, c, e, flag) == False:
             if flag > 1:
                 arr[move_r][move_c] = 3
                 start = [move_r, move_c]
                 for tn, tm in ten:
                     arr[move_r + tn][move_c + tm] = 1
                 arr[dir[e][0] + move_r][dir[e][1] + move_c] = 2
             return
         else:
             left_can_go(r, c, e, flag+1)
    else:
        down_move(move_r, move_c, e, flag+1)


def dfs(start):
    global ans
    stack = [(start[0], start[1], 0)]
    visited = [[0] * C for _ in range(R + 3)]
    max_val = 0
    while stack:

        x, y, z = stack.pop()

        max_val = max(max_val, x)

        if x == R+3:
            ans += R
            return

        dir = [(-1, 0), (1, 0), (0, 1), (0, -1)]

        if visited[x][y] == 0:
            visited[x][y] = 1

        for n, m in dir:
            xn = x + n
            ym = y + m

            if 0 <= xn < R+3 and 0 <= ym < C:
                if visited[xn][ym] == 0 and arr[xn][ym] != 0:
                    if arr[x][y] == 2:
                        stack.append((xn, ym, 1))
                    if arr[x][y] == 3:
                        stack.append((xn, ym, z))
                    if arr[x][y] == 1 and z == 1:
                        stack.append((xn, ym, z))

    return max_val - 2

def out_of_range(arr):

    for n in range(3):
        for m in range(C):
            if arr[n][m]:
                arr = [[0] * C for _ in range(R+3)]
                return (arr, 0)
    return (arr, 1)


# R : 행, C : 열, K
R, C, K = map(int, input().split())
arr = [[0] * C for _ in range(R+3)]
start = [0, 0]
ans = 0
res = 0
for _ in range(K):

    col, ex = map(int, input().split())
    # col번째 행에서 내려옴
    # 중간이 기준
    # print(col-1)
    down_move(1, col-1, ex, 1)

    arr, y = out_of_range(arr)
    # pprint(arr)

    if y:
        res += dfs(start)

print(res)