// This sample use native node http module

var http = require("http");
var port = 3000;

http.createServer(requestListener).
    listen(port);
console.log("Server is listening on", port)

function requestListener(req, res) {
    res.writeHead(200, {
        'Content-Type':
        'text/plain'
    });
    res.end("Hello noob");
}