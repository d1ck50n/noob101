// This sample use express module which is simplified node web framework
// To start with nodemon, type: nodemon app-express.js
// To start with node, type: node app-express.js

var express = require('express');
var config = require('config');
var bodyParser = require('body-parser');
var app = express();
app.use(bodyParser.json());
app.listen(config.port);

var taskList = [];
app.get('/list', function (req, res) {
    res.send(taskList);
});

app.post('/task', function (req, res) {
    taskList.push(req.body.task);
    res.send(taskList);
});

app.put('/task/:task_index', function (req, res) {
    var taskIndex = req.params.task_index;
    taskList[taskIndex] = req.body.task
    res.send(taskList);
});

app.delete('/task/:task_index', function (req, res) {
    var taskIndex = req.params.task_index;
    taskList.splice(taskIndex, 1)
    res.send(taskList);
});

app.get('/', function (req, res) {
    res.send("Available end point are: <br/>  1. /list <br/> 2. /task <br/> 3. /task/[index]");
});