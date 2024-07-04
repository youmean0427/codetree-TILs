const fs = require("fs")
const input = fs.readFileSync(0).toString().trim()

const arr = input.split("")

const m = new Map()
const alpha = ["a", "b", "c", "d", "e", "f"]

for (i of alpha) {
    m.set(i, 0)
}

function operate(m) {
    total = 0
    now = 0
    for (let i = 0; i <= arr.length; i++) {
        if (m.has(arr[i])) {
            if (now === 0) {
                total += m.get(arr[i])
            } else if (now == 1) {
                total -= m.get(arr[i])
            } else if (now == 2) {
                total *= m.get(arr[i])
            }
        } else {
            if (arr[i] === "+") {
                now = 0
            } else if (arr[i] === "-") {
                now = 1
            } else if (arr[i] === "*") {
                now = 2
            }
        }
    }
    return total
}

ans = -Infinity

function back(idx, sm) {
    
    if (idx >= 6) {
        ans = Math.max(ans, operate(m))
        return
    }

   for (let i = 1; i <= 4; i++) {
        m.set(alpha[idx], i)
        back(idx+1, sm)
        m.set(alpha[idx], 0)
   } 
}

back(0, 0)

console.log(ans)