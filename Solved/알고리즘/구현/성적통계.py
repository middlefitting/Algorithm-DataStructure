def get_diff(arr):
    arr.sort()
    answer = 0
    for i in range(1, len(arr)):
        answer = max(answer, arr[i] - arr[i - 1])
    return f"Max {arr[len(arr) - 1]}, Min {arr[0]}, Largest gap {answer}"


if __name__ == "__main__":
    for i in range(int(input())):
        print(f"Class {i + 1}")
        arr = list(map(int, input().split()))
        arr = arr[1:]
        result = get_diff(arr)
        print(get_diff(arr))
