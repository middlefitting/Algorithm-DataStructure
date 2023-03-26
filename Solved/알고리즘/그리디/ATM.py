if __name__ == "__main__":
    N = int(input())
    arr = list(map(int, input().split()))
    arr = arr[:N + 1]
    arr.sort()
    wait = 0
    answer = 0
    for i in arr:
        answer += (wait + i)
        wait += i
    print(answer)