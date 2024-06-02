const fs = require('fs')
let input = fs.readFileSync(0).toString().trim().split('\n')

const N = parseInt(input[0])
const arr = input.slice(1, N+1).map(x => x.split(" ").map(Number))


// 직사각형의 현재 좌표와 가로, 세로 길이 받아서, 방향 순서대로 직사각형을 만들어 나가는 방식
// 만약, 만들어지지 않는다면?(격자에서 벗어난다면?) -> 0을 return
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
// 격자의 가로, 세로 Idx
for (let i = 0; i < N; i++ ) {
    for (let j = 0; j < N; j++) {
        // 직사각형의 가로, 세로 길이
        // 격자보다 클 수 없기 때문에 N으로 제한
        for (let r = 1; r < N; r++) {
            for (let c = 1; c < N; c++) {
                let x = box(i, j, r, c)
                ans = Math.max(ans, x)
            }
        }
    }
}
console.log(ans)