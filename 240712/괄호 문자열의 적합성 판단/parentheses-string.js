class Stack {
    constructor() {
        this.stack = []
    }

    push(item) {
        this.stack.push(item)
    }

    empty() {
        if (this.stack.length) {
            return false
        } else {
            return true
        }
    }

    pop() {
        if (this.empty()) {
            throw new Error("Empty")
        } else {
            return this.stack.pop()
        }
    }

    top() {
        return this.stack[this.stack.length-1]
    }
}

const fs = require('fs')
const input = fs.readFileSync(0).toString().trim().split("")

s = new Stack()
for (let i = 0; i < input.length; i++ ){
    if (s.empty()) {
        s.push(input[i])
        continue
    }

    if (s.top() === "(" && input[i] === ")") {
        s.pop()
    } else {
        s.push(input[i])
    }
}

if (s.empty()) {
    console.log("Yes")
} else {
    console.log("No")
}