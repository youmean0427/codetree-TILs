const fs = require('fs')
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n')

const [n, m] = input[0].split(" ").map(x => parseInt(x))
const arr = []
for (i = 1; i < input.length; i++) {
    x = input[i].split(" ").map(x => parseInt(x))
    arr.push(x)
}

let visited = Array.from({length : n}, () => Array(m).fill(0))
const dir = [[0, 1], [1, 0], [0, -1], [-1, 0]]

function bfs() {

    q = [[0, 0]]

    while (q.length) {
        const [x, y] = q.shift()
        
        dir.forEach((d) => {
            xd = x + d[0]
            yd = y + d[1]

            if (0 <= xd && xd < n && 0 <= yd && yd < m) {
                if (arr[xd][yd] && visited[xd][yd] == 0) {
                    visited[xd][yd] = 1
                    q.push([xd, yd])
                }
            }
        })
    }
}

bfs()
if (visited[n-1][m-1]) {
    console.log(1)
} else {
    console.log(0)
}