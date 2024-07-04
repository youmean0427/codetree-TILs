const fs = require('fs')
const input = fs.readFileSync(0).toString().trim().split("\n")

const n = Number(input[0])
const arr1 = [0].concat(input[1].split(" ").map(x => parseInt(x)))
const arr2 = [0].concat(input[2].split(" ").map(x => parseInt(x)))

const dp = Array.from({length: 2}, () => Array(n+1).fill(0))

if (arr1[0] > arr2[0]) {
    dp[0][0] = arr1[0]
} else if (arr2[0] > arr1[0]) {
    dp[1][0] = arr2[0]
}

for (let j = 1; j < n+1; j++) {

    for (let l = 0; l < n+1; l++) {
        
        if (arr1[j] < arr2[l]) {
            dp[0][j] = Math.max(dp[0][j], dp[0][j-1] + arr1[j], dp[0][j-1])

        }
    }

    for (let l = 0; l < n+1; l ++ ){
        if (arr2[j] < arr1[l]) {
            dp[1][j] = Math.max(dp[1][j], dp[1][j-1] + arr2[j], dp[1][j-1])
        }
    }

}


console.log(Math.max(...dp[1]))