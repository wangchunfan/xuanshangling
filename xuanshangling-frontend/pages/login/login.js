const app = getApp();
Page({
  doLogin: function(res) {
    var data = res.detail.value;
    if(!data.username || !data.password){
      wx.showToast({
        title: '用户名或密码不能为空',
        icon: 'none'
      })
      return;
    }
    wx.showLoading();
    wx.request({
      url: app.serverUrl + '/login',
      method: "POST",
      data: {
        username: data.username,
        password: data.password
      },
      success: function(res) {
        wx.hideLoading();
        console.log(res)
        if(res.data.code == 0){
          wx.showToast({
            title: '登录成功'
          })
          app.userInfo = res.data.data;
          wx.redirectTo({
            url: '../mine/mine',
          })
        }else{
          wx.showToast({
            title: res.data.msg,
            icon: 'none'
          })
        }
      }
    })
  },
  goRegister(){
    wx.navigateTo({
      url: '../register/register',
    })
  }
})