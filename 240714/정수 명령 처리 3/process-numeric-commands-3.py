from collections import deque

n = int(input())

dq = deque()
for _ in range(n):

    line = list(input().split())
    x = line[0]


    if x == "push_front":
        dq.appendleft(int(line[1]))
    elif x == "push_back":
        dq.append(int(line[1]))
    elif x == "pop_front":
        print(dq.popleft())
    elif x == "pop_back":
        print(dq.pop())
    elif x == "size":
        print(len(dq))
    elif x == "empty":
        if dq:
            print(0)
        else:
            print(1)
    elif x == "front":
        print(dq[0])
    elif x == "back":
        print(dq[-1])