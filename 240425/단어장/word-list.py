from sortedcontainers import SortedDict

arr = SortedDict()
n = int(input())

for i in range(n):
    s = input()

    if s in arr:
        arr[s] += 1
    else:
        arr[s] = 1

for k, v in arr.items():
    print(k, v)