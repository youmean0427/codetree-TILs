n = int(input())
arr = list(map(int, input().split()))

# dp[i]는 i까지의 최대 점프 횟수
dp = [0] * n
# 첫번째 위치에서 시작했음을 표시
dp[0] = 1


for i in range(1, n):
    max_v = 0
    for j in range(i):

        # 첫번째 위치를 고정하기 위해
        # 아래 코드가 없으면, 시작점이 변경 
        if dp[j] == 0:
            continue

        # 현재 칸(i)까지 점프를 할 수 있는 경우
        # 최대값을 찾아냄, 점프 횟수 + 1
        if j + arr[j] >= i:
            max_v = max(max_v, dp[j]+1)

    dp[i] = max_v

print(max(dp)-1)