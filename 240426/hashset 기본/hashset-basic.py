n = int(input())
s = set()
for _ in range(n):
    x = list(input().split())

    if x[0] == "add":
        s.add(x[1])
    elif x[0] == "remove":
        s.remove(x[1])
    elif x[0] == "find":
        if x[1] in s:
            print("true")
        else:
            print("false")