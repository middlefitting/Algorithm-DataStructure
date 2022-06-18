def update_answer() :
  for i in range(x) :
    for j in range(y) :
      temp_x = i
      temp_y = j
      posible = 1
      for now in (tetro) :
        if (now[0] + temp_x >= x or now[1] + temp_y >= y) :
          posible = 0
          break
      if (posible == 1) :
        temp = 0
        for now in (tetro) :
          temp += arr[now[0] + temp_x][now[1] + temp_y]
        if (temp > answer[0]) :
          answer[0] = temp

def make_tetro(depth, x, y) :
  if (depth == 3) :
    update_answer()
  
  else :
    if(([x + 1, y] in tetro) == False) :
      tetro.append([x + 1, y])
      make_tetro(depth + 1, x + 1, y)
      make_tetro(depth + 1, x, y)
      tetro.remove([x + 1, y])

    if(([x, y + 1] in tetro) == False) :
      tetro.append([x, y + 1])
      make_tetro(depth + 1, x, y + 1)
      make_tetro(depth + 1, x, y)
      tetro.remove([x, y + 1])

    if(x - 1 >= 0 and ([x - 1, y] in tetro) == False) :
      tetro.append([x - 1, y])
      make_tetro(depth + 1, x - 1, y)
      make_tetro(depth + 1, x, y)
      tetro.remove([x - 1, y])
      
    if(y - 1 >= 0 and ([x, y - 1] in tetro) == False) :
      tetro.append([x, y - 1])
      make_tetro(depth + 1, x, y - 1)
      make_tetro(depth + 1, x, y)
      tetro.remove([x, y - 1])

answer = []
arr = []
tetro = []

answer.append(0)
x, y = map(int, input().split())

for i in range(x):
  temp = list(map(int, input().split()))
  arr.append(temp)
  
start = [[0,0], [0,1], [1,0]]
for i in (start) :
  tetro.append(i)
  make_tetro(0, i[0], i[1])
  tetro.remove(i)

print(answer[0])
