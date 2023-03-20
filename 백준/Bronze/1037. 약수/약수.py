n = int(input())
numbers = list(map(int,input().split()))

numbers.sort()

if(n==1):
    print(numbers[0]**2)
else :
    print(numbers[0]*numbers[len(numbers)-1])