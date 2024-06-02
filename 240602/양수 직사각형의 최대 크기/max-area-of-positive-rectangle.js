const fs = require('fs')
let input = fs.readFileSync(0).toString().trim().split("\n")

const [n, m] = input[0].split(" ").map(x => parseInt(x))
const arr = input.slice(1, n+1).map(x => x.split(" ").map(Number))

function square(x1, y1, x2, y2) {
    cnt = 0
    for (let x = x1; x < x2+1; x++) {
        for (let y = y1; y < y2+1; y++ ) {
            if (arr[x][y] > 0) {
                cnt += 1
            } else {
                return -1
            }
        }
    }
    return cnt
}

ans = -1
for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
        for (let r = i; r < n; r++ ) {
            for (let c = j; c < m; c++) {
                x = square(i, j, r, c)
                ans = Math.max(ans, x)
            }
        }
    }
}
console.log(ans)