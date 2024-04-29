from sortedcontainers import SortedSet

n = int(input())
s = SortedSet()
for _ in range(n):
    x = list(input().split())

    if x[0] == 'add':
        s.add(int(x[1]))
    elif x[0] == 'remove':
        s.remove(int(x[1]))
    elif x[0] == 'find':
        if int(x[1]) in s:
            print('true')
        else:
            print('false')
    elif x[0] == 'lower_bound':
        if s and s.bisect_left(int(x[1])) < len(s):
            print(s[s.bisect_left(int(x[1]))])
        else:
            print(None)
    elif x[0] == 'upper_bound':
        if s and s.bisect_right(int(x[1])) < len(s):
            print(s[s.bisect_right(int(x[1]))])
        else:
            print(None)
    elif x[0] == 'largest':
        if s:
            print(s[-1])
        else:
            print(None)
    elif x[0] == 'smallest':
        if s:
            print(s[0])
        else:
            print(None)