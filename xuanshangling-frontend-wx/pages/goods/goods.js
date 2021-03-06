const app = getApp()

Page({

  /**
   * 页面的初始数据
   */
  data: {
    goods_detail: {},
    goods_urls: {},
    openShare: false,
    canShare: false,
    goods_id: '',
    showShareFlag: false
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
        console.log(res);
        if (res.data.code == 0) {
          var goods_detail = JSON.parse(res.data.data.goods_detail_response)
            .goods_detail_response.goods_details.pop();
          var goods_urls = JSON.parse(res.data.data.goods_promotion_url_generate_response)
            .goods_promotion_url_generate_response.goods_promotion_url_list.pop();
          that.setData({
            goods_detail: goods_detail,
            goods_urls: goods_urls
          })
          console.log(goods_urls)
        } else {
          wx.showToast({
            title: res.data.msg,
            icon: 'none'
          })
        }
      }
    })
  },
  //打开拼多多小程序
  openPdd: function() {

    wx.navigateToMiniProgram({
      appId: this.data.goods_urls.we_app_info.app_id, 
      path: this.data.goods_urls.we_app_info.page_path,
      success(res) {
        // 打开成功
      }
    })
  },
  //分享
  openShare: function() {
    this.setData({
      showShareFlag: true
    })
  },
  closeShare: function() {
    this.setData({
      showShareFlag: false
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