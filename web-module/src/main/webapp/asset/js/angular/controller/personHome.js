/**
 * Created by Administrator on 2016/8/10.
 * description 个人信息页面
 */

var app = angular.module("personHomeApp",['ui.router']);

app.config(["$stateProvider", "$urlRouterProvider", "$httpProvider", function($stateProvider,$urlRouterProvider,$httpProvider){

    $urlRouterProvider.otherwise("/accountInfo");
    $stateProvider
        .state('accountInfo',{
            url:"/accountInfo",
            templateUrl:"/template/account/accountInfo.html"
        })
        .state('redPacket',{
            url:"/redPacket",
            templateUrl:"/template/account/redpacket.html"
        })
        .state('tradLog',{
            url:"/tradLog",
            templateUrl:"/template/account/tradLog.jsp"
        })
        .state('integral',{
            url:"/integral",
            templateUrl:"/template/account/integral.jsp"
        })
        .state('member',{
            url:"/member",
            templateUrl:"/template/account/member.html"
        })
        .state('invite',{
            url:"/invite",
            templateUrl:"/template/account/invite.jsp"
        })
        .state('safe',{
            url:"/safe",
            templateUrl:"/template/account/safe.jsp"
        });

}]);

//我的账户主页面
app.controller("personHomeCtrl",function($scope,$http){
    //$scope.username = "mrwater";
    $scope.userInfo = [];
    $scope.userId = $(".global_user_id").val();

    /**加载获取用户信息*/
    $http({
        url:"/user/getUserByUid",
        method:"GET",
        params:{userId:$scope.userId}
    }).success(function(data){
        $scope.userInfo = data;
        console.log("加载获取用户信息：");
        console.log(data);
        //是否已手机认证
        if(data.IS_TEL_STATUS == 0){
            $('.userhead .infobox .info i.phone').css({'background-position-x':'0px','background-position-y':"0px"});
        }else{
            $('.userhead .infobox .info i.phone').css({'background-position-x':'-80px','background-position-y':"0px"});
        }
        //是否已实名认证
        if(data.IS_AUTH_STATUS == 0){
            $('.userhead .infobox .info i.idcard').css({'background-position-x':'-160px','background-position-y':"0px"});
        }else{
            $('.userhead .infobox .info i.idcard').css({'background-position-x':'-241px','background-position-y':"0px"});
        }
        //是否已邮箱认证
        if(data.IS_EMAIL_STATUS == 0){
            $('.userhead .infobox .info i.email').css({'background-position-x':'-320px','background-position-y':"0px"});
        }else{
            $('.userhead .infobox .info i.email').css({'background-position-x':'-400px','background-position-y':"0px"});
        }
    }).error(function(data){
        console.log("获取失败！");
    });

});

//我的推广
app.controller("inviteCtrl",function($scope, $http) {
    $scope.invites = [];
    $scope.invitecount = "";
    $scope.userId = $(".global_user_id").val();

    /**获取被推荐人的列表*/
    $http({
        url:"/user/invite/inviteList",
        method:"GET",
        params:{userId:$scope.userId}
    }).success(function(data){
        $scope.invites = data;
    }).error(function(data){
        console.log(data);
    });

    /**获取累计被推荐人数*/
    $http({
        url:"/user/invite/inviteTotalPerson",
        method:"GET",
        params:{userId:$scope.userId}
    }).success(function(data){
        $scope.invitecount = data.length;
    }).error(function(data){
        console.log("获取失败！");
    });
});

//我的积分
app.controller("integralCtrl",function($scope, $http) {
    $scope.integrals = [];
    $scope.sum_integral = "" ;
    $scope.sum_month_integral = "" ;
    $scope.available_integral = "" ;
    $scope.userId = $(".global_user_id").val();

    /**查询该用户最新的积分记录*/
    $http({
        url:"/user/integral/integralLatest",
        method:"GET",
        params:{userId:$scope.userId}
    }).success(function(data){
        $scope.available_integral = data.AVAILABLE_INTEGRAL;
    }).error(function(data){
        console.log("获取失败！");
    });

    /**获取本月积分*/
    $http({
        url:"/user/integral/integralSumTotal",
        method:"GET",
        params:{userId:$scope.userId}
    }).success(function(data){
        $scope.sum_month_integral = data.sumMonthIntegral;
    }).error(function(data){
        console.log("获取失败！");
    });

    /**获取累计积分*/
    $http({
        url:"/user/integral/integralTotal",
        method:"GET",
        params:{userId:$scope.userId}
    }).success(function(data){
        $scope.sum_integral = data.sumScore;
    }).error(function(data){
        console.log("获取失败！");
    });

    /**获取积分明细列表*/
    $http({
        url:"/user/integral/integralList",
        method:"GET",
        params:{userId:$scope.userId}
    }).success(function(data){
        $scope.integrals = data;
    }).error(function(data){
        console.log("获取失败！");
    });

});

//交易记录
app.controller("tradLogCtrl",function($scope, $http) {

    $scope.tradLogs = [];
    $scope.investmentDetail = {};
    $scope.userId = $(".global_user_id").val();
    /**获取交易记录列表*/
    $http({
        url:"/user/transaction/findTransByUid",
        method:"GET",
        params:{userId:$scope.userId}
    }).success(function(data){
        $scope.tradLogs = data.transactions;
        $scope.investmentDetail = data.investmentDetail;
        console.log("加载交易记录列表成功：");
        console.log(data);
    }).error(function(data){
        console.log("获取失败！");
    });

});

//账户安全
app.controller("safeCtrl",function($scope, $http) {

    $scope.bankInfos = [];
    $scope.userId = $(".global_user_id").val();
    $scope.user_log = "";

    /**加载账户安全信息*/
    $http({
        url:"/user/safe/findUserInfo",
        method:"GET",
        params:{userId:$scope.userId}
    }).success(function(data){
        //登录时间
        $scope.user_log = data.userLog.LOGINTIME;
        console.log("加载用户认证信息成功：");
        console.log("加载绑定银行卡列表成功：");
        console.log(data);
        //是否已绑定手机号码
        if(data.userInfo.IS_TEL_STATUS == 0){
            $('.phone .data .box em').css({'background-position-x':'-60px','background-position-y':"-107px"});
            $('.phone .data .box label.bind_tel_phone').text("未认证");
            $('.phone .data .box label.bind_tel_phone').css({"color":"crimson"});
            $('.phone .data .box a.setUp').show();
            $('.phone .data .box a.already_set_tel').hide();
        }else{
            $('.phone .data .box em').css({'background-position-x':'0px','background-position-y':"-107px"});
            $('.phone .data .box label.bind_tel_phone').text(data.userInfo.TELLPHONE);
            $('.phone .data .box label.bind_tel_phone').css({"color":"#494A5F"});
            $('.phone .data .box label.change_bind_tel_phone').text("修改");
            $('.phone .data .box a.already_set_tel').show();
            $('.phone .data .box a.setUp').hide();
        }
        //是否已实名认证
        if(data.userInfo.IS_AUTH_STATUS == 0){
            $('.realName .data .box em').css({'background-position-x':'-60px','background-position-y':"-107px"});
            $('.realName .data .box label.realNames').text("未实名认证");
            $('.realName .data .box label.realNames').css({"color":"crimson"});
            $('.realName .data .box a.setUp').show();
            $('.realName .data .box a.already_realName').hide();
        }else{
            $('.realName .data .box em').css({'background-position-x':'0px','background-position-y':"-107px"});
            $('.realName .data .box label.realNames').text("已实名认证");
            $('.realName .data .box label.realNames').css({"color":"#494A5F"});
            $('.realName .data .box a.already_realName').show();
            $('.realName .data .box a.setUp').hide();
        }
        //是否已设置交易密码
        if(data.userInfo.IS_PAYPWD_STATUS == 0){
            $('.payword .data .box em').css({'background-position-x':'-60px','background-position-y':"-107px"});
            $('.payword .data .box label.set_pay_pass').text("未设置交易密码");
            $('.payword .data .box label.set_pay_pass').css({"color":"crimson"});
            $('.payword .data .box a.set').show();
            $('.payword .data .box a.change').hide();
        }else{
            $('.payword .data .box em').css({'background-position-x':'0px','background-position-y':"-107px"});
            $('.payword .data .box label.set_pay_pass').text("已设置");
            $('.payword .data .box label.set_pay_pass').css({"color":"#494A5F"});
            $('.payword .data .box a.change').show();
            $('.payword .data .box a.set').hide();
        }
        //是否已绑定银行卡
        if(data.userInfo.IS_BIND_BANKCARD == 0){
            $('.card .data .box em').css({'background-position-x':'-60px','background-position-y':"-107px"});
            $('.card .data .box label.bind_bank_card').text("未绑定银行卡");
            $('.card .data .box label.bind_bank_card').css({"color":"crimson"});
            $('.card .data .box a.set').show();
            $('.card .data .box a.change').hide();

        }else{
            $('.card .bankInfo').show();
            $scope.bankInfos = data.bankCardList;
            $('.card .data .box em').css({'background-position-x':'0px','background-position-y':"-107px"});
            $('.card .data .box label.bind_bank_card').text("已绑定 "+ data.bankCardList.length  +" 张银行卡");
            $('.card .data .box label.bind_bank_card').css({"color":"#494A5F"});
            $('.card .data .box a.change').show();
            $('.card .data .box a.set').hide();
        }
    }).error(function(data){
        console.log("获取失败！");
    });
});
