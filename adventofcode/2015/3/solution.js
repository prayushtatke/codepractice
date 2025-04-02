const utils = require("../utils.js");
/*
----  Part 1 -------
Santa is delivering presents to an infinite two-dimensional grid of houses.
He begins by delivering a present to the house at his starting location,
and then an elf at the North Pole calls him via radio and tells him where to move next.
Moves are always exactly one house to the north (^), south (v), east (>), or west (<).
After each move, he delivers another present to the house at his new location.
However, the elf back at the north pole has had a little too much eggnog, and so his directions are a little off,
and Santa ends up visiting some houses more than once. How many houses receive at least one present?

For example:

> delivers presents to 2 houses: one at the starting location, and one to the east.
e.g. 1 -> e, Hence 2 houses
^>v< delivers presents to 4 houses in a square, including twice to the house at his starting/ending location.
e.g.
N > E
^   v
1 < S  Hence 4 houses
^v^v^v^v^v delivers a bunch of presents to some very lucky children at only 2 houses.
N
^ v^v... Hence 2 houses
1
*/

function totalHousesDelivered(input) {
    let houses = new Set();

    // Starting point co-ordinates
    let x = 0,
        y = 0;
    houses.add(`${x},${y}`);

    // traverse the input string and check if the house (its co-ordinate) is already visited.
    for (let i = 0; i < input.length; i++) {
        let direction = input[i];
        // <,>  denotes x-axis, ^,v denotes y-axis
        switch (direction) {
            case "^":
                y++;
                break;
            case "v":
                y--;
                break;
            case ">":
                x++;
                break;
            case "<":
                x--;
                break;
        }
        houses.add(`${x},${y}`);
    }
    return houses.size;
}

/*
--- Part Two ---
The next year, to speed up the process, Santa creates a robot version of himself,
Robo-Santa, to deliver presents with him. Santa and Robo-Santa start at the same location
(delivering two presents to the same starting house), then take turns moving based on instructions
from the elf, who is eggnoggedly reading from the same script as the previous year.
This year, how many houses receive at least one present?
For example:

^v delivers presents to 3 houses, because Santa goes north, and then Robo-Santa goes south.
^>v< now delivers presents to 3 houses, and Santa and Robo-Santa end up back where they started.
^v^v^v^v^v now delivers presents to 11 houses, with Santa going one direction and Robo-Santa going the other.
*/

function newCoordinates(x, y, dir) {
    [tx, ty] = [x, y];
    switch (dir) {
        case "^":
            ty++;
            break;
        case "v":
            ty--;
            break;
        case ">":
            tx++;
            break;
        case "<":
            tx--;
            break;
    }
    return [tx, ty];
}

function totalHousesDelivered2(input) {
    let houses = new Set();
    let x = 0,
        y = 0;
    let rx = 0,
        ry = 0;
    houses.add(`${x},${y}`);
    for (let i = 0; i < input.length; i++) {
        let direction = input[i];
        if (i % 2 == 0) {
            [x, y] = newCoordinates(x, y, direction);
            houses.add(`${x},${y}`);
        } else {
            [rx, ry] = newCoordinates(rx, ry, direction);
            houses.add(`${rx},${ry}`);
        }
        // console.log(
        //     `${i} ::  x, y : ${x}, ${y} | rx, ry : ${rx}, ${ry}|  houses : ${Array.from(houses).toString()}`,
        // );
    }
    return houses.size;
}

let input = utils.readInput("./part1_input.txt");
console.log("Part-1:", totalHousesDelivered(input));

input = utils.readInput("./part2_input.txt");
console.log("Part-2:", totalHousesDelivered2(input));
