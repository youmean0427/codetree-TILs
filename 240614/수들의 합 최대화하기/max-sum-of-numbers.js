const fs = require('fs')
const input = fs.readFileSync(0).toString().trim().split("\n")

const n = parseInt(input[0])
const arr = input.slice(1, n+1).map(x => x.split(" ").map(x => parseInt(x)))

visited = new Array(n).fill(0)
ans = 0

function back(cnt, idx, sm) {
    
    if (cnt == n) {
        ans = Math.max(ans, sm)
        return
    }

    for (let i = 0; i < n; i++) {
        if (visited[i] === 0) {
            visited[i] = 1
            back(cnt+1,  idx+1, sm+arr[idx][i])
            visited[i] = 0
        }
    }
}


back(0, 0, 0)
console.log(ans)