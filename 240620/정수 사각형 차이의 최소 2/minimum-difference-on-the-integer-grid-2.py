n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

# 각 경로까지의 최대값-최솟값의 최소값
min_dp = [[0 for _ in range(n)] for _ in range(n)]

# 각 경로까지의 최대값-최솟값의 최솟값이 되는, [최솟값, 최대값]
both_dp = [[[0, 0] for _ in range(n)] for _ in range(n)]
both_dp[0][0] = [arr[0][0], arr[0][0]]

for i in range(n):
    for j in range(n):

        up_v = float('inf')
        left_v = float('inf')

        # 위쪽
        if 0 <= i-1 < n:

            max_v = both_dp[i-1][j][1]
            min_v = both_dp[i-1][j][0]
            if arr[i][j] < min_v:
                min_v = arr[i][j]
            elif arr[i][j] > max_v:
                max_v = arr[i][j]

            up_v = abs(max_v-min_v)
            up_p = [min_v, max_v]
        
        # 왼쪽
        if 0 <= j-1 < n:

          
            max_v = both_dp[i][j-1][1]
            min_v = both_dp[i][j-1][0]

            if arr[i][j] < min_v:
                min_v = arr[i][j]
            elif arr[i][j] > max_v:
                max_v = arr[i][j]

            left_v = abs(max_v-min_v)
            left_p = [min_v, max_v]


        if left_v > up_v:
            min_dp[i][j] = up_v
            both_dp[i][j] = up_p 
        elif up_v > left_v:
            min_dp[i][j] = left_v
            both_dp[i][j] = left_p
        else:
            if up_v == float('inf'):
                pass
            else:
                min_dp[i][j] = up_v
                both_dp[i][j] = up_p


print(min_dp[n-1][n-1])