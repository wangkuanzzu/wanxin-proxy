# wanxin-anbo-proxy
代理万信接入广告平台

## 广告获取接口
### 1.业务功能
    根据广告位ID，获取广告信息，返回广告内容content和点击redirectUrl
    
### 2.业务规划
    [GET] https://api.anbokeji.net/wanxin/ad
    
### 3.请求参数
    | **参数**           | **名称** | **类型** | **长度** | **约束** | **说明** |
    | ------------------ | -------- | -------- | -------- | -------- | -------- |
    | Map<String,String> |          |          |          |          |          |
    | adPosId            | 广告位ID | String   | 1        | 必填     |          |

### 4.请求参数示例
```json
{
  "adPosId": "5"
}
```

### 5.响应参数
| **参数**      | **名称** | **类型** | **长度** | **约束** | **说明**                                 |
| ------------- | -------- | -------- | -------- | -------- | ---------------------------------------- |
| status        | 响应码   | String   |          |          | 20000000 :成功 其它失败                  |
| message       | 相应描述 | String   |          |          | 可以展示给用户                           |
| info          | 详细信息 | String   |          |          | 供开发人员定位问题                       |
| result        | 响应扩展 | Map      |          |          |                                          |

### 6.响应参数示例

```json
{
  "status": "20000000",
  "message": "成功",
  "info": "success",
  "result": {
    "redirectUrl": "https://ad.anbokeji.net/api/v1/advert/redirect?sign=MEUCIFNO5n19I2U3mnqK5vmIi2I/cTWZ7MwrxbC9wlw04y5rAiEA6R5zpTttd4rw9iKyZQV0WK1+qi6fE45OORFyhi+Qtz0=&adId=36099463137562624&partnerId=2004675897&parkId=18511223344",
    "content": "https://anbokeji.oss-cn-hangzhou.aliyuncs.com/images/20200618/泊斯特-支付后113315144541.jpg"
  }
}
```

```json
{
  "status": "40000204",
  "message": "获取不到广告信息，请联系运营人员检查是否已投放广告",
  "info": "获取不到广告信息，请联系运营人员检查是否已投放广告",
  "result": null
}
```

