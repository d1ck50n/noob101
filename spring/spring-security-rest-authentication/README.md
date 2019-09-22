Start the application by running **SpringBootTutorialApplication.java**
You may use curl to test out 2 methods available as below:

* Using HTTP GET, and it allow anonymous user to access

`curl http://localhost:8080`

* Using HTTP POST, and it need "Authorization" header to be set, else it throw access denied exception

`curl  curl -X POST --header "Authorization: Bearer fakesessionid" http://localhost:8080`
