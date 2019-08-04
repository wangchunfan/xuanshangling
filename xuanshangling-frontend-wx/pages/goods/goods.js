const app = getApp()

Page({

  /**
   * 页面的初始数据
   */
  data: {
    goods_detail: {},
    openShare: false,
    canShare: false,
    goods_id: ''
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    if (options) {
      this.setData({
        goods_id: options.goods_id
      })
    }
    var that = this;
    wx.showNavigationBarLoading();
    wx.request({
      url: app.serverUrl + '/goods/' + this.data.goods_id,
      success: res => {
        wx.hideNavigationBarLoading();
        wx.stopPullDownRefresh();
        if (res.data.code == 0) {
          var goods_detail = JSON.parse(res.data.data).goods_detail_response.goods_details.pop();
          console.log(goods_detail.goods_image_url);
          that.setData({
            goods_detail: goods_detail
          })
        } else {
          wx.showToast({
            title: res.data.msg,
            icon: 'none'
          })
        }
      }
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {
    this.onLoad()
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  }
})