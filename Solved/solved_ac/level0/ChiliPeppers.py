d = dict()
d["Poblano"] = 1500
d["Mirasol"] = 6000
d["Serrano"] = 15500
d["Cayenne"] = 40000
d["Thai"] = 75000
d["Habanero"] = 125000


answer = 0
for i in range(int(input())):
    temp = str(input())
    answer += d[temp]
print(answer)
