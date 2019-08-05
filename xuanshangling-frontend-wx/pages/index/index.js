const app = getApp();

Page({

  /**
   * 页面的初始数据
   */
  data: {
    theme_list: [],
    goods_list: [],
    currentPage: 1,
    pageSize: 10,
    totalCount: 0,
    isBottom: false
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    var that = this;
    wx.showNavigationBarLoading();
    wx.request({
      url: app.serverUrl + '/index/onLoad',
      success: res => {
        wx.stopPullDownRefresh();
        wx.hideNavigationBarLoading();
        if (res.data.code == 0) {
          var data = res.data.data
          var goods_search_response = JSON.parse(data.goods_search_response).goods_search_response;
          var theme_list_get_response = JSON.parse(data.theme_list_get_response).theme_list_get_response;
          goods_search_response.goods_list.forEach(function(item) {
            item.goods_name = item.goods_name.substring(0, 10) + '...';
          })
          that.setData({
            theme_list: theme_list_get_response.theme_list,
            goods_list: goods_search_response.goods_list,
            totalCount: goods_search_response.total_count
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
  getInfo: function(page) {
    var that = this;
    wx.showNavigationBarLoading();
    wx.request({
      url: app.serverUrl + "/home/page",
      data: {
        page: that.data.currentPage + 1
      },
      success: res => {
        if (res.data.code == 0) {
          wx.hideNavigationBarLoading();
          var data = JSON.parse(res.data.data).goods_search_response
          data.goods_list.forEach(function(item){
            item.goods_name = item.goods_name.substring(0, 10) + '...';
          })
          that.setData({
            currentPage: that.data.currentPage + 1,
            goods_list: that.data.goods_list.concat(data.goods_list),
            totalCount: data.total_count,
            isBottom: false
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
    this.onLoad();
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {
    if (this.data.totalCount > this.data.currentPage * this.data.pageSize)
      this.getInfo();
    else
      this.setData({
        isBottom: true
      })
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  }
})