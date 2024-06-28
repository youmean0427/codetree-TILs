const fs = require("fs")
const input = fs.readFileSync(0).toString().trim().split("\n")
const SortedMap = require("collections/sorted-map");

const n = Number(input[0])

const sm = new SortedMap()

for (let i = 1; i <= n; i++) {
    let line = input[i].split(" ")
    if (line[0] === "add") {
        sm.set(parseInt(line[1]), parseInt(line[2]))
    } else if (line[0] === "remove") {
        sm.delete(parseInt(line[1]))
    } else if (line[0] === "find") {
        if (sm.has(parseInt(line[1]))) {
            console.log(sm.get(parseInt(line[1])))
        } else {
            console.log("None")
        }
    } else {
        if (sm.length === 0) {
            console.log("None")
        } else {
            total = ""
            for (let [k, v] of sm.entries()) {
                total += v + " "
            }
            console.log(total)
        }
    }
}