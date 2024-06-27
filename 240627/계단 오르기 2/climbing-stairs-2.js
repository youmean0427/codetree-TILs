const fs = require('fs')
const input = fs.readFileSync(0).toString().trim().split("\n")

const n = parseInt(input[0])
const arr = input[1].split(" ").map(x => parseInt(x))

const dp = Array.from({length: n}, () => Array(n).fill(-Infinity))

dp[0][1] = arr[0]
dp[1][1] = arr[1]
dp[1][2] = arr[0] + arr[1]

for (let i = 2; i < n; i++) {
    for (let j = 1; j < n; j++) {
        if (i === 2) {
            if (j <= 3) {
            dp[i][j] = Math.max(arr[i] + dp[i-1][j-1], arr[i] + dp[i-2][j-1])
            }
        }
        else {
            if (i % 2 === 0) {
                if (j < i) {
                    dp[i][j] = Math.max(arr[i] + dp[i-1][j-1], arr[i] + dp[i-2][j-1])
                }
            }
            else {
                if (j <= i){
                    dp[i][j] = Math.max(arr[i] + dp[i-1][j-1], arr[i] + dp[i-2][j-1])
                }   
            }  
        }
    }
}
console.log(Math.max(...dp[n-1]))