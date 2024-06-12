n, m = map(int, input().split())

line = []

for _ in range(m):
    a, b = map(int, input().split())
    line.append((a, a+1, b))

def link_arr(sm):

    link = {}
    for i in sm:
        if i[0] in link:
            link[i[0]].append((i[1], i[2]))
        else:
            link[i[0]] = [(i[1], i[2])]
        
        if i[1] in link:
            link[i[1]].append((i[0], i[2]))
        else:
            link[i[1]] = [(i[0], i[2])]
    return link


def next_line(link, now, sub):
    for e, u in link[now]:
        if sub < u:
            now = e
            sub = u
            return (now, sub)
    return (-1, -1)  

def move(link, length):

    count = []
    for i in range(1, n+1):
        now = i
        sub = 0
        flag = 1
        while flag:

            if now in link:
                link[now].sort(key=lambda x: x[1])

                res = next_line(link, now, sub)
                if (res[0] == -1):
                    flag = 0
                    break
                else:
                    now = res[0]
                    sub = res[1]

            else:
                flag = 0
                break
        count.append(now)
    return (count, length)

def back(cnt, sm):
    global ans
    global s 
    if (cnt >= m):
        link = link_arr(sm)
        res = move(link, len(sm))
        if res[1] == m:
            s = res[0]
        if res[0] == s:
            ans = min(ans, res[1])
            
        return

    back(cnt+1, sm+[line[cnt]])
    back(cnt+1, sm)


ans = m
s = []
back(0, [])
print(ans)