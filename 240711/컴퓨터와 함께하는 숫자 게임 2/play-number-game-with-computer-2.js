const fs = require('fs')
const input = fs.readFileSync(0).toString().trim().split("\n")

const m = Number(input[0])
const [a, b] = input[1].split(" ").map(x => Number(x))

function binarySort(x) {

    let start = 1
    let end = m
    let cnt = 0

    while (start <= end) {
        let mid = parseInt((start + end) / 2)
        cnt += 1
        if (mid === x) {
            return cnt
        }
        else if (mid > x) {
           end = mid - 1 
        } else {
        start = mid + 1
        }
    }

    return cnt
}

let max = 0
let min = Infinity


for (let i = a; i <= b; i++) {
    res = binarySort(i)

    max = Math.max(max, res)
    min = Math.min(min, res)
}

console.log(min, max)