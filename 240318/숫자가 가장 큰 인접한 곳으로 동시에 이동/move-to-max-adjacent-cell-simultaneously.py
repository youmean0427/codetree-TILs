import sys
# sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

n, m, t = map(int, input().split())
arr = []
balls = []
count = [[0 for _ in range(n)] for _ in range(n)]

for _ in range(n):
    line = list(map(int, input().split()))
    arr.append(line)

for _ in range(m):
    a, b = map(int, input().split())
    count[a-1][b-1] = 1
    balls.append((a-1, b-1))

def max_value(x, y):
    max_val = 0
    max_pos = [0, 0]
    dir = [(1, 0), (-1, 0), (0, 1), (0, -1)]
    for dx, dy in dir:
        dxx = dx + x
        dyy = dy + y
        if 0 <= dxx < n and 0 <= dyy < n:
            if arr[dxx][dyy] >= max_val:
                max_val = arr[dxx][dyy]
                max_pos = [dxx, dyy]
    return max_pos

def check_balls(count):
    global ans
    for x in range(len(count)):
        for y in range(len(count)):
            if count[x][y] > 2:
                count[x][y] = 0
            elif count[x][y] == 1:
                ans += 1
    return count


for i in range(t):
    ans = 0
    cnt = 0
    while cnt < m:
        x, y = balls.pop(0)
        mx, my = max_value(x, y)
        count[x][y] -= 1
        count[mx][my] += 1
        balls.append((mx, my))
        cnt += 1

    count = check_balls(count)

print(ans)