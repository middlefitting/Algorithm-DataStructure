def solution(survey, choices):
    test = ["RT", "CF", "JM", "AN"]
    score = [0, 0, 0, 0]
    answer = ""

    for i in range(len(survey)):
        try:
            score[test.index(survey[i])] += (choices[i] - 4)
        except:
            temp = survey[i][1] + survey[i][0]
            score[test.index(temp)] += (choices[i] - 4) * -1

    for i in range(len(score)):
        if score[i] > 0:
            answer += test[i][1]
        else:
            answer += test[i][0]
    return answer
