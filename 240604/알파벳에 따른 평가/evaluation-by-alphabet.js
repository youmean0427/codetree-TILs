const fs = require("fs");
let n = fs.readFileSync(0).toString().trim();

let ans = "Failure"
if (n === "S") {
    ans = "Superior"
} else if (n === "A") {
    ans = "Excellent"
} else if (n === "B") {
    ans = "Good"
} else if (n === "C") {
    ans = "Usually"
} else if (n === "D") {
    ans = "Effort"
}

console.log(ans)