const fs = require('fs')
let input = fs.readFileSync(0).toString().trim().split(" ").map(x => Number(x))

console.log(input[0] * input[1])