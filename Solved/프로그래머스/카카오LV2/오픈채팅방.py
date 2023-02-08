def solution(record):
    answer = []
    username = dict()
    for i in record:
        temp = list(map(str, i.split()))
        if temp[0] == "Enter" or temp[0] == "Change":
            username[temp[1]] = temp[2]
    for i in record:
        temp = list(map(str, i.split()))
        if temp[0] == "Enter":
            answer.append(username.get(temp[1]) + "님이 들어왔습니다.")
        if temp[0] == "Leave":
            answer.append(username.get(temp[1]) + "님이 나갔습니다.")
    return answer

print(solution(["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]))