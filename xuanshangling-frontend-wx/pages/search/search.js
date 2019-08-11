const app = getApp()
const api = require("../../utils/api.js")
Page({

  /**
   * 页面的初始数据
   */
  data: {
    keyword: '',
    defaultKeyword: '上衣',
    searchOk: false, //搜索完毕
    searchNo: false, //没有搜索结果
    currentPage: 1,
    goods_list: [],
    total_count: 0,
    isBottom: false,
    pageSize: 10
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {

  },
  //点击回车/搜索
  onKeywordConfirm: function(event) {
    var that = this;
    var keyword = event.detail.value
    //如果没有关键字，使用默认关键字
    that.setData({
      keyword: keyword || that.data.defaultKeyword
    })
    this.goodsSearch()
  },
  //点击取消按钮返回上一页
  closeSearch: function() {
    wx.navigateBack()
  },
  //清空搜索内容
  clearKeyword() {
    console.log("32")
    this.setData({
      keyword: ''
    })
  },
  //输入关键字
  inputChange(event) {
    this.setData({
      keyword: event.detail.value
    })
  },
  //搜索商品
  goodsSearch() {
    var that = this
    api.request({
      url: app.serverUrl + '/goods/search',
      data: {
        keyword: that.data.keyword,
        page: that.data.currentPage
      }
    }).then(res => {
      var goods_search_response = res.goods_search_response

      //如果搜索记录为空
      if (goods_search_response.total_count == 0) {
        that.setData({
          searchOk: true,
          searchNo: true
        })
      } else {
        that.setData({
          goods_list: that.data.goods_list.concat(goods_search_response.goods_list),
          searchOk: true,
          searchNo: false,
          total_count: goods_search_response.total_count,
          currentPage: that.data.currentPage + 1
        })
      }
    })
  },
  //输入关键字
  kewordInput(event) {
    console.log(event)
  },
  //搜索框聚焦
  inputFocus(event) {
    this.setData({
      isBottom: false,
      searchOk: false,
      searchNo: false,
      goods_list: [],
      total_count: 0
    })
  },
  //上拉
  onReachBottom: function() {
    //搜索到末尾
    if (this.data.total_count > this.data.currentPage * this.data.pageSize)
      this.goodsSearch();
    else
      this.setData({
        isBottom: true
      })
  }
})