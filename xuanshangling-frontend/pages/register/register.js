const app = getApp();   
Page({
  doRegister: function (res) {
    var data = res.detail.value
    if(!data.username || !data.password){
      wx.showToast({
        title: '用户名或密码不能为空',
        icon: 'none'
      })
      return;
    }
    console.log(app)
    wx.request({
      url: app.serverUrl + '/register',
      method: 'POST',
      data: {
        username: data.username,
        password: data.password
      },
      success: function(res){
        if (res.data.code == 0) {
         app.userInfo = res.data.data;
         console.log(app);
         wx.showToast({
           title: '注册成功'
         })
        } else{
          wx.showToast({
            title: res.data.msg,
            icon: "none"
          })
        }
      }
    })
  }
})