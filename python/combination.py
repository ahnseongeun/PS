def combi(n,k):
    if k==0 or n==k:
        return 1
    return combi(n-1,k) + combi(n-1,k-1)

def combi2(N,K):

    DP=[[0 for _ in range(K+1)] for _ in range(N+1)]

    for i in range(N+1):
        DP[i][0] =1
    for j in range(K+1):
        DP[j][j] = 1
    for i in range(1,N+1):
        for j in range(1,K+1):
            DP[i][j] = DP[i-1][j] + DP[i-1][j-1]
    return DP[N][K]

print(combi2(4,2))