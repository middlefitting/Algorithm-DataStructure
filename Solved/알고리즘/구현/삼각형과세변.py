while True:
    arr = list(map(int, input().split()))
    arr.sort()
    result = len(set(arr))
    if arr[0] == 0:
        break
    if result == 3:
        if arr[2] >= arr[0] + arr[1]:
            print("Invalid")
        else:
            print("Scalene")
    elif result == 2:
        if arr[2] >= arr[0] + arr[1]:
            print("Invalid")
        else:
            print("Isosceles")
    else:
        print("Equilateral")
