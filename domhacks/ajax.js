
var body = document.getElementsByTagName("body");
console.log(body);
var first = body.item(0);
console.log(first);
var div = first.getElementsByTagName("div").item(0).textContent;
console.log(div);

