str1 = input()
str2 = input()

arr1 = [0] * 26
arr2 = [0] * 26

for i in str1:
    arr1[ord(i) - 97] += 1
for i in str2:
    arr2[ord(i) - 97] += 1
cnt = 0
for i in range(26):
    cnt += abs(arr1[i] - arr2[i])
print(cnt)









