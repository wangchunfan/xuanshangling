const app = getApp();
const api = require("../../utils/api.js");

Page({

  /**
   * 页面的初始数据
   */
  data: {
    theme_list: [],
    goods_list: [],
    goods_opt_list: [],
    goods_opt_list_II: [],
    currentPage: 1,
    pageSize: 10,
    totalCount: 0,
    isBottom: false,
    opt_id_checked: 0,
    opt_id: 0
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    var that = this;
    wx.showNavigationBarLoading();
    api.request({
      url: app.serverUrl + '/index/onLoad',
    }).then(data => {
      wx.stopPullDownRefresh();
      wx.hideNavigationBarLoading();
      var goods_search_response = JSON.parse(data.goods_search_response).goods_search_response;
      var theme_list_get_response = JSON.parse(data.theme_list_get_response).theme_list_get_response;
      var goods_opt_get_response = JSON.parse(data.goods_opt_get_response).goods_opt_get_response;
      that.setData({
        theme_list: theme_list_get_response.theme_list,
        goods_list: goods_search_response.goods_list,
        totalCount: goods_search_response.total_count,
        goods_opt_list: [{
          opt_name: "热门",
          opt_id: 0
        }, ...goods_opt_get_response.goods_opt_list.filter(item => {
          return item.opt_id <= 5127
        })]
      })
    })
  },
  /**
   * 上拉刷新
   */
  getInfo: function(page) {
    var that = this;
    wx.showNavigationBarLoading();
    api.request({
      url: app.serverUrl + "/index/page",
      data: {
        page: that.data.currentPage + 1,
        opt_id: that.data.opt_id
      }
    }).then(res => {
      wx.hideNavigationBarLoading();
      var data = res.goods_search_response

      that.setData({
        currentPage: that.data.currentPage + 1,
        goods_list: that.data.goods_list.concat(data.goods_list),
        totalCount: data.total_count,
        isBottom: false
      })
    })
  },
  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {
    if (this.data.opt_id_checked == 0) {
      this.onLoad();
    } else {
      this.getOpt();
    }

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
   * 点击分类
   */
  checkOpt(event) {
    var opt_id_checked = event.currentTarget.dataset.id
    this.setData({
      opt_id_checked: opt_id_checked,
      opt_id: opt_id_checked,
      currentPage: 0,
      goods_list: []
    })
    this.getOpt();
  },
  //获取II级分类
  getOpt() {
    var that = this;
    api.request({
      url: app.serverUrl + "/goods/opt/" + this.data.opt_id_checked
    }).then(res => {
      wx.stopPullDownRefresh();
      that.setData({
        goods_opt_list_II: res.goods_opt_get_response.goods_opt_list.filter((item, index) => {
          return index < 10;
        })
      })
    })
    this.getInfo();
  },
  //点击二级分类
  checkOptII(event) {
    var opt_id = event.currentTarget.dataset.id
    this.setData({
      opt_id: opt_id,
      currentPage: 0,
      goods_list: []

    })
    this.getInfo();
  }

})