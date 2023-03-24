from collections import deque

if __name__ == "__main__":
    while True:
        try:
            queue = deque(list(str(input())))
            small = 0
            big = 0
            num = 0
            space = 0
            while queue:
                temp = queue.popleft()
                o = ord(temp)
                if ord('a') <= o <= ord('z'):
                    small += 1
                elif ord('A') <= o <= ord('Z'):
                    big += 1
                elif ord('0') <= o <= ord('9'):
                    num += 1
                elif o == ord(' '):
                    space += 1
            print(small, big, num, space)
        except EOFError:
            break
