class Queue {
    constructor() {
        this.q = []
        this.front = -1
        this.back = -1
    }

    push(item) {
        this.q.push(item)
        this.back++
    }

    empty() {
        return this.front === this.back
    }

    size() {
        return this.back - this.front
    }

    pop() {
        if (this.empty()) {
            throw new Error("empty")
        }
        return this.q[++this.front]
    }
}

const fs = require('fs')
const input = fs.readFileSync(0).toString().trim().split('\n')

const n = parseInt(input[0])
const [r1, c1, r2, c2] = input[1].split(" ").map(Number)
const visited = Array.from(new Array(n), () => Array(n).fill(-1))
let q = new Queue()

q.push([r1-1, c1-1])
visited[r1-1][c1-1] = 0

dir = [[-2, 1], [-1, 2], [1, 2], [2, 1], [2, -1], [1, -2], [-1, -2], [-2, -1]]

function bfs() {

    while (!q.empty()) {
        const [x, y] = q.pop()

        if ([x, y] === [r2-1, c2-1]) {
            return
        }
        
        for (i = 0; i < dir.length; i++) {
            xd = x + dir[i][0]
            yd = y + dir[i][1]

            if ( 0 <= xd && xd < n && 0 <= yd && yd < n) {
                if (visited[xd][yd] === -1) {
                    visited[xd][yd] = visited[x][y] + 1
                    q.push([xd, yd])
                }
            }
        }
    }

}

bfs()
console.log(visited[r2-1][c2-1])