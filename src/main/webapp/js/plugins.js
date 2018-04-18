/* 左侧菜单下拉JS*/
$(document).ready(function () {
$('.nav > li > a').click(function(){
    if ($(this).attr('class') != 'active'){
      $('.nav li ul').slideUp();
      $(this).next().slideToggle();
      $('.nav li a').removeClass('active');
      $(this).addClass('active');
    }else{
      $(this).next().slideToggle();
      $(this).css('color','rgba(255, 255, 255, 0.6)');
      $(this).css('background','#2f4050');
    }
});
  $('.sidetitle').nextAll('li').hide();
  $('.sidetitle').click(function (){
  $(this).nextAll('li').toggle();
  })
});
// 隐藏菜单JS
$('#onclick1').click(function(){
  $('#onclick1').toggleClass('hh');
 if($('#onclick1').is('.hh')){
    $('.sidebar').hide();
     $('.content').css('margin-left','0px')
 }else{
    $('.sidebar').show();
    $('.content').css('margin-left','220px')
 }
 
})
// 登陆页面发送验证码JS
var InterValObj; //timer变量，控制时间
var count =60; //间隔函数，1秒执行
var curCount;//当前剩余秒数

function sendMessage() {
  　curCount = count;
　　//设置button效果，开始计时
     $("#btnSendCode").attr("disabled", "true");
     $("#btnSendCode").val("请在" + curCount + "秒内输入");
     InterValObj = window.setInterval(SetRemainTime, 1000); //启动计时器，1秒执行一次
　　  //向后台发送处理数据
     $.ajax({
     　　type: "POST", //用POST方式传输
     　　dataType: "text", //数据格式:JSON
     　　url: 'Login.ashx', //目标地址
    　　 data: "dealType=" + dealType +"&uid=" + uid + "&code=" + code,
    　　 error: function (XMLHttpRequest, textStatus, errorThrown) { },
     　　success: function (msg){ }
     });
}

//timer处理函数
function SetRemainTime() {
            if (curCount == 0) {                
                window.clearInterval(InterValObj);//停止计时器
                $("#btnSendCode").removeAttr("disabled");//启用按钮
                $("#btnSendCode").val("重新发送");
            }
            else {
                curCount--;
                $("#btnSendCode").val("请在" + curCount + "秒内输入");
            }
        }


  

