const fs = require('fs')
let input = fs.readFileSync(0).toString().trim().split("\n")

const n = parseInt(input[0])
const arr = input[1].split(" ").map(x => Number(x))

let ans = Infinity
function back(idx, sm, cnt, sm2) {
    
    if (idx >= arr.length) {
        if (cnt == n) {
            ans = Math.min(ans, Math.abs(sm-sm2))
        }
        return
    }


    back(idx+1, sm+arr[idx], cnt+1, sm2)
    back(idx+1, sm, cnt, sm2+arr[idx])
}

back(0, 0, 0, 0)
console.log(ans)