n = int(input())
arr = []

for _ in range(n):
    line = input().split(" ")
    x = line[0]
    if len(line) == 2:
        y = line[1]

    if x == "push_back":
        arr.append(int(y))
    
    elif x == "pop_back":
        arr.pop()

    elif x == "size":
        print(len(arr))
    
    else:
        print(arr[int(y)-1])