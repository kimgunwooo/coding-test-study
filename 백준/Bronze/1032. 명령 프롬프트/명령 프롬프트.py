
N = int(input())
first = input()
result = []
if(N==1):
    result = first
for i in range(N-1):
    sec = input()

    
    for j in range(len(first)):
        if(i==0):
            if(first[j]==sec[j]):
                result.append(sec[j]) 
            else:
                result.append('?')
        else:
            if(first[j]==sec[j]):
                continue
            else:
                result[j] = '?'

str = ''.join(result)
print(str)
