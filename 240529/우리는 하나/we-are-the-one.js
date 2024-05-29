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

    size() {
        return this.back - this.front
    }

    pop() {
        if (this.back === this.front) {
            throw new Error ("empty")
        }
        return this.q[++this.front]
    }
}

const fs = require("fs")
let input = fs.readFileSync(0).toString().trim().split("\n")

const [n, k, u, dd] = input[0].split(" ").map(Number)
let arr = input.slice(1, n+1).map(x => x.split(" ").map(Number))

pos = []
for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
       pos.push([i, j]) 
    }
}

visited = Array(pos.length).fill(0)
select = Array()

function back(cnt, sm, next) {
    
    if (cnt >= k) {
        select.push([...sm])
        return
    }
    
    for (let i = next; i < pos.length; i++) {
        if (visited[i] === 0) {
            visited[i] = 1
            sm.push(pos[i])
            back(cnt+1, sm, i)
            sm.pop()
            visited[i] = 0
        }
    }
}

back(0, [], 0)

function bfs(pos) {

    q = new Queue
    pos.forEach(x => q.push(x))
    const dir = [[0, 1], [1, 0], [-1, 0], [0, -1]]
    while (q.size() > 0) {
        let [x, y] = q.pop()
        visited[x][y] = 1
        dir.forEach(d => {
            let dx = x + d[0]
            let dy = y + d[1]

            if (0 <= dx && dx < n && 0 <= dy && dy < n) {
                if (visited[dx][dy] === 0 ) {
                    if (u <= Math.abs(arr[x][y] - arr[dx][dy]) && Math.abs(arr[x][y] - arr[dx][dy]) <= dd) {
                        visited[dx][dy] = 1
                        q.push([dx, dy])
                    }
                }
            }
        })
    }
}

function sum(arr) {
    total = 0
    for (i of arr) {
        total += i.reduce((a, b) => a += b)
    }
    return total
}

ans = 0
select.forEach(sa => {
    visited = Array.from(Array(n), () => Array(n).fill(0))
    bfs(sa)
    ans = Math.max(ans, sum(visited))
})
console.log(ans)