const fs = require('fs')
const input = fs.readFileSync(0).toString().trim().split("\n")

const n = Number(input[0])
const arr = input[1].split(" ").map(x => Number(x))

ans = Infinity

function back(idx, sm) {
    

    if (idx >= n-1) {
        ans = Math.min(ans, sm)
        return
    }

    for (let i = idx+1; i <= idx+arr[idx]; i++){
        back(i, sm+1)
    }
}

back(0, 0)
if (ans === Infinity) {
    console.log(-1)
} else {
    console.log(ans)
}