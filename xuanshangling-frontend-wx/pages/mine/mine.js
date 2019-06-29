const app = getApp();
Page({
  data: {
    faceUrl: "../../images/face-default.jpg",
    nickname: "",
    creditScore: "-"
  },
  onLoad() {
    var that = this;
    //获取个人信息
    wx.request({
      url: app.serverUrl + '/user/query/' + app.userInfo.id,
      success: res => {
        if(res.data.code == 0) {
          var userInfo = res.data.data;
          if(userInfo.faceImage) {
            that.setData({
              faceUrl: app.serverUrl + userInfo.faceImage,
            })
          }
          that.setData({
            nickname: userInfo.nickname,
            creditScore: userInfo.creditScore
          })
        }else {
          wx.showToast({
            title: res.date.msg,
          })
        }
      }
    })

  },
  //更改头像
  changeFace() {
    var that = this;
    wx.chooseImage({
      count: 1,
      success: function(res) {
        const tempFilePath  = res.tempFilePaths;
        if(tempFilePath.length == 0) return;
        wx.showLoading({
          title: '正在上传。。。',
        })
        //上传
        wx.uploadFile({
          url: app.serverUrl + '/user/uploadFace?userId=' + app.userInfo.id,
          filePath: tempFilePath[0],
          name: 'file',
          success: res => {
            var data = JSON.parse(res.data);
            if (data.code == 0){
              wx.hideLoading();
              wx.showToast({
                title: '上传成功！',
              })
              that.setData({
                faceUrl: app.serverUrl + data.data
              })

            }else {
              wx.showToast({
                title: data.msg,
                icon: 'none'
              })
            }
          }
        })
      },
    })
  },
  //前往登录页面
  doLogin() {
    wx.redirectTo({
      url: '../login/login',
    })
  },
  //用户注销
  doLogout() {
    wx.request({
      url: app.serverUrl + '/logout?userId=' + app.userInfo.id,
      method: "POST",
      success: res => {
        if(res.data.code == 0) {
          wx.showToast({
            title: '注销成功',
            duration: 3000
          })
          wx.redirectTo({
            url: '../login/login',
          })
        }else {
           wx.showToast({
             title: res.data.msg,
             icon: 'none'
           })
        }
      }
    })
  }
})