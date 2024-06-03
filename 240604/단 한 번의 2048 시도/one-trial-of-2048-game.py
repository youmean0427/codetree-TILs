arr = [list(map(int, input().split())) for _ in range(4)]
dir = input()

def dir_arr(arr):
    
    dir_line = []
    
    if dir == 'L':
        for i in arr:
            dir_line.append(i)

    elif dir == 'R':
        for i in arr:
            dir_line.append(i[::-1])
    
    elif dir == 'U':
        for i in range(4):
            line = []
            for j in range(4):
                line.append(arr[j][i])
            dir_line.append(line)
    
    elif dir == 'D':
        for i in range(3, -1, -1):
            line = []
            for j in range(3, -1, -1):
                line.append(arr[j][i])
            dir_line.append(line)

    return dir_line


def line_sum(line):
  
    gravity = []
    start_idx = 0
    end_idx = 1

    while end_idx < 4:
        if line[start_idx] == line[end_idx]:
            line[start_idx]= 2 * line[start_idx]
            line[end_idx] = 0
            start_idx = end_idx + 1
            end_idx = start_idx + 1
        elif line[start_idx] and line[end_idx] == 0:
            end_idx += 1

        else:
            start_idx = end_idx
            end_idx = start_idx + 1
    
    for i in line:
        if i != 0:
            gravity.append(i)
    

    while len(gravity) < 4:
        gravity.append(0)
 

    return gravity


dir_line = dir_arr(arr)

res = []
for line in dir_line:
    res.append(line_sum(line))


if dir == 'L':
    for i in res:
        print(*i)

elif dir == 'R':
    for i in res:
        print(*i[::-1])

elif dir == 'U':
    for i in range(4):
        for j in range (4):
            print(res[j][i], end = " ")
        print()

elif dir == 'D':
    for i in range(3, -1, -1):
        for j in range (3, -1, -1):
            print(res[j][i], end = " ")
        print()