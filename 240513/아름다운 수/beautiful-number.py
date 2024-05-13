n = int(input())
ans = 0

def check(sm):
    i = 0

    while i < n:

        if i + int(sm[i]) - 1 >= n:
            return False

        for j in range(i, i+int(sm[i])):
            if sm[j] != sm[i]:
                return False

        i += int(sm[i])

    return True


def back(cnt, sm):
    global ans
    if cnt >= n:
        if check(sm):
            ans += 1
        return
    
    for i in range(1, 5): 
        next_sm = sm + str(i)
        back(cnt+1, next_sm)
        next_sm = sm


back(0, "")
print(ans)