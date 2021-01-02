import turtle

tina = turtle.Turtle()  # creating turtle object
screen=turtle.Screen()
screen.bgcolor("white")     # background color is white (of pop up screen)
tina.shape("turtle")    # turtle object looks like a turtle
tina.pencolor("blue")       # color of drawing

SCALE = 20  # size of drawing


# input: n
# output: a drawing of n concentric circles centered at 0,0
# this function is written using iteration (using a loop)
def concentric_loop(n):
    for size in range(1,n):
        tina.penup()    # pick pen to move it
        tina.goto(0, -SCALE*size)  # turtle moves down wards (x,y)- x=0 is always the center
        tina.pendown()      # pen ready to draw
        tina.circle(SCALE*size)
    
    tina.hideturtle()
    screen.exitonclick()

# input: n
# output: a drawing of n concentric circles centered at 0,0
# write concentric_recursive here...
def concentric_recursive(n):
    if n > 1:
        tina.penup()  # pick pen to move it
        tina.goto(0, -SCALE * (n-1))  # turtle moves down wards (x,y)- x=0 is always the center
        tina.pendown()  # pen ready to draw
        tina.circle(SCALE * n-20)
        concentric_recursive(n-1)





# uncomment the following one at a time
# to see the output of the concentric_loop function:
#concentric_loop(1)
#concentric_loop(5)
concentric_loop(10)


# uncomment the following one at a time
# to test your recursive function:
#concentric_recursive(1)
#concentric_recursive(5)
#concentric_recursive(10)

screen.exitonclick()



