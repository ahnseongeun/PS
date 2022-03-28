n, m = map(int,input().split(":"))

def gcd(n, m):
    while(m != 0):
        temp = n % m
        n = m
        m = temp
    return n

divide = gcd(n, m)
print(str(n // divide) + ":" + str(m // divide))