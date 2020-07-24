
# Given a list of unsorted integers, arr ,
# find the pair of elements that have the smallest absolute difference between them.
# If there are multiple pairs, find them all.
# e.g.
# arr = [-5 15 25 71 63],
# Output = 63 71
#

import math


# Complete the closestNumbers function below.
def closestNumbers(arr):
    arr =  sorted(arr)
    # min = arr[1] - arr[0]
    cn = []

    mn = min([arr[i + 1] - arr[i] for i in range(len(arr) - 1)])
    print('curmin:' + str(mn))
    for i in range(len(arr) - 1):
        if arr[i + 1] - arr[i] == mn:
            cn.append(arr[i])
            cn.append(arr[i+1])

    return cn



arr = [-5, 15, 25, 71, 63]
result = closestNumbers(arr)
print(' '.join(map(str, result)))
