n, m  = map(int, input().split())
dots = list(map(int, input().split()))
lines = []

dots.sort()
for _ in range(m):
    lines.append(list(map(int, input().split())))

# dots를 arr로 두고, 선분의 시작점과 끝점을 찾는 방식
# Lower Bound를 통해, 찾는 값과 같거나 큰 가장 작은 idx를 구함 
def binary_sort(target):

    start = 0
    end = n-1

    min_val = n

    while start <= end:
        mid = (start + end) // 2

        if dots[mid] >= target:
            end = mid - 1
            min_val = min(min_val, mid)
        else:
            start  = mid + 1
    
    return min_val


for s, e in lines:

    start = binary_sort(s)
    end = binary_sort(e)

    ans = end - start
    if end < n:
        if dots[end] == e:
            ans += 1


    print(ans)