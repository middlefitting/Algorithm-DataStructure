import heapq


def holsu(i):
    if smallHeap:
        compare = heapq.heappop(smallHeap) * -1
        if compare > i:
            heapq.heappush(smallHeap, i * -1)
            return compare
        heapq.heappush(smallHeap, compare * -1)
    if bigHeap:
        compare = heapq.heappop(bigHeap)
        if compare < i:
            heapq.heappush(bigHeap, i)
            return compare
        heapq.heappush(bigHeap, compare)
    return i


def ccaksu(a, b):
    if a > b:
        heapq.heappush(bigHeap, a)
        heapq.heappush(smallHeap, b * -1)
    else:
        heapq.heappush(bigHeap, b)
        heapq.heappush(smallHeap, a * -1)


if __name__ == "__main__":
    for _ in range(int(input())):
        N = int(input())
        smallHeap = []
        bigHeap = []
        answer = []
        ind = 0
        for __ in range((N + (10 - N % 10)) // 10):
            temp = list(map(int, input().split()))
            mid = 0
            for i in temp:
                ind += 1
                if ind % 2:
                    mid = holsu(i)
                    answer.append(mid)
                else:
                    ccaksu(mid, i)
        ind = 0
        print(len(answer))
        for i in answer:
            ind += 1
            print(i, end=" ")
            if ind % 10 == 0:
                print()






