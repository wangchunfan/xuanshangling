const app = getApp();

const years = [];
for (let i = 2010; i <= 2050; i++) {
  years.push(i);
}

const months = []
for (let i = 1; i <= 12; i++) {
  months.push(i)
}

const days = []
for (let i = 1; i <= 31; i++) {
  days.push(i)
}

const hours = []
for (let i = 0; i <= 23; i++) {
  hours.push(i)
}

const minutes = []
for (let i = 0; i <= 59; i++) {
  minutes.push(i)
}

Page({
  data: {
    years: years,
    months: months,
    days: days,
    hours: hours,
    minutes: minutes,
    startTime: "",
    endTime: "",
    autoTimePicker: [1,3,4,5,6],
    multiTimePicker: [years,"年", months,"月", days,"日",hours,"时",minutes,"分"],
  }, 
  //开始日期选择 
  startTimeChange:function(res){
    console.log(res)
    var val = res.detail.value;
    console.log(val)
    this.setData({
      startTime: years[val[0]] + "-" + 
      (months[val[2]] > 9 ? months[val[2]] : "0" + months[val[1]]) +"-" + 
      (days[val[4]] > 9 ? days[val[4]] : "0" + days[val[2]]) + " " + 
      (hours[val[6]] > 9 ? hours[val[6]] : "0" + hours[val[3]]) + ":" + 
      (minutes[val[8]] > 9 ? minutes[val[8]] : "0" + minutes[val[4]])
    })
  },
  //结束日期选择
  endTimeChange: function (res) {
    console.log(res)
    var val = res.detail.value;
    console.log(val)
    this.setData({
      endTime: years[val[0]] + "-" +
        (months[val[2]] > 9 ? months[val[2]] : "0" + months[val[1]]) + "-" +
        (days[val[4]] > 9 ? days[val[4]] : "0" + days[val[2]]) + " " +
        (hours[val[6]] > 9 ? hours[val[6]] : "0" + hours[val[3]]) + ":" +
        (minutes[val[8]] > 9 ? minutes[val[8]] : "0" + minutes[val[4]])
    })
  },
  //提交
  rewardPublic(res){
    console.log(res)
    var that = this;
    var val = res.detail.value;
    wx.request({
      url: app.serverUrl +'/reward/publish',
      method:"POST",
      data: {
        "rewardTitle": val.rewardTitle,
        "rewardContent": val.rewardContent,
        "rewardPrice": val.rewardPrice,
        "startTime": that.data.startTime,
        "endTime": that.data.endTime,
        "userId": "admin"//app.userInfo.id
      }
    })
  }

})