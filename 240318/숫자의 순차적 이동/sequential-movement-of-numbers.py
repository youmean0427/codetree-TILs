import sys
# sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N, M = map(int, input().split())
arr = []
for _ in range(N):
    arr.append(list(map(int, input().split())))

def find_max(x, y):

    max_value = 0
    max_pos = [0, 0]
    dir = [(-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1)]

    for n, m in dir:
        nx, my = n + x, m + y

        if 0 <= nx < N and 0 <= my < N:
            if arr[nx][my] > max_value:
                max_value = arr[nx][my]
                max_pos = [nx, my]

    arr[x][y], arr[max_pos[0]][max_pos[1]] = arr[max_pos[0]][max_pos[1]], arr[x][y]

def number(i):
    for n in range(N):
        for m in range(N):
            if arr[n][m] == i:
                find_max(n, m)
                return

for _ in range(M): # 턴수
    for i in range(1, N*N+1):
        number(i)

for i in arr:
    print(*i)