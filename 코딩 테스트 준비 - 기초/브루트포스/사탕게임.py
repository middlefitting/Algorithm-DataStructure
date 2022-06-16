def find_same(arr) :
  answer = 0
  count = 1
  for i in range(T) :
    count = 1
    for j in range(T - 1) :
      if (arr[i][j] == arr[i][j + 1]) :
        count += 1
        if (count > answer) :
          answer = count
      else :
        if (count > answer) :
          answer = count
        count = 1

  count = 1
  for i in range(T) :
    count = 1
    for j in range(T - 1) :
      if (arr[j][i] == arr[j + 1][i]) :
        count += 1
        if (count > answer) :
          answer = count
      else :
        if (count > answer) :
          answer = count
        count = 1
  return (answer)

def find_candy(arr) :
  answer = 0
  for i in range(T) :
    for j in range (T - 1) :
      if (arr[i][j] != arr[i][j + 1]) :
        temp = arr[i][j]
        arr[i][j] = arr[i][j + 1]
        arr[i][j + 1] = temp
        max = find_same(arr)
        if (max > answer) :
          answer = max
        temp = arr[i][j]
        arr[i][j] = arr[i][j + 1]
        arr[i][j + 1] = temp

      if (arr[j][i] != arr[j + 1][i]) :
        temp = arr[j][i]
        arr[j][i] = arr[j + 1][i]
        arr[j + 1][i] = temp
        max = find_same(arr)
        if (max > answer) :
          answer = max
        temp = arr[j][i]
        arr[j][i] = arr[j + 1][i]
        arr[j + 1][i] = temp
  return (answer)  

T = int(input())
arr = list()

for i in range(T) :
  arr_now = list()
  str_input = str(input())
  for j in range(T) :
    arr_now.append(str_input[j])
  arr.append(arr_now)

print(find_candy(arr))