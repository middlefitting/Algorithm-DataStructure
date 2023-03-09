if __name__ == "__main__":
    arr = [0] * 26
    for c in str(input()):
        arr[ord(c) - 97] += 1
    for i in arr:
        print(i, end=" ")

