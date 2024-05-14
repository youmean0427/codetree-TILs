from collections import deque

N, M, Q = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
wind = []
for _ in range(Q):
    r1, c1, r2, c2 = map(int, input().split())
    wind.append((r1-1, c1-1, r2-1, c2-1))

def rotate(r1, c1, r2, c2):
    rotate_arr = deque()

    for i in range(c1, c2):
        rotate_arr.append(arr[r1][i])
    for i in range(r1, r2):
        rotate_arr.append(arr[i][c2])
    for i in range(c2, c1, -1):
        rotate_arr.append(arr[r2][i])
    for i in range(r2, r1, -1):
        rotate_arr.append(arr[i][c1])
    
    rotate_arr.rotate(1)
    
    for i in range(c1, c2):
        arr[r1][i] = rotate_arr.popleft()
    for i in range(r1, r2):
        arr[i][c2] = rotate_arr.popleft()
    for i in range(c2, c1, -1):
        arr[r2][i] = rotate_arr.popleft()
    for i in range(r2, r1, -1):
        arr[i][c1] = rotate_arr.popleft()



def avg(ri, ci):

    dir = [(0, 1), (0, -1), (1, 0), (-1, 0)]

    total = arr[ri][ci]
    cnt = 1
    for dn, dm in dir:
        dnx, dmy = ri + dn, ci + dm
        
        if 0 <= dnx < N and 0 <= dmy < M:
            total += arr[dnx][dmy]
            cnt += 1
    
    return total // cnt


def avg_arr(r1, c1, r2, c2):

    new_arr = [[0 for _ in range(M)] for _ in range(N)]

    for i in range(N):
        for j in range(M):
            new_arr[i][j] = arr[i][j]

    for ri in range(r1, r2+1):
        for ci in range(c1, c2+1):
            new_arr[ri][ci] = avg(ri, ci)
        
    return new_arr

for r1, c1, r2, c2 in wind:
    rotate(r1, c1, r2, c2)
    arr = avg_arr(r1, c1, r2, c2)

for i in arr:
    print(*i)