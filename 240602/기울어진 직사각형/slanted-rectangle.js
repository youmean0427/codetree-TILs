const fs = require('fs')
let input = fs.readFileSync(0).toString().trim().split('\n')

const N = parseInt(input[0])
const arr = input.slice(1, N+1).map(x => x.split(" ").map(Number))



function box(i, j, r, c) {
    const dir = [r, c, r, c]
    const dir_pos = [[-1, 1], [-1, -1], [1, -1], [1, 1]]
    let now_i = i 
    let now_j = j
    let ans = 0
    for (let d = 0; d < 4; d++) {
        for (let cnt = 0; cnt < dir[d]; cnt++) {
            ans += arr[now_i][now_j]
            now_i += dir_pos[d][0]
            now_j += dir_pos[d][1]

            if (0 <= now_i && now_i < N && 0 <= now_j && now_j < N) {
                continue
            } else {
                return 0
            }
        } 
    }
    return ans
    
}



ans = 0
for (let i = 0; i < N; i++ ) {
    for (let j = 0; j < N; j++) {
        for (let r = 1; r < N; r++) {
            for (let c = 1; c < N; c++) {
                let x = box(i, j, r, c)
                ans = Math.max(ans, x)
            }
        }
    }
}
console.log(ans)