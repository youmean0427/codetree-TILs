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

    size() {
        return this.tail - this.front
    }

    pop() {
        if (this.tail === this.front) {
            throw new Error("empty")
        }
        return this.q[++this.front]
    }

}



const fs = require('fs')
const input = fs.readFileSync(0).toString().trim().split("\n")

const [n, m] = input[0].split(" ").map(Number)
const arr = input.slice(1, n+1).map(x => x.split(" ").map(Number))


function isRange(x, y) {
    return 0 <= x && x < n && 0 <= y && y < m
}

function bfs() {
    q = new Queue()
    q.push([0, 0])
    let cnt = 0
    visited = Array.from(Array(n), () => Array(m).fill(0))
    while(q.size() > 0) {
        let [x, y] = q.pop()

        for ([dx, dy] of [[0, 1], [1, 0], [0, -1], [-1, 0]]) {
            dxx = dx + x
            dyy = dy + y

            if (isRange(dxx, dyy)) {
                if (visited[dxx][dyy] === 0 && arr[dxx][dyy] === 0) {
                    visited[dxx][dyy] = 1
                    q.push([dxx, dyy])
                }
                else if (visited[dxx][dyy] === 0  && arr[dxx][dyy] === 1) {
                    visited[dxx][dyy] = 1
                    arr[dxx][dyy] = 0
                    cnt += 1
                }
            }
        }
    }
    return cnt
}

time = 0
ans = 0
while (true) {
    cnt = bfs()
    if (cnt === 0) {
        break
    }
    ans = cnt
    time++
}
console.log(time, ans)