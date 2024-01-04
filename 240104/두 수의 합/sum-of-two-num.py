from itertools import combinations

n, k = map(int, input().split())
arr = {}
c = 0
for i in input().split():
    arr[c] = int(i)
    c += 1

cnt = 0
for i in range(n):
    for j in range(i+1, n):
        if arr[i] + arr[j] == k:
            cnt += 1
print(cnt)