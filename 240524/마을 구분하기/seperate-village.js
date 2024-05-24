const fs = require('fs')
const input = fs.readFileSync(0).toString().trim().split("\n")

const n = parseInt(input[0])
const arr = input.slice(1, n+1).map(x => x.split(" ").map(x => parseInt(x)))
const visited = Array.from(Array(n), () => Array(n).fill(0))

const ans = []
dir = [[0, 1], [1, 0], [-1, 0], [0, -1]]
function dfs(sn, sm) {
    stack = [[sn, sm]]
    visited[sn][sm] = 1
    cnt = 1
    while (stack.length) {
        const [x, y] = stack.pop()

        for (let i = 0; i < dir.length; i++) {
            xd = x + dir[i][0]
            yd = y + dir[i][1]

            if ( 0 <= xd && xd < n && 0 <= yd && yd < n) {
                if (arr[xd][yd] == 1 && visited[xd][yd] == 0) {
                    visited[xd][yd] = visited[x][y] + 1
                    stack.push([xd, yd])
                    cnt += 1
                }
            }

        }
    }
    ans.push(cnt)
}

for (let i = 0; i < n; i++ ){
    for (let j = 0; j < n; j++ ) {
        if (arr[i][j] && visited[i][j] == 0) {
            dfs(i, j)
        }
    } 
}
console.log(ans.length)
ans.sort((a, b) => a - b)
ans.forEach(x => console.log(x))