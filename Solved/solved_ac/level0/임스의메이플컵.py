A, B, C = map(int, input().split())
if A >= 1000:
    if B >= 8000 or C >= 260:
        print("Very Good")
    else:
        print("Good")
else:
    print("Bad")
