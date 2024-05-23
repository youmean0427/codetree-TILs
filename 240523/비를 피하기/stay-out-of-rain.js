const fs = require('fs')
const input = fs.readFileSync(0).toString().trim().split('\n')

const [n, h, m] = input[0].split(" ").map(x => parseInt(x))
const arr = input.slice(1, n+1).map(x => x.split(" ").map(x => parseInt(x)))

// 비를 피할 수 있는 공간(3)에서 시작해서 사람(2)를 찾는 방법
const start = []
let visited = Array.from(new Array(n), () => Array(n).fill(0))
for (let i = 0; i < n; i++) {
    for (let j =0; j < n; j++) {
        if (arr[i][j] === 3) {
            start.push([i, j])
            visited[i][j] = 1
        }
    }
}

dir = [[0, 1], [1, 0], [-1, 0], [0, -1]]
ans = Array.from(new Array(n), () => Array(n).fill(0))
function bfs() {
    q = [...start]

    while (q.length) {
        const [x, y] = q.shift()

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
}


bfs()

for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
        if (visited[i][j] && arr[i][j] === 2) {
            visited[i][j] -= 1
        }
        else if (visited[i][j] === 0 && arr[i][j] === 2) {
            visited[i][j] = -1
        }
        else if (arr[i][j] == 0 || arr[i][j] == 3) {
            visited[i][j] = 0
        }
    }
}

visited.forEach(x => {
    console.log(...x)
})