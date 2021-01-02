from random import *

# random number b/w 1 and 100
comp_num = randint(1, 100)

# getting user input
while True:  # # test (check format) and get user input again
    try:
        guess = int(input("Enter an integer input between 1-100 : "))
        break
    except ValueError:
        print("Error!  That was not a valid INTEGER number.  Try again...")

while guess < 1 or guess > 100:  # input in range check
    while True:  # # test (check format) and get user input again
        try:
            guess = int(input("Error! input out of bound, Enter an integer input between 1-100 :"))
            break
        except ValueError:
            print("Error!  That was not a valid INTEGER number.  Try again...")

while comp_num != guess:  # Keep Looping if random comp_num not found

    if guess > comp_num:  # If guess is higer than the random comp_num
        print("Too high! Guess again")
        # check hotness/coldness
        if comp_num-2 <= guess <= comp_num+2:
            print("YOUR SO HOT!!!...")
        elif comp_num - 5 <= guess <= comp_num + 5:
            print("getting even EVEN EVEN! hotter...")
        elif comp_num - 9 <= guess <= comp_num + 9:
            print("getting even EVEN hotter...")
        elif comp_num - 16 <= guess <= comp_num + 16:
            print("getting even hotter...")
        elif comp_num - 25 <= guess <= comp_num + 25:
            print("getting hot...")
        elif comp_num - 35 <= guess <= comp_num + 35:
            print("still a bit cold...")
        elif comp_num-45 <= guess <= comp_num+45:
            print("cold...")
        elif comp_num - 60 <= guess <= comp_num + 60:
            print("Super Cold")
        else:
            print("Your waaaay too cold!!....")

        while True:  # test (check format) and get user input again
            try:
                guess = int(input("Enter an integer input between 1-100 : "))
                break
            except ValueError:
                print("Error!  That was not a valid INTEGER number.  Try again...")

    elif guess < comp_num:  # If guess is lower than the random comp_num
        print("Too low! Guess again")

        # check hotness/coldness
        if comp_num-2 <= guess <= comp_num+2:
            print("YOUR SO HOT!!!...")
        elif comp_num - 5 <= guess <= comp_num + 5:
            print("getting even EVEN EVEN! hotter...")
        elif comp_num - 9 <= guess <= comp_num + 9:
            print("getting even EVEN hotter...")
        elif comp_num - 16 <= guess <= comp_num + 16:
            print("getting even hotter...")
        elif comp_num - 25 <= guess <= comp_num + 25:
            print("getting hot...")
        elif comp_num - 35 <= guess <= comp_num + 35:
            print("still a bit cold...")
        elif comp_num-45 <= guess <= comp_num+45:
            print("cold...")
        elif comp_num - 60 <= guess <= comp_num + 60:
            print("Super Cold")
        else:
            print("Your waaaay too cold!!....")

        while True:  # # test (check format) and get user input again
            try:
                guess = int(input("Enter an integer input between 1-100 : "))
                break
            except ValueError:
                print("Error!  That was not a valid INTEGER number.  Try again...")

# If guess IS INFACT the random comp_num!!!
print("Congrats! the answer was infact '%d' well done!" % comp_num)