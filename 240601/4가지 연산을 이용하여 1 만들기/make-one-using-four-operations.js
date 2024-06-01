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

    pop() {
        if (this.empty()) {
            throw new Error("Empty")
        }
        return this.q[++this.front]
    }
}


const fs = require('fs')
let input = fs.readFileSync(0).toString().trim()
input = parseInt(input)


visited = new Array(2*input).fill(Infinity)

function bfs(n) {
    q = new Queue
    q.push([n, 0])
    while (!q.empty()) {
        let [x, y] = q.pop()
    
        if (x === 1) {
            return
        }
        if (visited[x-1] > y+1) {
            visited[x-1] = y+1
            q.push([x-1, y+1])
        }

        if (visited[x+1] > y+1) {
            visited[x+1] = y+1
            q.push([x+1, y+1])
        }

        if (x % 2 === 0) {
            if (visited[parseInt(x/2)] > y+1) {
            visited[parseInt(x/2)] = y+1
            q.push([parseInt(x/2), y+1])
            }
        }

        if (x % 3 === 0) {
            if (visited[parseInt(x/3)] > y+1) {
            visited[parseInt(x/3)] = y+1
            q.push([parseInt(x/3), y+1])
            }
        }
    }
}

if (input === 1) {
    console.log(0)
} else {
    bfs(input)
    console.log(visited[1])
}