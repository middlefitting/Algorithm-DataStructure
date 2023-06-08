dal = 0
phy = 0
for i in range(int(input())):
    if str(input()) == "D":
        dal += 1
    else:
        phy += 1
    if abs(dal - phy) >= 2:
        break
print(dal, end="")
print(":", end="")
print(phy)