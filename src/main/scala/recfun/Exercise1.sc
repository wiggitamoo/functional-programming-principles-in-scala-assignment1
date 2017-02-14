/**********************************
   Exercise 1: Pascal’s Triangle
***********************************
The following pattern of numbers is called Pascal’s triangle.



1
2
3
4
5
6
1
1 1
1 2 1
1 3 3 1
1 4 6 4 1
...
The numbers at the edge of the triangle are all 1, and each number inside the triangle is the sum of the two numbers above it. Write a function that computes the elements of Pascal’s triangle by means of a recursive process.

Do this exercise by implementing the pascal function in Main.scala, which takes a column c and a row r, counting from 0 and returns the number at that spot in the triangle. For example, pascal(0,2)=1,pascal(1,2)=2 and pascal(1,3)=3.



1
def pascal(c: Int, r: Int): Int
*/

// numbers on the edge are 1
// each number inside the triangle are the sum of the 2 numbers above it.

// keep an index of rows and columns.
// check if a point is the first or last value in the row
// if first or last, point = 1
// else take position and sum the previous row n & n-1

def pascal(c: Int, r: Int): Int = {
  if(c == 0 || c == r) 1
  else pascal(c, r-1) + pascal(c-1, r-1)
}

pascal(0, 0)
pascal(0, 1)
pascal(1, 2)
pascal(1, 3)
pascal(2, 3)
pascal(2, 4)

val rows = 4
for(row <- 0 to rows) {
  for(col <- 0 to row)
    print(pascal(col, row) + "  ")
  println()
}