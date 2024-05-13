n, m = map(int, input().split())
arr = []

for _ in range(n):
    arr.append(int(input()))

cnt = 0
for _ in range(n):
    new_arr = []
    cnt = 0
    for i in range(0, len(arr)):
        if new_arr:
            if new_arr[-1] == arr[i]:
                if i == len(arr) -1:
                    new_arr.pop()
                    break
                cnt = 1
                continue
        if cnt == 1:
            cnt = 0
            new_arr.pop()
            if new_arr[-1] == arr[i]:
                if i == len(arr) -1:
                    new_arr.pop()
                    break
                cnt = 1
                continue
        new_arr.append(arr[i])
    arr = new_arr

if arr:
    print(len(arr))
    for i in arr:
        print(i)
else:
    print(0)