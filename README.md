# local wiremock
A simple local mock-server  

By given request(path, method), the sever will response the response(body, status)

## status

| target | des            | status            |
| ------ | -------------- | ----------------- |
| v1     | simple mapping | response not json |
|   v1.1     |                |      json issue fixed             |

## how to use

put your mapping json in resources/mapping

```json
{
  "request": {
    "method": "get",
    "urlPath": "/get/addr"
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

| Attribute       | Mandatory |
| --------------- | --------- |
| request         | M         |
| request.method  | M         |
| request.urlPath | M         |
| response        | M         |
| response.status | M         |
| response.body   | M         |

