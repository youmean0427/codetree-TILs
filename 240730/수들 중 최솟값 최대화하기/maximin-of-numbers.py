n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

visited = [0] * n
ans = []

def back(sm, total):
    if sm == n:
        ans.append(min(total))
        return

    for i in range(n):
        if visited[i] == 0:
            visited[i] = 1
            back(sm + 1, total + [arr[sm][i]])
            visited[i] = 0

back(0, [])

print(max(ans))