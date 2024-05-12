from sortedcontainers import SortedDict
n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
nums = SortedDict()

def find(nx, ny, k):
    
    dir = [(-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1), (0, -1), (-1, -1)]

    max_value = 0
    for dn, dm in dir:
        dnx, dny = dn + nx, dm + ny
        if 0 <= dnx < n  and 0 <= dny < n:
            if max_value < arr[dnx][dny]:
                max_value = arr[dnx][dny]
                max_pos = (dnx, dny)

    arr[nx][ny], arr[max_pos[0]][max_pos[1]] = arr[max_pos[0]][max_pos[1]], arr[nx][ny]
    nums[arr[nx][ny]], nums[arr[max_pos[0]][max_pos[1]]] = (nx, ny),  (max_pos[0], max_pos[1])


def change():

    for i in range(n):
        for j in range(n):
            nums[arr[i][j]] = (i, j)
            
    for _ in range(m):
        for i in nums:
            find(nums[i][0], nums[i][1], i)

change()

for i in arr:
    print(*i)