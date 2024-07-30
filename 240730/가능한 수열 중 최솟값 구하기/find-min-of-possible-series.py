n = int(input())

def check(arr):

    for i in range(len(arr)-1):
        stop = i
        start = len(arr) -1

        while arr[start] == arr[stop]:
            start -= 1
            stop -= 1

            if start == i:
                return True
            if start < 0:
                break
    return False


def back(cnt, sm):

    if check(sm):
        return
    
    if cnt >= n:
        if check(sm) == False:
            for i in sm:
                print(i, end="")
            exit(0)
        return
    if sm:
        if sm[-1] != 4:
            back(cnt+1, sm+[4])
        if sm[-1] != 5:
            back(cnt+1, sm+[5])
        if sm[-1] != 6:
            back(cnt+1, sm+[6])
    else:
        back(cnt+1, sm+[4])
        back(cnt+1, sm+[5])
        back(cnt+1, sm+[6])

back(0, [])