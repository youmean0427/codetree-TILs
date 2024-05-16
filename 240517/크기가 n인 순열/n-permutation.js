const fs = require('fs')
const input = fs.readFileSync('/dev/stdin').toString().trim()
const N = parseInt(input)
let visited = Array(N+1).fill(0)

function backtracking(cnt, sm) {

    if (cnt >= N) {
        console.log(...sm)
        return
    }

    for (let i = 1; i <= N; i++) {
        if (visited[i] === 0) {
            visited[i] = 1
            sm.push(i)
            backtracking(cnt+1, sm)
            sm.pop()
            visited[i] = 0
        }

    }
}

backtracking(0, [])