n = int(input())

for i in range(n):
    str1, str2 = input().split()
    sorted_str1 = sorted(list(str1))
    sorted_str2 = sorted(list(str2))
    if sorted_str1 == sorted_str2:
        print("%s & %s are anagrams." %(str1, str2))
    else:
        print("%s & %s are NOT anagrams." %(str1, str2))