const fs = require("fs");

function read_input_file(file_path) {
    try {
        const data = fs.readFileSync(file_path, "utf8");
        return data;
    } catch (err) {
        console.error("Error reading file:", err);
    }
}

module.exports = {
    read_input_file,
};
