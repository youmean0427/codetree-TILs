N, M = map(int, input().split())
bomb = []
for _ in range(N):
    bomb.append(int(input()))



explode = True

while explode:

    explode = False
    start_idx = 0
    end_idx = 1

    while end_idx < len(bomb):

        if bomb[start_idx] == bomb[end_idx]:
            end_idx += 1

            if end_idx >= len(bomb):
                if end_idx - start_idx >= M:
                    bomb[start_idx:end_idx] = [0] * (end_idx - start_idx)
                    explode = True

        else:
            if end_idx - start_idx >= M:
                bomb[start_idx:end_idx] = [0] * (end_idx - start_idx)
                explode = True
            start_idx = end_idx
            end_idx = start_idx + 1

    temp = []
    if M == 1:
        pass
    else:
        for i in bomb:
            if i:
                temp.append(i)
    bomb=temp

if bomb:
    print(len(bomb))
    for b in bomb:
        print(b)
else:
    print(0)