"""
Program to arrange the given array that all even numbers comes
before the odd numbers.

(No Sorting required)
"""
def arrange_even_odd(arr: list):

    lindx, rindx = 0, -1

    while lindx < rindx + len(arr):
        while lindx < len(arr) and arr[lindx] % 2 == 0:
            lindx = lindx + 1

        while abs(rindx) < len(arr) and arr[rindx] % 2 != 0:
            rindx = rindx - 1

        # Swap
        arr[lindx], arr[rindx] = arr[rindx], arr[lindx]
        lindx = lindx + 1
        rindx = rindx - 1


arr = [11, 3, 13, 15, 4, 5, 2, 6]
print(f'Before : {arr}')
arrange_even_odd(arr)
print(f'After : {arr}')