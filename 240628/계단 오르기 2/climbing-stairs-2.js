const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split("\n")

const n = parseInt(input[0])
const arr = [0].concat(input[1].split(" ").map(Number))


// i번째 동전, 1계단으로 j번 이동한 최대값
const dp = Array.from({length : n+1}, () => Array(5).fill(0))


dp[1][1] = arr[1]

dp[2][0] = arr[2]
dp[2][2] = arr[1] + arr[2]

for (let i = 3; i <= n; i++) {
    for ( let j = 0; j < 4; j ++) {
        if (dp[i-2][j] !== 0)
            dp[i][j] = Math.max(dp[i-2][j] + arr[i], dp[i][j])
        if (dp[i-1][j-1] !== 0 && j ) 
            dp[i][j] = Math.max(dp[i-1][j-1] + arr[i], dp[i][j])
    }
}

ans = 0
for (i of dp) {
    ans = Math.max(ans, Math.max(...i))
}
console.log(ans)