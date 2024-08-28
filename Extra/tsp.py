n = int(input('Enter number of cities: '))
set1 = set(range(n))
adj = []
print('Enter costs of travelling: ')
for p in range(n):
    m = list(map(int, input().strip().split()))
    adj.append(m)

source = int(input('Enter source: '))


def g(i, s):
    list1 = []
    if len(s) == 0:
        print('['+str(adj[i][source])+']')
        return adj[i][source]
    else:
        s = s-{i}
        print(s)
        for k in s:
            print(k)
            list1.append(adj[i][k] + g(k, s-{k}))
            print(list1)
        return min(list1)


result = g(0, set1)
print(result)
