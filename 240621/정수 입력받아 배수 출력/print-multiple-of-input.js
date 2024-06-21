const fs = require('fs');
let input = fs.readFileSync(0).toString().trim();
input = parseInt(input)

ans = ""
for (let i = input; i <= input * 5; i += input) {
    ans += i + " "
}
console.log(ans)