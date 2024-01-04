let fs = require('fs')
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n')

const N = parseInt(input[0])
arr = {}
for (let i = 1; i < input.length; i++) {
    const [a, b, c] = input[i].split(" ")
    
    if (a === 'add') {
       arr[b] = c 
    } else if (a === 'remove') {
        delete arr[b]
    } else {
        if (b in arr) {
            console.log(arr[b])
        } else {
            console.log('None')
        }
    }
}