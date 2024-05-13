n = int(input())
ans = 0

def check(sm):
    i = 0

    while i < n:
        
        if sm[i] == "2":
            if sm[i:i+2].count(sm[i]) == 2:
                i += 2
                continue
            else:
                return False

        elif sm[i] == "3":
            if sm[i:i+3].count(sm[i]) == 3:
                i += 3
                continue
            else:
                return False

        elif sm[i] == "4":
            if sm[i:i+4].count(sm[i]) == 4:
                i += 4
                continue
            else:
                return False
                
        i += 1

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