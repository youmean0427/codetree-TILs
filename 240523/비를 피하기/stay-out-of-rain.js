const fs = require('fs')
const input = fs.readFileSync(0).toString().trim().split('\n')

const [n, h, m] = input[0].split(" ").map(x => parseInt(x))
const arr = input.slice(1, n+1).map(x => x.split(" ").map(x => parseInt(x)))

const people = []

for (let i = 0; i < n; i++) {
    for (let j =0; j < n; j++) {
        if (arr[i][j] === 2) {
            people.push([i, j])
        }
    }
}

dir = [[0, 1], [1, 0], [-1, 0], [0, -1]]
ans = Array.from(new Array(n), () => Array(n).fill(0))
function bfs(sn, sm) {
    q = [[sn, sm]]
    let visited = Array.from(new Array(n), () => Array(n).fill(0))
    visited[sn][sm] = 1
    while (q.length) {
        const [x, y] = q.shift()

        if (arr[x][y] === 3) {
            ans[sn][sm] = visited[x][y] - 1 
            return 
        }

        dir.forEach(d => {
            xd = x + d[0];
            yd = y + d[1];

            if (0 <= xd && xd < n && 0 <= yd && yd < n) {
                if (visited[xd][yd] === 0) {
                    if (arr[xd][yd] !== 1) {
                            visited[xd][yd] = visited[x][y] + 1
                            q.push([xd, yd])
                        }
                    }
                }
        })
    }
    ans[sn][sm] = -1
    return
}

people.forEach(x => {
    bfs(x[0], x[1])
})
ans.forEach(x => {
    console.log(...x)
})