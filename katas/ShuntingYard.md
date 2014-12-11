https://drive.google.com/file/d/0B1zkMug0gEjUMlFmTDhTMEljZ0k/view?pli=1

[Shunting Yard algorithm](http://en.wikipedia.org/wiki/Shunting-yard_algorithm)

Convert "normal math" infix notation into [reverse polish notation](http://en.wikipedia.org/wiki/Reverse_Polish_notation).

## Reverse Polish Notation

Operators go at the end.
No parentheses; (they become "operators")


Convert: `4 * ( 3 + 2 ) - 1`

* Move 4 over
* Push * onto the stack
* Push ( to stack like an operator
* Move 3 over
* Push + onto the stack
* Instead of pushing ) onto the stack; pop the stack
* Discard the parentheses
* ...


Result: `4 3 2 * + 1 -`

Then if you work backwards through the array, you can get:

Subtract(1, Add(Multiply(2,3), 4));


## Tips:

Create a method that:
* Accepts a string param
* Returns a Queue or Array

