/*
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

const fs = require("fs");

function read_input_file(file_path) {
    try {
        const data = fs.readFileSync(file_path, "utf8");
        return data;
    } catch (err) {
        console.error("Error reading file:", err);
    }
}

function findFinalFloor(input) {
    // read each character of the input
    // initialize a variable floor to 0
    let floor = 0;
    for (let i = 0; i < input.length; i++) {
        if (input[i] === "(") {
            // if the character is (, increment the floor by 1
            floor += 1;
        } else if (input[i] === ")") {
            // if the character is ), decrement the floor by 1
            floor -= 1;
        }
    }
    return floor;
}

console.log(findFinalFloor(read_input_file("input.txt")));
