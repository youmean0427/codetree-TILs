from sortedcontainers import SortedSet

n = int(input())
s = SortedSet()

for _ in range(n):
    num, step = map(int, input().split())
    s.add((step, num))

m = int(input())

for _ in range(m):
    x = list(input().split())

    if x[0] == "ad":
        s.add((int(x[2]), int(x[1])))
    elif x[0] == "sv":
        s.remove((int(x[2]), int(x[1])))
    elif x[0] == "rc":
        if x[1] == "1":
            print(s[-1][1])
        elif x[1] == "-1":
            print(s[0][1])