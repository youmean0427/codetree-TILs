T = int(input())

def ball_move():

    move_arr = [["" for _ in range(n)] for _ in range(n)]

    dir = {'L': (0, -1), 'U': (-1, 0), 'R': (0, 1), 'D': (1, 0)}
    c_dir = {'L': 'R', 'R': 'L', 'U': 'D', 'D': 'U'}
    for i in range(n):
        for j in range(n):
            if arr[i][j]:
                d = dir[arr[i][j]]
                di, dj = i + d[0], j + d[1]
                if 0 <= di < n and 0 <= dj < n:
                    move_arr[di][dj] += arr[i][j]
                else:
                    move_arr[i][j] += c_dir[arr[i][j]]

    cnt = 0
    for i in range(n):
        for j in range(n):
            if len(move_arr[i][j]) > 1:
                move_arr[i][j] = ""
            elif move_arr[i][j]:
                cnt += 1

    return (cnt, move_arr)

for _ in range(T):
    n, m = map(int, input().split())
    arr = [["" for _ in range(n)] for _ in range(n)]

    for _ in range(m):
        ball = input().split()
        ball_x, ball_y = int(ball[0])-1, int(ball[1])-1
        arr[ball_x][ball_y] = ball[2]
    
    for _ in range(2*n):
        next_arr = ball_move()
        arr = next_arr[1]

    print(next_arr[0])