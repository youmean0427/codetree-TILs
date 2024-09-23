const fs = require("fs")
const input = fs.readFileSync(0).toString().trim().split("\n")

const n = Number(input[0])
const arr = input[1].split(" ").map(x => Number(x))

function heapify(n, i)
{
    let largest = i
    let left = 2 * i
    let right = 2 * i + 1
    let temp

    if (left < n && arr[left] > arr[largest])
        largest = left
    if (right < n && arr[right] > arr[largest])
        largest = right
    
    if (largest != i)
    {
        temp = arr[largest]
        arr[largest] = arr[i]
        arr[i] = temp
        heapify(n, largest) 
    }
}

for (let i = n / 2; i >= 0; i--)
    heapify(n, i)

for (let i = n - 1; i >= 0; i--)
{
    temp = arr[0]
    arr[0] = arr[i]
    arr[i] = temp
    heapify(i, 0)
}

console.log(...arr)