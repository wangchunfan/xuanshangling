// pages/detail/detail.js
const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    reward: {},
    serverUrl: app.serverUrl
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var rewardId = options.id
    var that = this
    wx.request({
      url: app.serverUrl + '/reward/' + rewardId,
      success: res => {
        if(res.data.code == 0) {
          that.setData({
            reward: res.data.data
          })
        }else{
          wx.showToast({
            title: res.data.msg,
          })
        }
      }
    })
  },

  
})