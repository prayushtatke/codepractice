
# Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers.
# Then print the respective minimum and maximum values as a single line of two space-separated long integers.
# For example, [1, 3, 5, 7, 9]. Our minimum sum is (1+3+5+7)=16 and our maximum sum is (3+5+7+9)=24.

def miniMaxSum(arr):
    arr = sorted(arr)
    print(arr)
    print(arr[:4])
    print(arr[-4:])
    mn = sum(arr[:4])
    mx = sum(arr[-4:])
    print('{} {}'.format(mn, mx))

if __name__ == '__main__':
    arr = list(map(int, input().rstrip().split()))

    miniMaxSum(arr)
