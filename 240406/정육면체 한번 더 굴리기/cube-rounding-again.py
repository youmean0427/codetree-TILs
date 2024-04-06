import sys
input = sys.stdin.readline

dice = {6: {2: {"R": 3, "U": 5, "D": 2, "L": 4},
            3: {"R": 5, "U": 4, "D": 3, "L": 2},
            4: {"R": 2, "U": 3, "D": 4, "L": 5},
            5: {"R": 4, "U": 2, "D": 5, "L": 3}},
        2: {1: {"R": 3, "U": 6, "D": 1, "L": 4},
            3: {"R": 6, "U": 4, "D": 3, "L": 1},
            4: {"R": 1, "U": 3, "D": 4, "L": 6},
            6: {"R": 4, "U": 1, "D": 6, "L": 3}},
        3: {1: {"R": 5, "U": 6, "D": 1, "L": 2},
            2: {"R": 1, "U": 5, "D": 2, "L": 6},
            5: {"R": 6, "U": 2, "D": 5, "L": 1},
            6: {"R": 2, "U": 1, "D": 6, "L": 5}},
        4: {1: {"R": 2, "U": 6, "D": 1, "L": 5},
            2: {"R": 6, "U": 5, "D": 2, "L": 1},
            5: {"R": 1, "U": 2, "D": 5, "L": 6},
            6: {"R": 5, "U": 1, "D": 6, "L": 2}},
        5: {1: {"R": 4, "U": 6, "D": 1, "L": 3},
            3: {"R": 1, "U": 4, "D": 3, "L": 6},
            4: {"R": 6, "U": 3, "D": 4, "L": 1},
            6: {"R": 3, "U": 1, "D": 6, "L": 4}},
        1: {2: {"R": 4, "U": 5, "D": 2, "L": 3},
            3: {"R": 2, "U": 4, "D": 3, "L": 5},
            4: {"R": 5, "U": 3, "D": 4, "L": 2},
            5: {"R": 3, "U": 2, "D": 5, "L": 4}},
        }
# Front
# R, L : 그대로 / U : 현재 bottom / D : 현재 bottom cop

dirs = {"R": (0, 1), "U": (-1, 0), "D": (1, 0), "L": (0, -1)}
cop = {1: 6, 2: 5, 3: 4, 4: 3, 5: 2, 6: 1}


def near(nx, ny):
    # bfs
    visited = {(nx, ny): 1}
    q = [(nx, ny)]
    total = 0

    while q:
        x, y = q.pop(0)
        total += arr[x][y]

        for i in dirs:
            dn, dm = dirs[i]
            dnx, dmy = dn + x, dm + y

            if 0 <= dnx < N and 0 <= dmy < N:
                if arr[dnx][dmy] == arr[nx][ny]:
                    if (dnx, dmy) not in visited:
                        visited[(dnx, dmy)] = 1
                        q.append((dnx, dmy))

    return total


def reflect(rx, ry, rd):
    re_dir = {"R": "L", "L": "R", "U": "D", "D": "U"}
    re_rd = re_dir[rd]
    dn, dm = dirs[re_rd]
    rxdn, rydm = rx + dn, ry + dm

    return (rxdn, rydm, re_rd)


def dice_move(start):
    # dfs
    stack = [start]
    bottom = 6
    front = 2
    dir = "R"
    degree_clock = {"R": "D", "D": "L", "L": "U", "U": "R"}
    degree_rclock = {"R": "U", "D": "R", "L": "D", "U": "L"}
    ans = 0
    idx = 0
    while idx < M:

        x, y = stack.pop()
        if x == 0 and y == 0:
            dn, dm = dirs[dir]
            dnx, dmy = dn + x, dm + y
            if 0 <= dnx < N and 0 <= dmy < N:
                bottom = dice[bottom][front][dir]
                stack.append((dnx, dmy))
                ans += near(dnx, dmy)
                idx += 1
            continue

        if bottom > arr[x][y]:
            dir = degree_clock[dir]
        elif bottom < arr[x][y]:
            dir = degree_rclock[dir]

        dn, dm = dirs[dir]
        dnx, dmy = dn + x, dm + y
        if 0 <= dnx < N and 0 <= dmy < N:
            stack.append((dnx, dmy))

            old_bottom = bottom
            bottom = dice[bottom][front][dir]
            if (dir == "U"):
                front = old_bottom
            elif (dir == "D"):
                front = cop[old_bottom]

            ans += near(dnx, dmy)

        else:
            dnx, dmy, dir = reflect(x, y, dir)
            stack.append((dnx, dmy))

            old_bottom = bottom
            bottom = dice[bottom][front][dir]
            if (dir == "U"):
                front = old_bottom
            elif (dir == "D"):
                front = cop[old_bottom]

            ans += near(dnx, dmy)
        idx += 1
    return ans


N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
print(dice_move((0, 0)))