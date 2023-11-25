while True:
    N = int(input())
    if N == -1:
        break
    arr = []
    for i in range(1, N):
        if N % i == 0:
            arr.append(i)
    if sum(arr) == N:
        print(N, end=" = ")
        for i in range(len(arr)):
            if i != (len(arr) - 1):
                print(arr[i], end=" + ")
            else:
                print(arr[i])
    else:
        print(N, end=" is NOT perfect.")
        print()