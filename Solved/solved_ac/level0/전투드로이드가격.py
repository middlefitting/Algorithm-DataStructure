price = [350.34, 230.90, 190.55, 125.30, 180.90]
for _ in range(int(input())):
    arr = list(map(float, input().split()))
    answer = 0.0
    for i in range(5):
        answer += price[i] * arr[i]
    print("${:.2f}".format(answer))