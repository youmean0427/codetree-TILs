from sortedcontainers import SortedDict

n = int(input())
arr = SortedDict()
for _ in range(n):
    x = list(input().split())

    if x[0] == 'add':
        arr[int(x[1])] = int(x[2])
    elif x[0] == 'remove':
        arr.pop(int(x[1]))
    elif x[0] == 'find':
        if int(x[1]) in arr:
            print(arr[int(x[1])])
        else:
            print(None)
    elif x[0] == 'print_list':
        if arr:
            for v in arr.values():
                print(int(v), end = " ")
            print()
        else:
            print(None)