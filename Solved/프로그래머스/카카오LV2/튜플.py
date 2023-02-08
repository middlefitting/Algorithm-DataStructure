def solution(s):
    arr = []
    answer = []
    line = s.split("}")
    for i in range(len(line) - 2):
        temp = line[i].replace("{", "")
        temp = temp.split(",")
        try:
            temp.pop(temp.index(''))
        except:
            temp = temp
        arr.append(temp)
    arr.sort(key=lambda x : len(x))

    for i in arr:
        for j in i:
            if int(j) not in answer:
                answer.append(int(j))
    return answer

print(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"))