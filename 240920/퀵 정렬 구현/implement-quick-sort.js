const fs = require("fs")
const input = fs.readFileSync(0).toString().trim().split("\n")

const N = Number(input[0])
const arr = input[1].split(" ").map(x => Number(x))

function quick_sort(start, end)
{
    const pivot = arr[start]

    let i = start + 1
    let j = end
  
    while(i <= j)
    {
        while (i <= j && arr[i] <= pivot)
            i++
        while (i <= j && arr[j] >= pivot)
            j--

        if (i < j)
        {
            temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
        }
    }

    temp = arr[j]
    arr[j] = arr[start]
    arr[start] = temp

    return j
}

function quick(start, end)
{
    if (start < end)
    {
        idx = quick_sort(start, end)
        quick(start, idx - 1)
        quick(idx + 1, end)
    }
}

quick(0, N-1)
console.log(...arr)