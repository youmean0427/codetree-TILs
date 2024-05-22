const fs = require('fs')
const input = fs.readFileSync(0).toString().trim().split('\n')

const n = parseInt(input[0])
const arr = input.splice(1, n+1).map(x => x.split(" ").map(Number))
const dp = Array.from(new Array(n), () => Array(n).fill(0))

dp[0][0] = arr[0][0]

for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
        let right = 0
        let down = 0
        if (0 <= j-1 && j-1 < n) { 
            right = dp[i][j-1] + arr[i][j]
        }
        if (0 <= i-1 && i-1 < n) {
            down = dp[i-1][j] + arr[i][j]
        }

        dp[i][j] = Math.max(dp[i][j], right, down)
    }
}

console.log(dp[n-1][n-1])