arr = [[0,5,2,4,1],[5,0,3,9,6],[2,3,0,6,3],[4,9,6,0,3],[1,6,3,3,0]]

max_value = 0
order = []
result = []
start_idx = 0
for i, a in enumerate(arr):
    for value in a:
        if max_value < value:
            max_value = value
            start_idx = i

dic = {i: a for i, a in enumerate(arr[start_idx])}
dic = sorted(dic.items(), key=lambda x: x[1])
order = [d[0] for d in dic]
result.append(order)
result.append(list(reversed(order)))
print(result)



