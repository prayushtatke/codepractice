/*
PART 1
Santa is trying to deliver presents in a large apartment building,
but he can't find the right floor - the directions he got are a little confusing.
He starts on the ground floor (floor 0) and then follows the instructions one character at a time.
An opening parenthesis, (, means he should go up one floor, and a closing parenthesis, ), means he should go down one floor.
The apartment building is very tall, and the basement is very deep; he will never find the top or bottom floors.

For example:

(()) and ()() both result in floor 0.
((( and (()(()( both result in floor 3.
))((((( also results in floor 3.
()) and ))( both result in floor -1 (the first basement level).
))) and )())()) both result in floor -3.
To what floor do the instructions take Santa?
*/
const utils = require("../utils.js");

function floorMovement(input) {
    if (input == "(") {
        return 1;
    }
    if (input == ")") {
        return -1;
    }
    return 0;
}

function findFinalFloor(input) {
    // read each character of the input
    // initialize a variable floor to 0
    /*
    let floor = 0;
    for (let i = 0; i < input.length; i++) {
        floor += floorMovement(input[i]);
    }
    return floor;
    */
    return input
        .split("")
        .map(floorMovement)
        .reduce((acc, curr) => acc + curr);
}

/*
--- Part Two ---
Now, given the same instructions, find the position of the first character that causes him to enter the basement (floor -1).
The first character in the instructions has position 1, the second character has position 2, and so on.
For example:

) causes him to enter the basement at character position 1.
()()) causes him to enter the basement at character position 5.
What is the position of the character that causes Santa to first enter the basement?
*/

function findFirstCharPositionForBasement(input) {
    let floor = 0;
    for (let i = 0; i <= input.length; i++) {
        floor += floorMovement(input[i]);
        if (floor === -1) {
            return i + 1;
        }
    }
}
console.log(
    "part-1:",
    findFinalFloor(utils.read_input_file("part1_input.txt")),
);
console.log(
    "part-2:",
    findFirstCharPositionForBasement(utils.read_input_file("part1_input.txt")),
);
