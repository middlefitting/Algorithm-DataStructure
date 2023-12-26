# 보라색: 380nm 이상 425nm 미만
N = int(input())
if 620 <= N <= 780:
    print("Red")
if 590 <= N < 620:
    print("Orange")
if 570 <= N < 590:
    print("Yellow")
if 495 <= N < 570:
    print("Green")
if 450 <= N < 495:
    print("Blue")
if 425 <= N < 450:
    print("Indigo")
if 380 <= N < 425:
    print("Violet")
