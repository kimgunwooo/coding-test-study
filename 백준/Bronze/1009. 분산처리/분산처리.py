N = int(input())

for i in range(N):
    arr = []
    a, b = map(int,input().split(" "))
    i = 1
    while(True):
        if a**i % 10 not in arr:
            arr.append(a**i % 10)
        else:
            break
        i = i + 1
    if arr[b%len(arr)-1] == 0:
        print(10)
    else: 
        print(arr[b%len(arr)-1])

    