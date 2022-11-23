answer = []

def solution(info, query):
    dic = dict()
    for i in info:
        a, b, c, d, e = map(str, i.split())
        a = [a, '-']
        b = [b, '-']
        c = [c, '-']
        d = [d, '-']
        for q in a:
            for w in b:
                for r in c:
                    for t in d:
                        temp = q + " " + w + " " + r + " " + t
                        try:
                            dic[temp].append(int(e))
                        except:
                            dic[temp] = [int(e)]
    for key in dic:
        dic[key].sort()

    for i in query:
        a, b, c, d = map(str, i.split("and "))
        d, e = d.split()
        e = int(e)
        temp = a + b + c + d

        try:
            temp = dic[temp]
            start = 0
            end = len(temp)
            mid = (start + end) // 2
            while True:
                if end - mid <= 1:
                    break
                if temp[mid] >= e:
                    t = mid
                    mid = (start + mid) // 2
                    end = t
                else:
                    t = mid
                    mid = (mid + end) // 2
                    start = t
            if mid > 0:
                if temp[mid - 1] >= e:
                    mid -= 1
            if temp[mid] < e:
                answer.append(len(temp) - mid - 1)
            else:
                answer.append(len(temp) - mid)
        except:
            answer.append(0)
    return answer


info = ["java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"]
query = ["java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"]
print(solution(info, query))
