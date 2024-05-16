N, M = map(int, input().split())

visited = [0] * (N+1)
def back(cnt, sm):

    if cnt > N:
        return

    if len(sm) >= M:
        print(*sm)
        return

    for i in range(cnt, N+1):
        if visited[i] == 0:
            visited[i] = 1
            back(i, sm+[i])
            visited[i] = 0

back(1, [])