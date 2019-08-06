function request(data) {
  return new Promise(function(resolve, reject) {
    wx.request({
      url: data.url,
      data: data.data || {},
      method: data.method || "GET",
      success: function(res) {
        if (res.statusCode == 200 && res.data.code == 0) {
          var data = res.data.data;
          data = typeof data == "string" ? JSON.parse(data) : data;
          console.log(data);
          resolve(data);
        } else {
          wx.showToast({
            title: '网络错误',
            icon: "none"
          })
        }
      },
      fail: function() {
        wx.showToast({
          title: '网络错误',
          icon: "none"
        })
      }
    })
  })
}

module.exports = {
  request
}