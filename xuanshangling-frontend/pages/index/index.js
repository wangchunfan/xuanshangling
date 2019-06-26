const app = getApp()
Page({
  data: {
    screenWidth: 350,
    serverUrl: app.serverUrl,
    rewardList:[],
    pageNum: 1,
    pageSize: 4,
    pages: 0
  },
  onLoad: function(){
    var screenWith = wx.getSystemInfoSync().screenWidth;
    var that = this;

    that.setData({
      screenWidth: screenWith
    })
    
    this.pageLoad(that.data.pageNum)

  },
  //页面下拉触顶
  onPullDownRefresh(){
    this.pageLoad(1)
  },
  //页面上拉触底事件
  onReachBottom(){
    //当前页数等于总页数则不再刷新
    if (this.data.pageNum == this.data.pages) {
      wx.showToast({
        title: '到底了！',
        icon: 'none'
      })
      return;
    }

    this.pageLoad(this.data.pageNum + 1)
  },
  //页面加载
  pageLoad(pageNum){
    var that = this;
    if (pageNum == 1) {
      that.setData({
        rewardList: []
      })
    }
    wx.showNavigationBarLoading();
    
    wx.request({
      url: app.serverUrl + '/reward/page',
      data: {
        pageNum: pageNum,
        pageSize: that.data.pageSize
      },
      success: res => {
        wx.hideNavigationBarLoading();
        wx.stopPullDownRefresh();

        if (res.data.code == 0) {
          var data = res.data.data
          that.setData({
            rewardList: that.data.rewardList.concat(data.list),
            pageNum: data.pageNum,  //当前页数
            pages: data.pages //总页数
          })

        } else {
          wx.showToast({
            title: res.data.msg,
            icon: 'none'
          })
        }
      }
    })
  }
})