const fs = require('fs')
const input = fs.readFileSync(0).toString().trim().split("\n")

const n = parseInt(input[0])
const arr = input.slice(1, n+1).map(x => x.split(" ").map(x => parseInt(x)))

const visited = Array.from(Array(n), () => Array(n).fill(0))

let bomb = 0
let maxBlock = 0
dir = [[1, 0], [0, 1], [-1, 0], [0, -1]]

function isRange(r, c) {
    return 0 <= r && r < n && 0 <= c && c < n
}

function dfs(sn, sm) {
    
    stack = [[sn, sm]]
    visited[sn][sm] = arr[sn][sm]
    cnt = 1
    while(stack.length) {
        const [x, y] = stack.pop()

        for (let d = 0; d < dir.length; d++) {
            xd = x + dir[d][0]
            yd = y + dir[d][1]

            if (isRange(xd, yd)) {
                if (visited[xd][yd] === 0 && arr[x][y] === arr[xd][yd]) {
                    visited[xd][yd] = arr[x][y]
                    stack.push([xd, yd])
                    cnt += 1
                }
            }
        }
    }
    maxBlock = Math.max(maxBlock, cnt)
    if (cnt >= 4) {
        bomb += 1
    }
}

for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
        dfs(i, j)
    }
}

console.log(bomb, maxBlock)