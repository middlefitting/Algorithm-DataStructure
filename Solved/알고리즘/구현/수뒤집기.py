for _ in range(int(input())):
    N = int(input())
    S = str(N)
    temp = ""
    for s in S:
        temp = s + temp
    N = int(temp) + N
    S = str(N)
    temp = ""
    for s in S:
        temp = s + temp
    if int(temp) == N:
        print("YES")
    else:
        print("NO")
