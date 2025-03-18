const fs = require("fs");

function readInput(file_path) {
    try {
        const data = fs.readFileSync(file_path, "utf8");
        return data;
    } catch (err) {
        console.error("Error reading file:", err);
    }
}

module.exports = {
    readInput,
};
