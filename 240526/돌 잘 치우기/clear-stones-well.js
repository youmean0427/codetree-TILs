const fs = require('fs')
const input = fs.readFileSync(0).toString().trim().split("\n")

const [n, k, m] = input[0].split(" ").map(x => parseInt(x))
const arr = input.slice(1, n+1).map(x => x.split(" ").map(x => parseInt(x)))
const start = [] 
let ans = 0

for (let i = 0; i < k; i++) {
    start.push(input[n+i+1].split(" ").map(x => parseInt(x)-1))
}

const wall = []
for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
        if (arr[i][j]) {
            wall.push([i, j])   
        }
    }
}

function newArr(){
    const newarr = Array.from(Array(n), () => Array(n).fill(0))
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {
            newarr[i][j] = arr[i][j]
        }
    }
    return newarr 
}

function bfs(barr) {
    q = [...start]
    visited = Array.from(Array(n), () => Array(n).fill(0))
    dir = [[0, 1], [1, 0], [0, -1], [-1, 0]]
    while (q.length) {
        const [x, y] = q.shift()
        visited[x][y] = 1

        for (let d = 0; d < dir.length; d++) {
            xd = x + dir[d][0]
            yd = y + dir[d][1]

            if ( 0 <= xd && xd < n && 0 <= yd && yd < n) {
                if (visited[xd][yd] === 0 && barr[xd][yd] === 0) {
                    visited[xd][yd] = 1
                    q.push([xd, yd])
                }
            }
        }
    }
    return visited

}

function check(carr) {
    total = 0
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {
            if (carr[i][j]) {
                total += 1
            }
        }
    }
    return total
}

function dfs(cnt, sm, ii) {

    if (cnt >= m) {
        
        const newarr = newArr()

        sm.forEach(x => {
            newarr[x[0]][x[1]] = 0
        })
        res = check(bfs(newarr))
        ans = Math.max(res, ans)
        return
    }
    
    for (let i = ii; i < wall.length; i++) {
        sm.push(wall[i])
        dfs(cnt+1, sm, i+1)
        sm.pop()
    }
    
}

dfs(0, [], 0)
console.log(ans)