arr = [0] * 5
for i in range(int(input())):
    x, y = map(int, input().split())
    if x * y == 0:
        arr[0] += 1
    elif x > 0 and y > 0:
        arr[1] += 1
    elif x < 0 and y > 0:
        arr[2] += 1
    elif x < 0 and y < 0:
        arr[3] += 1
    else:
        arr[4] += 1
for i in range(1, 5):
    print(f"Q{i}:", arr[i])
print("AXIS:", arr[0])
