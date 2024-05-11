n, m, t = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
balls = []
balls_cnt = [[0 for _ in range(n)] for _ in range(n)]
for _ in range(m):
    x, y = map(int, input().split())
    balls.append((x-1, y-1))


def check_ball_cnt(arr):

    for i in range(n):
        for j in range(n):
            if arr[i][j] >= 2:
                arr[i][j] = 0
    return arr


def find():
    move_arr = [[0 for _ in range(n)] for _ in range(n)]
    dir = [(-1, 0), (1, 0), (0, 1), (0, -1)]

    while balls:
        bn, bm = balls.pop(0)

        m_b = 0
        for dn, dm in dir:
            bdn, bdm = bn + dn, bm + dm
            if 0 <= bdn < n and 0 <= bdm < n:
                if arr[bdn][bdm] > m_b:
                    m_b = arr[bdn][bdm]
                    next_pos = (bdn, bdm)
        
        move_arr[next_pos[0]][next_pos[1]] += 1
    
   
    balls_cnt = check_ball_cnt(move_arr)


    for i in range(n):
        for j in range(n):
            if balls_cnt[i][j]:
                balls.append((i, j))
    return balls_cnt

while t > 0:
    balls_cnt = find()
    t -= 1

ans = 0
for i in range(n):
    for j in range(n):
        if balls_cnt[i][j]:
            ans += 1
print(ans)