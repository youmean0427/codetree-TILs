n = int(input())
x, y = map(int, input().split())
arr = [list(input()) for _ in range(n)]
x, y = x - 1, y- 1
T = 1
arrive_x, arrive_y = 0, 0

def is_wall(x, y, d):
    dir = {1: (1, 0), 2: (0, 1), 3: (-1, 0), 4: (0, -1)}
    
    dn, dm = dir[d]
    dnx, dmy = dn + x, dm + y

    if 0 <= dnx < n and 0 <= dmy < n:
        if arr[dnx][dmy] == "#":
            return True
    return False
        

def is_move(x, y, d):
    global T, arrive_x, arrive_y
    dir = {1: (0, 1), 2: (-1, 0), 3: (0, -1), 4: (1, 0)}
    c_dir = {1: 2, 2: 3, 3: 4, 4: 1}
    rc_dir = {1 : 4, 2: 1, 3: 2, 4: 3}
    dn, dm = dir[d]
    dnx, dmy = dn + x, dm + y

    if 0 <= dnx < n and 0 <= dmy < n:
        if arr[dnx][dmy] == "#":
            d = c_dir[d]
            return (x, y, d)
        else:
            if is_wall(dnx, dmy, d):
                T += 1
                return (dnx, dmy, d)
            else:
                d = rc_dir[d]
                T += 1
                return (dnx, dmy, d)

    else:
        arrive_x = dnx
        arrive_y = dmy
        return False


def dfs(sn, sm):
    stack = [(sn, sm, 1)]
    visited = [[0 for _ in range(n)] for _ in range(n)]
    while stack:
        x, y, d = stack.pop()

        visited[x][y] += 1
        mr = is_move(x, y, d)
        if mr:
            if visited[mr[0]][mr[1]] < 4:
                stack.append((mr[0], mr[1], mr[2]))
        else:
            return

dfs(x, y)

if 0 <= arrive_x < n and 0 <= arrive_y < n:
    print(-1)
else:
    print(T)