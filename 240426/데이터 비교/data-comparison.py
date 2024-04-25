n = int(input())
s = set(map(int, input().split()))

m = int(input())
arr = list(map(int, input().split()))

for i in arr:
    if i in s:
        print(1, end=" ")
    else:
        print(0, end=" ")