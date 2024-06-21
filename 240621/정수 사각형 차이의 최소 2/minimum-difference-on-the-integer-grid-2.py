n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

# TEST.5 ERROR

# 3
# 2 4 2
# 2 1 2
# 2 1 4

# 최솟값, 최댓값
v_dp = [[[0, 0] for _ in range(n)] for _ in range(n)]
# |최댓값 - 최솟값|
d_dp = [[0 for _ in range(n)] for _ in range(n)]

v_dp[n-1][n-1] = [arr[n-1][n-1], arr[n-1][n-1]]
d_dp[n-1][n-1] = 0

# 가로
for i in range(n-2, -1, -1):
    
    if arr[n-1][i] > v_dp[n-1][i+1][1]:
        v_dp[n-1][i][0] = v_dp[n-1][i+1][0]
        v_dp[n-1][i][1] = arr[n-1][i]

    elif arr[n-1][i] < v_dp[n-1][i+1][0]:
        v_dp[n-1][i][0] = arr[n-1][i]
        v_dp[n-1][i][1] = v_dp[n-1][i+1][1]
    
    else:
        v_dp[n-1][i][0] = v_dp[n-1][i+1][0]
        v_dp[n-1][i][1] = v_dp[n-1][i+1][1]
    
    d_dp[n-1][i] = abs(v_dp[n-1][i][1] - v_dp[n-1][i][0])


# 세로
for i in range(n-2, -1, -1):
    
    if arr[i][n-1] > v_dp[i+1][n-1][1]:
        v_dp[i][n-1][0] = v_dp[i+1][n-1][0]
        v_dp[i][n-1][1] = arr[i][n-1]

    elif arr[i][n-1] < v_dp[i+1][n-1][0]:
        v_dp[i][n-1][0] = arr[i][n-1]
        v_dp[i][n-1][1] = v_dp[i+1][n-1][1]
    
    else:
        v_dp[i][n-1][0] = v_dp[i+1][n-1][0]
        v_dp[i][n-1][1] = v_dp[i+1][n-1][1]
    
    d_dp[i][n-1] = abs(v_dp[i][n-1][1] - v_dp[i][n-1][0])


for i in range(n-2, -1, -1):
    for j in range(n-2, -1, -1):

        left = [0, 0]
        left_v = 0
        
        if arr[i][j] < v_dp[i][j+1][0]:
            left[0] = arr[i][j]
            left[1] = v_dp[i][j+1][1] 

        elif arr[i][j] > v_dp[i][j+1][1]:
            left[0] = v_dp[i][j+1][0] 
            left[1] = arr[i][j]
        
        else:
            left[0] = v_dp[i][j+1][0]
            left[1] = v_dp[i][j+1][1]
    
        left_v = abs(left[1] - left[0])

        up = [0, 0]
        up_v = 0

        if arr[i][j] < v_dp[i+1][j][0]:
            up[0] = arr[i][j]
            up[1] = v_dp[i+1][j][1] 

        elif arr[i][j] > v_dp[i+1][j][1]:
            up[0] = v_dp[i+1][j][0] 
            up[1] = arr[i][j]
        
        else:
            up[0] = v_dp[i+1][j][0]
            up[1] = v_dp[i+1][j][1]
    
        up_v = abs(up[1] - up[0])

        if up_v > left_v:
            d_dp[i][j] = left_v
            v_dp[i][j] = left
        else:
            d_dp[i][j] = up_v
            v_dp[i][j] = up
    
print(d_dp[0][0])