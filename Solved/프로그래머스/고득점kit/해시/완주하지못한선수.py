def solution(participant, completion):
    d = dict()
    for i in participant:
        try:
            d[i] += 1
        except:
            d[i] = 1
    for i in completion:
        d[i] -= 1
    for key, value in d.items():
        if value > 0:
            return key