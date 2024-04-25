from sortedcontainers import SortedDict

cnt = SortedDict()
n = int(input())
arr = list(map(int, input().split()))

for i in range(n):
    if arr[i] not in cnt:
        cnt[arr[i]] = i+1

for k, v in cnt.items():
    print(k, v)