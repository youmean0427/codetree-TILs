n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]




def square(i, j, r, c, type):

    total = 0
    for row in range(i, i+r+1):
        for col in range(j, j+c+1):
            if 0 <= row < n and 0 <= col < m:
                if visited[row][col] == 0:
                    total += arr[row][col]
                    # 첫번째 직사각형은 방문 표시
                    if type == 1:
                        visited[row][col] = 1
                    # 두번째 직사각형은 방문 표시를 하지 않음 
                else:
                    return float('-inf')
            else:
                return float('-inf')
    return total



ans = float('-inf')
# 격자의 모든 좌표를 순회
for i in range(n):
    for j in range(m):
        # 모든 경우의 직사각형을 만들기
        # r : 세로 / c : 가로
        for r in range(0, n):
            for c in range(0, m):
                # 첫번째 직사각형의 방문 표시
                visited = [[0 for _ in range(m)] for _ in range(n)]
                x = square(i, j, r, c, 1)
                # 두번째 직사각형
                for si in range(n):
                    for sj in range(m):
                        # 첫번째 직사각형이 존재하지 않는 곳에서 시작
                        if visited[si][sj] == 0:

                            for sr in range(0, n):
                                for sc in range(0, m):
                                    y = square(si, sj, sr, sc, 2)
                                    ans = max(ans, x+y)

print(ans)