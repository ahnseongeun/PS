n = int(input())
for i in range(n):
    string = input()
    start = string[0]
    end = string[len(string) - 1]
    print(start + end)