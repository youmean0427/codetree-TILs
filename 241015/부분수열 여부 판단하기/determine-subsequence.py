n, m  = map(int, input().split())
arr = list(map(int, input().split()))
sub = list(map(int, input().split()))


i = 0
j = 0

while (i < n and j < n):
    
    if (arr[i] == sub[j]):
        i += 1
        j += 1
    else:
        i += 1

if (j == m):
    print("Yes")
else:
    print("No")