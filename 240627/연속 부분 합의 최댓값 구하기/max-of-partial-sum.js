const fs = require('fs')
const input = fs.readFileSync(0).toString().trim().split("\n")

const n = parseInt(input[0])
const arr = input[1].split(" ").map(x => parseInt(x))

let dp = new Array(n).fill(0)

dp[0] = arr[0]

for (let i = 1; i < n; i++) {
    dp[i] = Math.max(arr[i], arr[i] + dp[i-1])
}

console.log(Math.max(...dp))