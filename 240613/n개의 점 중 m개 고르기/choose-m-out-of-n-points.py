import math 
n, m = map(int, input().split())

arr = []

for _ in range(n):
    x, y = map(int, input().split())
    arr.append((x, y))

def dist(sm):

    max_v = 0
    for i in range(len(sm)):
        for j in range(i, len(sm)):
            if i != j:
                dis = math.sqrt((sm[i][0]-sm[j][0]) ** 2 +  (sm[i][1]-sm[j][1]) ** 2 )
        max_v = max(max_v, dis)
    return max_v

ans = float('inf')
def back(idx, sm):
    global ans

    if idx >= len(arr):
        if (len(sm) == m):
            res = dist(sm)
            ans = min(ans, res)
        return

    back(idx+1, sm+[arr[idx]])
    back(idx+1, sm)

back(0, [])


x = ans ** 2
s = str(x)
sid = s.index(".")
if s[sid+1] == '9':
    print(math.ceil(ans**2))
else:
    print(int(ans ** 2))