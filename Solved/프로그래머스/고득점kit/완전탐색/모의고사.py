def not_human(sheet, answers):
    size = len(sheet)
    score = 0
    for i in range(len(answers)):
        ind = i % size
        if sheet[ind] == answers[i]:
            score += 1
    return score


def solution(answers):
    answer = []
    sheet1 = [1, 2, 3, 4, 5]
    sheet2 = [2, 1, 2, 3, 2, 4, 2, 5]
    sheet3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    a = [1, not_human(sheet1, answers)]
    b = [2, not_human(sheet2, answers)]
    c = [3, not_human(sheet3, answers)]
    best = max(a[1], b[1], c[1])
    for i in [a, b, c]:
        if i[1] == best:
            answer.append(i[0])
    return answer

print(solution([1,2,3,4,5]))
print(solution([1,3,2,4,2]))
