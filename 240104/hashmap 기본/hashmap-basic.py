n = int(input())
arr = {}
for _ in range(n):
    line = [i for i in input().split()]
    if line[0] == 'add':
        arr[line[1]] = line[2]
    elif line[0] == 'remove':
        arr.pop(line[1])
    else:
        if line[1] in arr:
            print(arr[line[1]])
        else:
            print("None")