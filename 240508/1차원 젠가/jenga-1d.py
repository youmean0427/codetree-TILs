n = int(input())
arr = []
for _ in range(n):
    arr.append(int(input()))

s1, e1 = map(int, input().split())
s2, e2 = map(int, input().split())

first_arr = []

for i in range(len(arr)):
    if s1-1 <= i <= e1-1:
        continue
    else:
        first_arr.append(arr[i])
    
res = []
for j in range(len(first_arr)):
    if s2-1 <= j <= e2-1:
        continue
    else:
        res.append(first_arr[j])

print(len(res))
if res:
    for k in res:
        print(k)