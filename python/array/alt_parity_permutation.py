def is_parity_permutation(arr : list) -> bool:
    def check_parity(n1, n2):
        if n1 == n2:
            return False

        if (n1 % 2 == 0 and n2 % 2 != 0) or (n1 % 2 != 0 and n2 % 2 == 0):
            return True

        return False

    is_parity = True
    for i in range(0, len(arr) - 1 ):
        is_parity = is_parity and check_parity(arr[i], arr[i+1])

    return is_parity


arr1 = [ 7, 2, 5, 8, 1, 6, 3, 4]
print(f"isParityPermutation: {arr1} -> {is_parity_permutation(arr1)}")

arr1 = [ 7, 2, 5, 8, 1, 9, 3, 4]
print(f"isParityPermutation: {arr1} -> {is_parity_permutation(arr1)}")