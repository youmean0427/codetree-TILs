class Queue {
    constructor() {
        this.q = [];
        this.head = -1;
        this.tail = -1;
    }

    push(item) {
        this.q.push(item)
        this.tail++
    }

    empty() {
        return this.head === this.tail
    }
    
    size() {
        return this.tail - this.head
    }

    pop() {
        if (this.empty()) {
            throw new Error("empty")
        }
        return this.q[++this.head]
    }

    front() {
        if (this.empty()) {
            throw new Error("empty")
        }
        return this.q[this.head+1]
    }
}

const fs = require('fs')
const input = fs.readFileSync(0).toString().trim().split('\n')

const [n, k] = input[0].split(" ").map(Number)
const arr = input.slice(1, n+1).map(x => x.split(' ').map(x => parseInt(x)))
const visited = Array.from(new Array(n), () => Array(n).fill(0))
const q = new Queue()


for (i = n+1; i < input.length; i++) {
    const [a, b] = input[i].split(" ").map(Number)
    q.push([a-1, b-1])
    visited[a-1][b-1] = 1
}


dir = [[0, 1], [1, 0], [-1, 0], [0, -1]]
function bfs() {

    while (q.size() > 0) {
        let[x, y] = q.pop()
        
        dir.forEach(d => {
            dx = d[0] + x
            dy = d[1] + y

            if (0 <= dx && 0 <= dy && dx < n && dy < n) {
                if (visited[dx][dy] == 0 && arr[dx][dy] == 0) {
                    visited[dx][dy] = 1
                    q.push([dx, dy])
                }
            }
        })
    }
}

bfs()
ans = 0
for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
        if (visited[i][j]) {
            ans++
        }
    }
}
console.log(ans)