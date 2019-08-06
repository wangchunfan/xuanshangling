const api = require('../../utils/api.js')
const app = getApp()

Page({

  /**
   * 页面的初始数据
   */
  data: {
    goods_list: [],
    image_url: '',
    name: ''
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    console.log(options.theme_id)
    this.setData({
      image_url: options.image_url,
      name: options.name
    })
    var that = this
    api.request({
      url: app.serverUrl + '/theme/' + options.theme_id
    }).then(function(res) {
      that.setData({
        goods_list: res.theme_list_get_response.goods_list
      })
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