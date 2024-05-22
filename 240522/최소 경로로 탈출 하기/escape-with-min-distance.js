class Queue {
    
    constructor() {
        this.q = []
        this.front = -1
        this.tail = -1
    }

    push(item) {
        this.q.push(item)
        this.tail++
    }

    empty() {
        return this.front === this.tail
    }

    pop() {
        if (this.empty()) {
            throw new Error("empty")
        }
        return this.q[++this.front]
    }

    size() {
        return this.tail - this.front
    }
}

const fs = require('fs')
const input = fs.readFileSync(0).toString().trim().split('\n')

const [n, m] = input[0].split(" ").map(Number)
const arr = input.slice(1, n+1).map(x => x.split(" ").map(Number))
const visited = Array.from(new Array(n), () => Array(m).fill(0))

dir = [[0, 1], [1, 0], [0, -1], [-1, 0]]
function bfs() {
    q = new Queue
    q.push([0, 0])
    visited[0][0] = 1

    while (q.size() > 0) {
        const [x, y] = q.pop()

        dir.forEach(d => {
            xd = d[0] + x
            yd = d[1] + y

            if (0 <= xd && xd < n && 0 <= yd && yd < m) {
                if (arr[xd][yd] == 1 && visited[xd][yd] == 0) {
                    visited[xd][yd] = visited[x][y] + 1
                    q.push([xd, yd])
                }
            }
        })
    }
}

bfs()

ans = visited[n-1][m-1]
if (ans) {
    console.log(ans-1)
} else {
    console.log(-1)
}