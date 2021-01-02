def bubblesortV1(list, length): #VERSION NUMBER !
    swaps = 0
    compares = 0

    for i in range(0, length - 1):
        for j in range(0, length - i - 1):
            # if value at j is > value at j+1
            compares += 1 #increment counter

            if (list[j] > list[j + 1]):
                swaps += 1 #increment counter
                # swap values at j and j+1
                temp = list[j]
                list[j] = list[j + 1]
                list[j + 1] = temp

    print ("sorted list: ", list)
    print ("swaps: ", swaps)
    print ("compares: ", compares)


def bubblesortV2(list, length): #VERSION NUMBER 2
    swaps = 0
    compares = 0
    sorted = False

    while (not sorted):
        sorted = True
        for i in range(0, length - 1):
            # if value at i is > value at i+1
            compares += 1
            if (list[i] > list[i + 1]):
                # swap values at i and i+1
                swaps += 1 #inc swap counter
                temp = list[i]
                list[i] = list[i + 1]
                list[i + 1] = temp
                # need to set sorted back to false to ensure
                # the while loop is repeated again
                # to ensure the list is sorted
                sorted = False

    print ("sorted list: ", list)
    print ("swaps: ", swaps)
    print ("compares: ", compares)

# ---------- "MAIN METHOD" -------------

# calling bubblesort version1:
#list_mt = []
#bubblesortV1(list_mt, 0)

list_unsorted = [1,2,3,4,5]
bubblesortV1(list_unsorted, 5)

print("\nbubblesort version2 ")
# calling bubblesort version2:
#list_mt = []
#bubblesortV2(list_mt, 0)

list_unsorted = [3,2,1]
bubblesortV2(list_unsorted, 3)
