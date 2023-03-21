if __name__ == "__main__":
    arr = []
    while True:
        try:
            arr.append(list(str(input())))
        except EOFError:
            break
    N = len(arr)
    M = 0
    for i in range(N):
        M = max(len(arr[i]), M)
    for j in range(M):
        for i in range(N):
            if len(arr[i]) > j:
                print(arr[i][j], end="")

