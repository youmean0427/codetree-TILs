n, m = map(int, input().split())
arr = []

for _ in range(n):
    arr.append(int(input()))

for _ in range(n):
    
    i = 0
    j = 1

    start = 0
    end = 0
    
    boom = []

    while i <= j and j < len(arr):

        if arr[i] == arr[j]:
            start = i 
            j += 1

            if j >= len(arr):
                if j-1 - i + 1 >= m:
                    boom.append((start, j-1))
                    break

        else:
            if start:
                if j-1 - i + 1 >= m: 
                    end = j-1
                    boom.append((start, end))
                    start = 0
                    end = 0
                    
                    i = j
                    j = i+1
                    continue


            i += 1
            j += 1

    for x, y in boom:
        for i in range(x, y+1):
            arr[i] = 0


    new_arr = []
    for i in arr:
        if i != 0:
            new_arr.append(i)
    
    arr = new_arr 

if arr:
    if m == 1:
        print(0)
    else:
        print(len(arr))
        for i in arr:
            print(i)
else:
    print(0)