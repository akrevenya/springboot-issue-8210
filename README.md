Demo app to demonstrate Spring Boot issue 8210 when app and actuator is configured to run on different ports while security is enabled for the app and disabled for the management port.

1.3.8
```bash
>curl localhost:8081
{"timestamp":1489684567085,"status":403,"error":"Forbidden","message":"Access Denied","path":"/"}
>curl localhost:8001/health
{"status":"UP","diskSpace":{"status":"UP","total":253128339456,"free":127025848320,"threshold":10485760}}
```


1.5.2
```bash
>curl localhost:8080
{"timestamp":1489684635356,"status":403,"error":"Forbidden","message":"Access Denied","path":"/"}
>curl localhost:8000/health
{"timestamp":1489684644784,"status":403,"error":"Forbidden","message":"Access Denied","path":"/health"}
```