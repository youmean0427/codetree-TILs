const fs = require('fs')
const input = fs.readFileSync(0).toString().trim().split("\n")

let [n, k] = input[0].split(" ").map(x => parseInt(x))
const arr = input.slice(1, n+1).map(x => x.split(" ").map(x => parseInt(x)))
let [r, c] = input[input.length-1].split(" ").map(x => parseInt(x))
r -= 1
c -= 1

function bfs(sn, sm) {
    
    q = [[sn, sm]]
    dir = [[0, 1], [1, 0], [0, -1], [-1, 0]]
    let visited = Array.from(Array(n), () => Array(n).fill(0))
    visited[sn][sm] = 1

    maxValue = 0
    maxPos = [sn, sm]

    while(q.length) {
        
        let [x, y] = q.shift()


        for (let d = 0; d < dir.length; d++) {
            xd = x + dir[d][0]
            yd = y + dir[d][1]


            if ( 0 <= xd && xd < n && 0 <= yd && yd < n ) {
                if (visited[xd][yd] === 0 && arr[xd][yd] < arr[sn][sm]) {
                    visited[xd][yd] = 1
                    q.push([xd, yd])   

                    if (arr[xd][yd] > maxValue) {
                        maxValue = arr[xd][yd]
                        maxPos = [xd, yd]
                    } else if (arr[xd][yd] === maxValue) {
                        if (maxPos[0] > xd) {
                            maxPos = [xd, yd]
                        } else if (maxPos[0] === xd) {
                            if (maxPos[1] > yd) {
                                maxPos = [xd, yd]
                            }
                        }
                    }
                }
            }
        }
    }

    return maxPos
}

while (k > 0){
    res = bfs(r, c)
    r = res[0]
    c = res[1]
    k--
}

console.log(r+1, c+1)