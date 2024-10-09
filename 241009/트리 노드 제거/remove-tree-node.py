n = int(input())
arr = list(map(int, input().split()))
x = int(input())

link = [[] for _ in range(n)]
delete = [0 for _ in range(n)]
del_nums = []
for i in range(n):
    if (arr[i] != -1):
        link[arr[i]].append(i)

def dfs(start):

    stack = [start]
    while (stack):
        x = stack.pop()
        delete[x] = 1
        del_nums.append(x)
        for i in link[x]:
            if (delete[i] == 0):
                stack.append(i)

dfs(x)
cnt = 0

for i in range(n):
    if delete[i] == 0 :
        if (len(link[i]) == 1 and link[i][0] in del_nums) or link[i] == []:
            cnt += 1

print(cnt)