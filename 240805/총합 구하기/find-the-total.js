const fs = require('fs')
const input = fs.readFileSync(0).toString().trim().split(" ").map(x => Number(x))

const [a, b] = input
let ans = 0
for (let i = a; i <= b; i++) {
    if (i % 6 == 0 && i % 8 != 0) {
        ans += i
    }
}

console.log(ans)