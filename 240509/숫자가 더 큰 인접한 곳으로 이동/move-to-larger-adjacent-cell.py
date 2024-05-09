n, r, c = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

dir = {1 : (-1, 0), 2 : (1, 0), 3 : (0, -1), 4 : (0, 1)}
r -= 1
c -= 1
ans = [arr[r][c]]

def dfs(r, c):
    
    stack = [(r, c)]
    while stack:
        x, y = stack.pop()
        max_value = 0

        for idx in dir.keys():
            dnx, dmy = dir[idx][0] + x, dir[idx][1] + y

            if 0 <= dnx < n and 0 <= dmy < n:
                if arr[dnx][dmy] > arr[x][y]:
                    max_value = arr[dnx][dmy]
                    stack.append((dnx, dmy))
                    ans.append(max_value)
                    break

dfs(r, c)
print(*ans)