from itertools import combinations

n, k = map(int, input().split())
arr = [int(i) for i in input().split()]

select = list(combinations(arr, 2))
cnt = 0
for x, y in select:
    if (x+y == k):
        cnt += 1
print(cnt)