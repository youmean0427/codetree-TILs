const fs = require("fs")
const input = fs.readFileSync(0).toString().trim().split(" ")
const [n, k] = input.map(x => Number(x))


q = []

for (i = 1; i <= n; i++) {
    q.push(i)
}

ans = ""
let cnt = 0
while (q.length) {
    let x = q.shift()
    cnt += 1

    if (cnt === k) {
        ans += x + " "
        cnt = 0
    } else {
        q.push(x)
    }

}

console.log(ans)