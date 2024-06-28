const fs = require('fs')
const input = fs.readFileSync(0).toString().trim().split("\n")

const n = Number(input[0])
const arr1 = input[1].split(" ").map(x => parseInt(x))
const arr2 = input[2].split(" ").map(x => parseInt(x))

let [a1, a2] = [0, 0]
let [re1, re2] = [0, 0]

while (a1 < n-1 && a2 < n-1) {

    if (arr1[a1] < arr2[a2]) {
        a1 += 1
        re1 += arr1[a1]
    } else if (arr1[a1] > arr2[a2]) {
        a2 += 1
        re2 += arr2[a2]
    } else {
        a1 += 1
        a2 += 1
    }
}

console.log(Math.max(re1, re2))