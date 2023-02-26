from collections import deque

if __name__ == "__main__":
    while True:
        s = str(input())
        if s == "#":
            break
        arr = []
        word = ""
        flag = 0
        flag2 = 0
        flag3 = 0
        possible = 1
        for temp in s:
            if flag2:
                if temp.strip() != "" and flag == 1 and flag3 == 0:
                    flag3 = 1
                    if temp == "/":
                        word += temp
                if temp == ">" and flag == 1:
                    word += ">"
                    arr.append(word)
                    word = ""
                    flag = 0
                    flag2 = 0
                    flag3 = 0
                    continue
                else:
                    continue
            if temp == "<":
                word = ""
                flag = 1
            if flag == 1:
                word += temp.strip()
                if temp != "" and temp.strip() == "":
                    flag2 = 1
            if temp == ">":
                if flag == 1:
                    arr.append(word)
                    word = ""
                    flag = 0
                    flag2 = 0
                    flag3 = 0
        queue = deque([])
        if possible:
            for temp in arr:
                if temp[-2:] == "/>":
                    continue
                elif temp[:2] != "</":
                    queue.appendleft(temp)
                else:
                    if queue and queue[0][1:] == temp[2:]:
                        queue.popleft()
                    else:
                        possible = 0
                        break
        if queue:
            possible = 0
        if possible:
            print("legal")
        else:
            print("illegal")

