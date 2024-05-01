from sortedcontainers import SortedSet
n, k = map(int, input().split())
arr = SortedSet(list(map(int, input().split())))
print(*arr[::-1][:k])