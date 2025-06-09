const fs = require("fs");
let input = fs.readFileSync(0).toString().trim().split(" ").map(Number)

let answer = "YES";

for (let i = input[0]; i <= input[1]; i++) {
    if (i % input[2] === 0) {
        answer = "NO";
        break;
    }
}

console.log(answer);