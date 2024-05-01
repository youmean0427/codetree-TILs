n, m = map(int, input().split())
s = set()
arr = list(map(int, input().split()))[::-1]
for i in arr:
    s.add(i)
print(len(s))