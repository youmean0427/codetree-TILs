N, M = map(int, input().split())
bomb = []
for _ in range(N):
    bomb.append(int(input()))


time = N//2
while (time >= 0 ):
    temp = []
    if len(bomb) == 0:
        break
    now_bomb = bomb[0]
    bomb_cnt = 1

    for idx in range(1, len(bomb)):
        if now_bomb == bomb[idx]:
            bomb_cnt += 1
        else:
            temp.append((now_bomb, bomb_cnt))
            now_bomb = bomb[idx]
            bomb_cnt = 1

    temp.append((now_bomb, bomb_cnt))

    temp2 = []
    for num, cnt in temp:
        if cnt >= M:
            continue
        else:
            while cnt:
                temp2.append(num)
                cnt -= 1
    bomb = temp2
    time -= 1



if (bomb):
    print(len(bomb))
    for i in bomb:
        print(i)
else:
    print(0)