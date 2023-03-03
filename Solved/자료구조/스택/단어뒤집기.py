from collections import deque

if __name__ == "__main__":
    for _ in range(int(input())):
        arr = list(map(str, input().split()))
        stack = deque([])
        for temp in arr:
            temp_arr = list(temp)
            reverse = ""
            while temp_arr:
                reverse += temp_arr.pop()
            stack.append(reverse)
        while stack:
            print(stack.popleft(), end=" ")
        print("")