N = int(input())
arr = []
for _ in range(N):
    arr.append(list(map(int, input().split())))
ans = 0
for i in range(N-2):
    for j in range(N-2):
        a = sum(arr[i][j:j+3])
        b = sum(arr[i+1][j:j+3])
        c = sum(arr[i+2][j:j+3])
        ans = max(ans, a+b+c)
print(ans)