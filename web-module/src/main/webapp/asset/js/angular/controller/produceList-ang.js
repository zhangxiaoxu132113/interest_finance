/**
 * Created by Administrator on 2016/9/2.
 */
var app = angular.module("produceListApp",['ui.router']);

app.controller("produceListCtrl",function($scope, $http) {

    $scope.produceList = [];
    $scope.platformBackgroundList = [];

    /**查询条件*/
    $scope.module = -1;
    $scope.startAmount = -1;
    $scope.platformBackgroundID = -1;
    $scope.returnRate = "";
    $scope.returnDate = "";


    $http({
        url:"/produce/list",
        method:"GET"
    })
        .success(function(data) {
            console.log(data);
            $scope.produceList = data.produceList;
            $scope.platformBackgroundList = data.platformBackgroundList;
            console.log("platformBackground = " +$scope.platformBackgroundList);
        })
        .error(function(data) {
            console.log(data);
        });

    var queryProduceByCondition = function () {

        $http({
            url:"/produce/query",
            method:"POST",
            params:{
                module:$scope.module,
                startAmount:$scope.startAmount,
                platformBackgroundID:$scope.platformBackgroundID,
                returnRate:$scope.returnRate,
                returnDate:$scope.returnDate
            }
        })
            .success(function(data) {
                $scope.produceList = data;
                console.log(data);
            })
            .error(function(data) {
                console.log(data);
            });
    }
    /**根据条件查询新手区和精选区*/
    $scope.selectZone = function(selectValue) {

        //新手专区
        if (selectValue == "comerZone") {
            $scope.module = 1;
        //精选专区
        } else if (selectValue == "selectZone") {
            $scope.module = 2;
        } else {
            return;
        }
        queryProduceByCondition();
    }

    /**根据起投金额来查询数据*/
    $scope.queryStartAmount = function(startAmount) {

        $scope.startAmount = startAmount;
        queryProduceByCondition();
    }

    /**根据背景来查询数据*/
    $scope.selectPBackground = function(platformBackgroundID,target) {

        $(target).addClass('active').siblings().removeClass('active');
        $scope.platformBackgroundID = platformBackgroundID;
        console.log("platformBackgroundID = " + platformBackgroundID);
        queryProduceByCondition();

    }

    /**根据年化率来查询数据*/
    $scope.selectReturnRate = function(returnRate) {

        $scope.returnRate = returnRate;
        queryProduceByCondition();
    }

    /**根据项目周期来查询数据*/
    $scope.selectRetuenDate = function(returnDate) {

        $scope.returnDate = returnDate;
        queryProduceByCondition();
    }



});
