def solution(fees, records):
    answer = []
    car = []
    park = dict()
    cost = dict()
    save_time = dict()
    for i in records:
        time, x, m = i.split()
        if m == "IN":
            try:
                car.index(x)
            except:
                car.append(x)
            h, m = time.split(":")
            h = int(h)
            m = int(m)
            park[x] = h * 60 + m
        if m == "OUT":
            h, m = time.split(":")
            h = int(h)
            m = int(m)
            out_time = h * 60 + m
            in_time = park.get(x)
            total_time = out_time - in_time
            park.pop(x)
            try:
                c = save_time.get(x)
                save_time[x] += total_time
            except:
                save_time[x] = total_time

    for x in park.keys():
        temp_cost = fees[1]
        in_time = park.get(x)
        out_time = 23 * 60 + 59
        total_time = out_time - in_time
        try:
            c = save_time.get(x)
            save_time[x] += total_time
        except:
            save_time[x] = total_time


    for x in save_time.keys():
        temp_cost = fees[1]
        total_time = save_time.get(x)
        if total_time > fees[0]:
            rest = 0
            if (total_time - fees[0]) % fees[2] != 0:
                rest = 1
            temp_cost += ((total_time - fees[0]) // fees[2] + rest) * fees[3]
        try:
            c = cost.get(x)
            cost[x] += temp_cost
        except:
            cost[x] = temp_cost

    car.sort()
    for x in car:
        answer.append(cost.get(x))

    return answer


print(solution([180, 5000, 10, 600], ["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]))
