const fs = require("fs")
const input = fs.readFileSync(0).toString().trim().split("\n")

const [n, g] = input[0].split(" ").map(x => Number(x))
ans = new Set([1])
const arr = input.slice(1, g+1).map((x) => x.split(" ").filter((y, i) => i > 0).map(x => Number(x)))
arrSet = arr.map(x => new Set(x))

arrSet.forEach(x => {if (x.has(1)) {
    x.delete(1)
}})
stack= []

arrSet.forEach(x => {
    let now = 0
    if (x.size === 1) {
        x.forEach(x => now = x)
        stack.push(now)
        ans.add(now)
        x.clear()
    }
})

while (stack.length) {
    let now = stack.pop()
    ans.add(now)
    arrSet.forEach(x => {
        next = 0
        if (x.has(now)) {
            x.delete(now)
        }

        if (x.size === 1 ) {
            x.forEach(x => next = x)
            stack.push(next)
            x.clear
        }
    })

}

console.log(ans.size)