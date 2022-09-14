# local wiremock
A simple local mock-server  

By given request(path, method), the sever will response the response(body, status)

## status

| target | des            | status            |
| ------ | -------------- | ----------------- |
| v1     | simple mapping | response not json |
|   v1.1     |                |      json issue fixed             |
| v1.2 | add **mock** field in header |  |

## how to use

put your mapping json in resources/mapping

```json
{
  "request": {
    "method": "get",
    "urlPath": "/get/addr",
    "mock": "a1"
  },
  "response": {
    "status": 201,
    "body": {
      "info": {
        "estimation": "OK",
        "quality": "HD"
      },
      "msg": "Address Created"
    }
  }
}
```

### fields

| Attribute       | Mandatory/Optional |
| --------------- | ------------------ |
| request         | M                  |
| request.method  | M                  |
| request.urlPath | M                  |
| request.mock    | O                  |
| response        | M                  |
| response.status | M                  |
| response.body   | M                  |

