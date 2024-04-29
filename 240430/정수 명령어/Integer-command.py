from sortedcontainers import SortedSet

T = int(input())
for _ in range(T):

    s = SortedSet()
    k = int(input())

    for _ in range(k):
        x = list(input().split())
        y = int(x[1])

        if x[0] == "I":
            s.add(y)
        elif x[0] == "D" and s:
            if y == 1:
                s.remove(s[-1])
            else:
                s.remove(s[0])
    
    if s:
        print(s[-1], s[0])
    else:
        print("EMPTY")