const fs = require('fs')
const input = fs.readFileSync(0).toString().trim().split("\n")

const [n, m] = input[0].split(" ").map(x => parseInt(x))
const arr = input.slice(1, n+1).map(x => x.split(" ").map(x => parseInt(x)))

function find_max(arr) {
    let m = 0
    arr.forEach(x => {
        m =  Math.max(m, Math.max(...x))
    })
    return m
}


function dfs(sn, sm, cnt){
   

    stack = [[sn, sm]]
    visited[sn][sm] = cnt
    dir = [[0, 1], [1, 0], [-1, 0], [0, -1]]
    while (stack.length) {
        const [x, y] = stack.pop()

        for (let d = 0; d < dir.length; d++) {
            xd = x + dir[d][0]
            yd = y + dir[d][1]
            if ( 0 <= xd && xd < n && 0 <= yd && yd < m) {
            if (visited[xd][yd] === 0) {
                visited[xd][yd] = cnt
                stack.push([xd, yd])
            }}

        }
    }
}
ans = []
for (let k = 1; k < find_max(arr)+1; k++) {
    visited = Array.from(Array(n), () => Array(m).fill(0))
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < m; j++) {
            if (arr[i][j] <= k) {
                visited[i][j] = -1
            }
        }
    }
    cnt = 1
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < m; j++) {
            if (visited[i][j] === 0) {
                dfs(i, j, cnt)
                cnt += 1
            }
        }
    }
    ans.push([k, cnt-1])
}

ans.sort((a, b) => a[0] - b[0])
ans.sort((a, b) => b[1] - a[1])
console.log(...ans[0])