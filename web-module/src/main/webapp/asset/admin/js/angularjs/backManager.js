/**
 * Created by Administrator on 2016/8/22.
 */
var app = angular.module("backManagerApp",['ui.router']);

app.config(["$stateProvider", "$urlRouterProvider", "$httpProvider", function($stateProvider,$urlRouterProvider,$httpProvider){

    $urlRouterProvider.otherwise("/dashboard");
    $stateProvider
        .state('dashboard',{
            url:"/dashboard",
            templateUrl:"/template/admin/dashboard.html"
        })
        //网站管理
        .state('webSetting',{
            url:"/webSetting",
            templateUrl:"/template/admin/webManager/setting.html"
        })
        .state('webCarsouel',{
            url:"/webCarsouel",
            templateUrl:"/template/admin/webManager/carousel.html"
        })
        .state('addCarouselImg',{
            url:"/addCarouselImg",
            templateUrl:"/template/admin/webManager/addCarouselImg.html"
        })
        .state('updateCarouselImg',{
            url:"/updateCarouselImg",
            templateUrl:"/template/admin/webManager/updateCarouselImg.html"
        })
        .state('links',{
            url:"/links",
            templateUrl:"/template/admin/webManager/links.html"
        })
        .state('addLinks',{
            url:"/addLinks",
            templateUrl:"/template/admin/webManager/addLink.html"
        })
        .state('updateLink',{
            url:"/updateLink",
            templateUrl:"/template/admin/webManager/updateLink.html"
        })
        .state('parents',{
            url:"/parents",
            templateUrl:"/template/admin/webManager/parents.html"
        })
        .state('addParents',{
            url:"/addParents",
            templateUrl:"/template/admin/webManager/addParent.html"
        })
        //文章管理
        .state('articleList',{
            url:"/articleList",
            templateUrl:"/template/admin/articleManager/articleList.html"
        })
        .state('addArticle',{
            url:"/addArticle",
            templateUrl:"/template/admin/articleManager/addArticle.html"
        })
        .state('updateArticle',{
            url:"/updateArticle",
            templateUrl:"/template/admin/articleManager/updateArticle.html"
        })
        .state('articleModule',{
            url:"/articleModule",
            templateUrl:"/template/admin/articleManager/articleModule.html"
        })
        .state('addArticleModule',{
            url:"/addArticleModule",
            templateUrl:"/template/admin/articleManager/addArticleModule.html"
        })
        .state('updateArticleModule',{
            url:"/updateArticleModule",
            templateUrl:"/template/admin/articleManager/updateArticleModule.html"
        })
        //第三方平台管理
        .state('platfromList',{
            url:"/platfromList",
            templateUrl:"/template/admin/platfromManager/platfromList.html"
        })
        .state('addPlatfromInfo',{
            url:"/addPlatfromInfo",
            templateUrl:"/template/admin/platfromManager/addPlatfromInfo.html"
        })
        .state('updatePlafromInfo',{
            url:"/updatePlafromInfo",
            templateUrl:"/template/admin/platfromManager/updatePlafromInfo.html"
        })
        .state('produceList',{
            url:"/produceList",
            templateUrl:"/template/admin/platfromManager/produceList.html"
        })
        .state('addProduceInfo',{
            url:"/addProduceInfo",
            templateUrl:"/template/admin/platfromManager/addProduceInfo.html"
        })
        .state('updateProduceInfo',{
            url:"/updateProduceInfo",
            templateUrl:"/template/admin/platfromManager/updateProduceInfo.html"
        })
        .state('addApi',{
            url:"/addApi",
            templateUrl:"/template/admin/platfromManager/addApi.html"
        })
        .state('apiList',{
            url:"/apiList",
            templateUrl:"/template/admin/platfromManager/apiList.html"
        })
        //权限管理
        .state('userList',{
            url:"/userList",
            templateUrl:"/template/admin/popemManager/userList.html"
        })
        .state('addUser',{
            url:"/addUser",
            templateUrl:"/template/admin/popemManager/addUser.html"
        })
        .state('popemList',{
            url:"/popemList",
            templateUrl:"/template/admin/popemManager/popemList.html"
        })
        .state('addPopem',{
            url:"/addPopem",
            templateUrl:"/template/admin/popemManager/addPopem.html"
        })
        //投资管理模块
        .state('addRebate',{
            url:"/addRebate",
            templateUrl:"/template/admin/fundsManagement/addRebate.html"
        })
        .state('rebateList',{
            url:"/rebateList",
            templateUrl:"/template/admin/fundsManagement/rebateList.html"
        })

    ;

}]);

/**
 * ckeditor Directive
 * @author Mr Water
 */
app.directive('ckeditor', function() {
    return {
        require : '?ngModel',
        link : function(scope, element, attrs, ngModel) {
            var ckeditor = CKEDITOR.replace(element[0], {

            });
            if (!ngModel) {
                return;
            }
            ckeditor.on('instanceReady', function() {
                ckeditor.setData(ngModel.$viewValue);
            });
            ckeditor.on('pasteState', function() {
                scope.$apply(function() {
                    ngModel.$setViewValue(ckeditor.getData());
                });
            });
            ngModel.$render = function(value) {
                ckeditor.setData(ngModel.$viewValue);
            };
        }
    };
});

/**网站设置控制器*/
app.controller("webSettingCtrl",function($scope,$http){
    $scope.webDescription = "";
    $scope.webKey = "";
    $scope.webTitle = "";

    $http({
        url:"/webManager/findSetting",
        method:"GET"
    })
        .success(function(data) {
            $scope.webDescription = data.WEB_DESCRIPTION;
            $scope.webKey = data.WEB_KEY;
            $scope.webTitle = data.INDEX_TITLE;
        })
        .error(function(data) {
            console.log(data);
        });

    /**
     * 保存网站设置
     */
    $scope.submit = function() {
        console.log("in submit function!");
        var webDesc = $scope.webDescription;
        $http({
            url:"/webManager/saveSetting",
            method:"POST",
            params:{
                webDescription:$scope.webDescription,
                webKey:$scope.webKey,
                webTitle:$scope.webTitle
            }

        })
            .success(function(data) {
                var status = data.status;
                if (status == 0) {//保存成功
                    swal({
                        title: "保存成功!",
                        text: "成功保存网站设置信息",
                        type:"success",
                        timer: 1500
                    });
                } else if (status == 1) {//保存失败
                    alert("保存失败！");
                }
            })
            .error(function(data) {
                console.log(data);
                alert("保存失败！");
            });
    }



});

/**网站轮播控制器*/
app.controller("webCarouselCtrl",function($scope,$http,$rootScope){


    $scope.carsouelImgs = [];       //轮播图片数组
    $scope.carsouelImg = {};        //轮播图片对象
    //添加轮播图片的信息
    $scope.urlAddr = "";
    $scope.imgUrl = "";
    $scope.sortBy = "";


    $scope.carsouelImg = $rootScope.carsouelImg;
    /**获取轮播图片的数据*/
    var findCarouselImgs = function(){

        if ($scope.carsouelImgs >0) return;
        $http({
            url:"/webManager/findCarouselImgs",
            method:"GET"
        })
            .success(function(data){
                $scope.carsouelImgs = data;
                console.log(data);
            })
            .error(function(data){
                console.log("data = " + data);
            });
    };
    findCarouselImgs();

    /**上传图片*/
    $('.uploadFiles').bind('change',function(){
        console.log("in upload method!");
        setJsonBySubmit($('#uploadMultiFiles'),"hidden_frame",function(obj){
            //设置上传的图片的url地址
            $scope.imgUrl = obj.imgSrc;
            console.log(obj.imgSrc);
        });
    });

    /**添加首页面轮播图片*/
    $scope.submitCarsourl = function() {
        //TODO 校验用户的输入信息
        $http({
            url:"/webManager/addCarouselImg",
            method:"POST",
            params:{
                urlAddr:$scope.urlAddr,
                imgUrl:$scope.imgUrl,
                sortBy:$scope.sortBy

            }
        }).success(function(data){

            var status = data.status;
            //1,提示保存成功
            if (status == 0) {
                alert("保存成功!");
            } else if(status == 1) {
                alert("保存失败!");
            }
            //2,清空内容
            $scope.urlAddr = "";
            $scope.imgUrl = "";
            $scope.sortBy = "";
            $('#uploadMultiFiles').val("");
        }).error(function(data){
            console.log("save failure!");
        })


    }

    /**删除轮播图片*/
    $scope.removeItem = function(index,item) {
        console.log(item.ID);
        $http({
            url:"/webManager/deleteCarouselById",
            method:"DELETE",
            params:{
                carouselId:item.ID
            }
        }).success(function(data){
            //在界面上移除该该对象
            $scope.carsouelImgs.splice(index,1);
        }).error(function(data){
            alert("删除失败!");
        });

    };

    /**跳转到更新数据的页面*/
    $scope.redirect2UpdatePage = function(index,item) {

        window.location.href = "#updateCarouselImg";
        $rootScope.carsouelImg = item;
        console.log($rootScope.carsouelImg);
    };

    /**更新数据*/
    $scope.updateItem = function(item) {

        var imgUrl = "";
        if ($scope.imgUrl == "") {
            imgUrl = $(".carsousel_imgurl").val();
        } else {
            imgUrl = $scope.imgUrl;
        }

        $http({
            url:"/webManager/updateCarouselImg",
            method:"POST",
            params:{
                urlAddr : item.URL,
                imgUrl  : imgUrl,
                sortBy  : item.SORTORDER,
                carouselId : item.ID
            }
        })
            .success(function(data) {
                console.log(data);
                var status = data.status;
                if (status == 0) {
                    //更新成功提示
                    swal({
                        title: "更新成功！!",
                        text : "更新数据成功！!",
                        type : "success",
                        timer: 1500
                    });
                    setTimeout(function() {
                        window.location.href = "#webCarsouel";
                    },1600);

                } else if (status == 1) {
                    //更新失败
                    alert("更新失败！");
                }
            })
            .error(function(data) {
                console.log(data);
            });
    }

});

/**友情链接控制器*/
app.controller("webLinksCtrl",function($scope, $http,$rootScope) {

    $scope.links = [];
    $scope.linkName = "";
    $scope.linkUrl = "";
    $scope.sortBy = "";

    /**获取友情链接的列表*/
    $http({
        url:"/webManager/findLinks",
        method:"GET"
    }).success(function(data){
        $scope.links = data;
    }).error(function(data){
        console.log(data);
    });
    /** 添加友情链接 */
    $scope.addLinks = function() {
        $http({
            url:"/webManager/addLink",
            method:"POST",
            params:{
                linkName:$scope.linkName,
                linkUrl:$scope.linkUrl,
                sortBy:$scope.sortBy
            }
        }).success(function(data){
            var status = data.status;
            if (status == 0) {

                //提示保存成功的信息!
                alert("保存成功!");
                //清空文本输入框的内容
                //$scope.linkName = "";
                //$scope.linkUrl = "";
                //$scope.sortBy = "";
                window.location.href = "#links";
            }

        }).error(function(data){
            alert("保存失败!");
        });
    }

    /**跳转到更新友情链接的页面*/
    $scope.redirect2UpdateLink = function(index, item) {

        $rootScope.newLink = {};//更新友情链接的对象
        $rootScope.updateLinkID  = item.ID;//更新的友情链接ID
        $rootScope.newLinkName  = item.DESCRIPTION;
        $rootScope.newLinkUrl   = item.URL;
        $rootScope.newSortBy    = item.SORTORDER;

        window.location.href = "#updateLink";
    };

    /** 更新友情链接 */
    $scope.updateLink = function() {
        $http({
            url:"/webManager/updateLink",
            method:"POST",
            params:{
                linkName:$scope.newLinkName,
                linkUrl:$scope.newLinkUrl,
                sortBy:$scope.newSortBy,
                itemID:$scope.updateLinkID
            }
        }).success(function(data){
            var status = data.status;
            if (status == 0) {

                //提示保存成功的信息!
                alert("保存成功!");
                window.location.href = "#links";
            }

        }).error(function(data){
            alert("保存失败!");
        });
    }

    /**移除友情链接*/
    $scope.removeItem = function(index,item) {

        $http({
            url:"/webManager/removeLink",
            method:"DELETE",
            params:{
                linkId:item.ID
            }
        }).success(function(data) {
            $scope.links.splice(index,1);
        }).error(function(data) {
            alert("删除失败!");
        });

    }
});

/**网站合作控制器*/
app.controller("webParentsCtrl",function($scope,$http) {

    $scope.partners = [];
    $scope.partnerName = "";
    $scope.partnerLinkUrl = "";
    $scope.partnerImgUrl = "";
    $scope.partnerSortBy = "";

    /**查询平台的合作伙伴的列表*/
    $http({
        url:"/webManager/findPartners",
        method:"GET"
    }).success(function(data){

        console.log(data);
        $scope.partners = data;
    }).error(function(data){
        console.log(data);
    });

    /**上传图片*/
    $('.uploadFiles').bind('change',function(){
        console.log("in upload method!");
        setJsonBySubmit($('#uploadMultiFiles'),"hidden_frame",function(obj){
            //设置上传的图片的url地址
            $scope.partnerImgUrl = obj.imgSrc;
            console.log(obj.imgSrc);
        });
    });
    /**添加合作伙伴*/
    $scope.addPartner = function() {

        //TODO 校验输入的合法性
        $http({
            url:"/webManager/addPartner",
            method:"POST",
            params:{
                partnerName   : $scope.partnerName,
                partnerLinkUrl: $scope.partnerLinkUrl,
                partnerImgUrl : $scope.partnerImgUrl,
                partnerSortBy : $scope.partnerSortBy
            }
        }).success(function(data){
            var status = data.status;
            if (status == 0) {
                //保存成功提示
                alert("保存成功!");
                $scope.partnerName = "";
                $scope.partnerLinkUrl = "";
                $scope.partnerImgUrl = "";
                $scope.partnerSortBy = "";
            } else if (status == 1) {
                alert("保存失败!");
            }
        }).error(function(data){
                alert("保存失败!");
        });
    }

    /**删除合作伙伴*/
    $scope.removeItem = function(index,item) {
        $http({
            url:"/webManager/removePartnerById",
            method:"DELETE",
            params:{
                partnerId:item.ID
            }
        }).success(function(data){
            console.log(data);
            var status = data.status;
            if (status == 0) {
                $scope.partners.splice(index,1);
            } else if (status == 1) {
                alert("删除失败!");
            }
        }).error(function(data){
            console.log(data);
        });
    }
});

/**文章控制器*/
app.controller("articleCtrl",function($scope,$http,$rootScope) {

    $scope.articles = [];             //文章列表
    $scope.article = {};              //文章对象
    $scope.newArticle = {};           //需要更新的文章对象
    $scope.articleModuleList = [];    //文章分类列表
    $scope.module_partent    = "";    //文章分类父节点
    $scope.article.title     = "";    //文章标题
    $scope.article.author    = 12;    //文章作者
    $scope.article.summary   = "";    //文章简介
    $scope.article.module    = "";    //文章所属模块
    $scope.article.content   = "";    //文章内容
    $scope.article.thumbnail = "";    //文章的缩略图
    $scope.article.isThumbnail = "";  //文章的缩略图
    $scope.article.isTop = "";        //文章的缩略图

    $scope.queryArticleModule = 0;    //文章查询条件-文章模块
    $scope.queryArticleTitle = "";    //文章查询条件-文章标题

    $scope.newArticle = $rootScope.newArticle;

    /**获取文章信息列表*/
    var getArticleList = function() {
        $http({
            url:"/article/list",
            method:"GET"

        }).success(function (data){
            console.log(data);
            $scope.articles = data;
        }).error(function (data){
            console.log(data);
        });
    }
    getArticleList();

    /**获取文章分类信息列表*/
    var getArticleModuleList = function() {
        $http({
            url:"/article/getAllArticleModule",
            metohd:"GET"
        }).success(function(data){
            $scope.articleModuleList = data;
            console.log(data);
        }).error(function(data){
            console.log(data);
        });
    };
    getArticleModuleList();

    /**获取下拉选的值*/
    $scope.moduleSelectedChange = function(module) {
        $scope.article.module = module;
    };

    /**添加文章*/
    $scope.addArticle = function(article) {
        //判断下拉选的值
        if (article.module == "" || article.module == undefined) {
            article.module = 0;
        }
        article.thumbnail = $scope.article.thumbnail;
        console.log($scope.article);
        $http({
            url:"/article/add",
            method:"POST",
            data:article
        }).success(function(data){
            var status = data.status;

            if (status == 0) {
                //提示框，提示保存成功！
                swal({
                    title: "保存成功!",
                    text: "成功添加文章【"+article.title+"】",
                    type:"success",
                    timer: 1500
                });
                //清空内容
                $scope.article = {};
            } else if (status == 1) {
                alert("保存失败!");
            }
            console.log(data);
        }).error(function(data){
            console.log(data);
        });
    }

    /**删除文章*/
    $scope.removeItem = function(index,item) {

        console.log("article = "+item.ARID);
        $http({
            url:"/article/remove",
            method:"DELETE",
            params:{
                articleId:item.ARID
            }
        }).success(function(data) {
            var status = data.status;
            if (status == 0) {
                alert("删除成功!");
                $scope.articles.splice(index,1);

            } else if (status == 1) {
                alert("删除失败!");
            }
        }).error(function(data) {

        });
    };

    /**跳转到更新文章的页面*/
    $scope.redirect2UpdatePage = function(index, item) {

        $rootScope.newArticle = {};
        $rootScope.newArticle.title     = item.TITLE;
        $rootScope.newArticle.module    = item.ARTICLE_MODULE;
        $rootScope.newArticle.summary   = item.SUMMARY;
        $rootScope.newArticle.content   = item.CONTENT;
        $rootScope.newArticle.articleId = item.ARID;
        $rootScope.newArticle.author    = item.CREATEUSERID;

        window.location.href = "#updateArticle";
    };

    /**更新文章*/
    $scope.updateArticle = function(article) {
        console.log("需要更新的信息");
        console.log(article);
        $http({
            url:"/article/update",
            method:"POST",
            data:article
        })
            .success(function(data) {
                console.log(data);
                var status = data.status;
                if (status == 0) {
                    //更新成功
                    swal({
                        title: "更新成功!",
                        text: "成功更新标题为【"+article.title+"】的文章",
                        type:"success",
                        timer: 2000
                    });
                    $rootScope.newArticle = {};
                    setTimeout(function(){
                        window.location.href = "#articleList";
                    },2200);

                } else if (status == 1) {
                    //更新失败
                    alert("更新失败！");

                }
            })
            .error(function(data) {
                console.log(data);
            });
    };

    /**查询功能，根据文章的模块选择查询*/
    $scope.moduleSelectedQueryChange = function(articleModuel) {
        console.log(articleModuel);
        $scope.queryArticleModule = articleModuel;
    };

    $scope.queryArticle = function() {
        $http({
            url:"/article/query",
            method:"POST",
            params:{
                articleModule:$scope.queryArticleModule,
                articleTitle:$scope.queryArticleTitle
            }
        })
            .success(function(data) {
                $scope.articles = data;
            })
            .error(function(data) {
                console.log(data);
            });
    };

    /***/
    $('.article_thumbnail').bind('change',function() {
        setJsonBySubmit($('#uploadMultiFiles'),"hidden_frame",function(obj){
            //设置上传的图片的url地址
            $scope.article.thumbnail = obj.imgSrc;
            console.log(obj.imgSrc);
            $('#artcle_thumbnail_src').attr("src","/"+obj.imgSrc);
            $('#artcle_thumbnail_src').css('display','block');
            $('#setting_thumbnail').css('display','block');
        });
    });
});

/**文章模块控制器*/
app.controller("articleModuleCtrl",function($scope, $http, $rootScope) {

    $scope.articleModuleList = [];
    //$scope.modulesSelected = [];   //

    $scope.module_name = "";
    $scope.module_partent = "";
    $scope.module_code = "";
    $scope.sortorder = "";
    $scope.remark = "";

    /**获取文章分类信息列表*/
    var getArticleModuleList = function() {
        $http({
            url:"/article/getAllArticleModule",
            metohd:"GET"
        }).success(function(data){
            $scope.articleModuleList = data;
            console.log(data);
        }).error(function(data){
            console.log(data);
        });
    };
    getArticleModuleList();


    /**监听下拉选的事件*/
    $scope.moduleSelectedChange = function(module_partent) {
        console.log("module_partent : "+module_partent);
        $scope.module_partent = module_partent;
    }

    /**添加文章分类*/
    $scope.addArticleModule = function() {
        console.log("in add ArticleModule !");
        //判断下拉选的值
        if ($scope.module_partent == "" || $scope.module_partent == undefined) {
            $scope.module_partent = 0;
        }
        console.log($scope.module_partent);
        $http({
            url:"/article/addModule",
            method:"POST",
            params:{
                module_code    : $scope.module_code,
                module_name    : $scope.module_name,
                module_partent : $scope.module_partent,
                sortorder      : $scope.sortorder,
                remark         : $scope.remark
            }
        }).success(function(data){
            var status = data.status;
            if (status == 0) {
                alert("保存成功!");
                getArticleModuleList();
                //清空内容
                //$scope.module_name = "";
                //$scope.module_partent = "";
                //$scope.module_code = "";
                //$scope.sortorder = "";
                //$scope.remark = "";
                window.location.href = "#articleModule";
            } else if (status == 1) {
                alert("保存失败!");
            }
        }).error(function(data){
            console.log(data);
        });
    }

    /**跳转到更新文章分类的页面*/
    $scope.redirect2UpdateArticleModules = function(index, item) {

        $rootScope.newArticleModules = {};    //新修改的文章分类对象
        $rootScope.newArticleModules.am_Id = item.AMID;
        $rootScope.newArticleModules.module_name = item.MODULE_NAME;
        $rootScope.newArticleModules.module_partent = item.PARTENT_MODULE;
        $rootScope.newArticleModules.module_code = item.MODULE_CODE;
        $rootScope.newArticleModules.sortorder = item.SORTORDER;
        $rootScope.newArticleModules.remark = item.REMARK;

        window.location.href = "#updateArticleModule";
    };

    /**更新文章分类*/
    $scope.updateArticleModule = function(newArticleModule) {
        console.log("in update ArticleModule !");
        //判断下拉选的值
        if (newArticleModule.module_partent == "" || newArticleModule.module_partent == undefined) {
            newArticleModule.module_partent = 0;
        }
        console.log("newArticleModule:"+newArticleModule);
        $http({
            url:"/article/updateModule",
            method:"POST",
            data:newArticleModule
        }).success(function(data){
            var status = data.status;
            if (status == 0) {
                $rootScope.newArticleModules = {};
                alert("保存成功!");
                getArticleModuleList();
                window.location.href = "#articleModule";
            } else if (status == 1) {
                alert("保存失败!");
            }
        }).error(function(data){
            console.log(data);
        });
    }

    $scope.removeItem = function(index,item) {
        $http({
            url:"/article/deleteModule",
            method:"DELETE",
            params:{
                moduleId:item.AMID
            }
        }).success(function(data){
            //在界面上移除该该对象
            var status = data.status;
            if (status == 0) {
                alert("删除成功!");
                $scope.articleModuleList.splice(index,1);
            } else if (status == 1) {
                alert("删除失败!");
            }
        }).error(function(data){
            alert("删除失败!");
        });
    }
});

/**平台管理控制器*/
app.controller("platfromCtrl",function($scope,$http,$rootScope) {
    /** 定义*/
    $scope.platformList = [];
    $scope.platformBackgroundList = [];
    $scope.platform = {};
    /** 第三方平台的 logo*/
    $scope.platform.logoImg = "";

    /**获取平台信息的数据列表*/
    var getPlatfromList = function() {
       $http({
           url:"/platform/list",
           method:"GET"
       })
           .success(function(data) {
               $scope.platformList = data;
               console.log(data);
           })
           .error(function(data){
               console.log(data);

           });
    };
    getPlatfromList();

    /**获取平台背景的所有类型*/
    var getPlatformBakcgroundList = function() {
        $http({
            url:"/platform/findPlatformBackgronud",
            method:"GET"
        })
            .success(function(data) {
                $scope.platformBackgroundList = data;
                console.log(data);
            })
            .error(function(data) {
                console.log(data);
            });
    };
    getPlatformBakcgroundList();

    /**上传图片*/
    $('.uploadFiles').bind('change',function(){
        console.log("in upload method!");
        setJsonBySubmit($('#uploadMultiFiles'),"hidden_frame",function(obj){
            //设置上传的图片的url地址
            $scope.platform.logoImg = obj.imgSrc;
            $scope.newPlatform.logoImg = obj.imgSrc;
            //在页面显示出来
            $("#platform_logo_img").css("display","none");
            $("#logo_img").css("display","block");
            $("#logo_img").attr("src","/"+obj.imgSrc);

            console.log("图片地址："+obj.imgSrc);
        });
    });
    /**添加平台信息*/
    $scope.addPlatfromInfo = function(platform) {

        platform.uptime = $('#flatpickr-tryme').val();
        console.log("添加平台信息:"+platform);

        $http({
            url:"/platform/add",
            method:"POST",
            data:platform
        })
            .success(function(data) {
                var status = data.status;
                if (status == 0) {
                    swal({
                        title: "保存成功!",
                        text: "成功录入平台【"+platform.pName+"】信息",
                        type:"success",
                        timer: 1500
                    });
                    $scope.platform = {};
                    //显示上传图片的选择按钮
                    $("#platform_logo_img").css("display","block");
                    $("#logo_img").css("display","none");
                    window.location.href = "#platfromList";
                } else if (status == 1) {
                    alert("保存失败！");
                }
                console.log(data);
            })
            .error(function(data) {
                console.log(data);
                alert("保存失败！");
            });
    }

    /**跳转到更新平台信息的页面*/
    $scope.redirect2UpdatePlatformPage = function(index, item) {

        $rootScope.newPlatform = {};    //新修改的平台对象
        $rootScope.newPlatform.id = item.ID;
        $rootScope.newPlatform.logoImg = item.LOGO_IMG;
        $rootScope.newPlatform.pBackground     = item.P_BACKGROUND;
        $rootScope.newPlatform.pName    = item.P_NAME;
        $rootScope.newPlatform.cName   = item.C_NAME;

        var registered_Capital = item.REGISTERED_CAPITAL;
        if(registered_Capital.indexOf("万") != -1){
            registered_Capital = registered_Capital.replace(/万/g,"0000");
        }
        $rootScope.newPlatform.registeredCapital   = registered_Capital;
        $rootScope.newPlatform.cAddress = item.C_ADDRESS;
        $rootScope.newPlatform.telPhone    = item.TEL_PHONE;
        $rootScope.newPlatform.urlAddress   = item.URL_ADDRESS;
        $rootScope.newPlatform.legalRepersentative   = item.LEGAL_REPERSENTATIVE;
        //$rootScope.newPlatform.uptime   = item.UPTIME;
        $rootScope.newPlatform.platformIntroduction    = item.PLATFORM_INTRODUCTION;
        $rootScope.newPlatform.windControlSituation = item.WIND_CONTROL_SITUATION;
        $rootScope.newPlatform.recommendedReason    = item.RECOMMENDED_REASON;

        window.location.href = "#updatePlafromInfo";
    };

    /**提交修改平台信息*/
    $scope.updatePlaformInfo = function(platform) {
        platform.uptime = $('#flatpickr-tryme').val();
            console.log("需要更新的信息");
            console.log(platform);
            $http({
                url:"/platform/update",
                method:"POST",
                data:platform
            })
                .success(function(data) {
                    console.log(data);
                    var status = data.status;
                    if (status == 0) {
                        //更新成功
                        swal({
                            title: "更新成功!",
                            text: "成功更新平台【"+platform.pName+"】",
                            type:"success",
                            timer: 2000
                        });
                        $rootScope.newPlatfrom = {};
                        //显示上传图片的选择按钮
                        $("#platform_logo_img").css("display","block");
                        $("#logo_img").css("display","none");
                        setTimeout(function(){
                            window.location.href = "#platfromList";
                        },2200);

                    } else if (status == 1) {
                        //更新失败
                        alert("更新失败！");

                    }
                })
                .error(function(data) {
                    console.log(data);
                });
        };


    /**移除对象*/
    $scope.removeItem = function(index, item) {

        console.log("ID = " + item.ID);
        if(confirm("您确定删除吗？")){
            $http({
                url:"/platform/remove",
                method:"DELETE",
                params:{
                    itemId:item.ID
                }
            }).
                success(function(data) {
                    var status = data.status;
                    if (status == 0) {
                        swal({
                            title: "删除成功!",
                            text : "成功删除平台【"+item.P_NAME+"】信息",
                            type : "success",
                            timer: 1500
                        });
                        //在界面上移除该该对象
                        $scope.platformList.splice(index,1);
                    } else if (status == 1) {
                        alert("删除失败！");
                    }
                })
                .error(function(data) {
                    console.log("删除失败!");
                });
        }

    }
});

/**标的产品控制器*/
app.controller("produceCtrl",function($scope, $http,$rootScope) {

    $scope.produceList = [];
    $scope.platformList = [];
    $scope.bidCategoryList = [];
    $scope.bearingWayList  = [];
    $scope.guaranteeWayList = [];
    $scope.repaymentWayList = [];
    $scope.produce = {};

    var getProduceList = function() {
        $http({
            url:"/produce/list",
            method:"GET"
        })
            .success(function(data) {
                $scope.produceList      = data.produceList;
                $scope.platformList     = data.platformList;
                $scope.bidCategoryList  = data.bidCategoryList;
                $scope.bearingWayList   = data.bearingWayList;
                $scope.guaranteeWayList = data.guaranteeWayList;
                $scope.repaymentWayList = data.repaymentWayList;
            })
            .error(function(data) {
                console.log(data);
            });
    };

    getProduceList();
    /**添加投标的信息*/
    $scope.addProduceInfo = function(produce) {

        console.log(produce);
        $http({
            url:"/produce/add",
            method:"POST",
            data:produce
        })
            .success(function(data) {
                var status = data.status;
                console.log(data);
                if (status == 0) {
                    swal({
                        title: "保存成功!",
                        text: "成功录入标【"+produce.name+"】信息",
                        type:"success",
                        timer: 2000
                    });
                    $scope.produce = {};
                    location.href = "#produceList";
                } else if (status ==1) {
                    alert("保存失败!");
                }
            })
            .error(function(data) {
                console.log(data);
            });
    }

    /**跳转到更新标信息的页面*/
    $scope.redirect2UpdateProducePage = function(index, item) {

        $rootScope.newProduce = {};    //新修改的标对象
        $rootScope.newProduce.id = item.ID;
        $rootScope.newProduce.name     = item.NAME;
        $rootScope.newProduce.platformId     = item.PLATFORMID;
        $rootScope.newProduce.module    = item.MODULE;
        $rootScope.newProduce.bearingWay   = item.BEARING_WAY;
        $rootScope.newProduce.totalCapital   = item.TOTALCAPITAL;
        $rootScope.newProduce.annualRate = item.ANNUALRATE;
        $rootScope.newProduce.selfAnnualRate    = item.SELF_ANNUALRATE;
        $rootScope.newProduce.term   = item.TERM;
        $rootScope.newProduce.startMount   = item.STARTAMOUNT;
        $rootScope.newProduce.safeGuardWay    = item.SAFEGUARD_WAY;
        $rootScope.newProduce.repaymentWay = item.REPAYMENT_WAY;
        $rootScope.newProduce.description    = item.DESCRIPTION;

        window.location.href = "#updateProduceInfo";
    };

    /**提交修改标信息*/
    $scope.updateProduceInfo = function(produce) {
        console.log("需要更新的信息");
        console.log(produce);
        $http({
            url:"/produce/update",
            method:"POST",
            data:produce
        })
            .success(function(data) {
                console.log(data);
                var status = data.status;
                if (status == 0) {
                    //更新成功
                    swal({
                        title: "更新成功!",
                        text: "成功更新标【"+produce.name+"】",
                        type:"success",
                        timer: 2000
                    });
                    $rootScope.newProduce = {};
                    setTimeout(function(){
                        window.location.href = "#produceList";
                    },2200);

                } else if (status == 1) {
                    //更新失败
                    alert("更新失败！");

                }
            })
            .error(function(data) {
                console.log(data);
            });
    };

    $scope.removeItem = function(index,item) {

        if(confirm("您确定删除吗？")) {
            $http({
                url: "/produce/remove",
                method: "DELETE",
                params: {
                    itemId: item.ID
                }
            })
                .success(function (data) {
                    var status = data.status;
                    if (status == 0) {
                        alert("删除成功！");
                        $scope.produceList.splice(index, 1);
                    } else if (status == 1) {
                        alert("删除失败！");
                    }
                })
                .error(function (data) {
                    alert("删除失败！");
                });
        }
    }
});


/**平台API控制器*/
app.controller("apiCtrl",function($scope, $http) {
    $scope.apiList = [];     //平台的API接口列表
    $scope.platformList = [];   //第三方平台名称列表
    $scope.apiType = [];        //第三方接口类型列表

    $http({
        url:"/platform/addApiWithInfo"
    })
        .success(function(data) {
            console.log(data);
            $scope.platformList = data.platformList;
            $scope.apiType      = data.apiTypeList;
        })
        .error(function(data) {
            console.log(data);
        });
    //获取平台的API接口列表
    var findApiList = function() {
        $http({
            url:"/platform/api/findPlatformApiList",
            method:"POST"
        })
            .success(function(data) {
                $scope.apiList = data;
                console.log(data);
            })
            .error(function(data) {
                console.log(data);
            });
    };
    findApiList();

    //查询API接口
    $scope.queryAPI = function(que_PNAME,que_APIFLAG) {
        if(que_PNAME == undefined){
            que_PNAME = -1;//为选择平台
        }
        if(que_APIFLAG == undefined){
            que_APIFLAG = -1;//未选择接口类型
        }
        $http({
            url:"/platform/api/queryAPI",
            method:"GET",
            params:{
                platformId:que_PNAME,
                apiFlag:que_APIFLAG
            }
        })
            .success(function(data) {
                console.log(data);
                $scope.apiList = data;
            })
            .error(function(data) {
                console.log(data);
            });
    };

    /**删除接口信息*/
    $scope.removeItem = function(index, item) {
        $http({
            url:"/platform/api/removeAPI",
            method:"GET",
            params:{
                itemId:item.ID
            }
        })
            .success(function(data) {
                var status = data.status;
                if (status == 0) {
                    alert("删除成功！");
                    //在界面上移除该该对象
                    $scope.apiList.splice(index,1);
                } else if (status == 1) {
                    alert("删除失败！");
                }
            })
            .error(function(data) {
                alert("删除失败！");
            });
    }

});

/**用户列表控制器*/
app.controller("userListCtrl",function($scope, $http) {

    $scope.genderList = [];     //性别列表
    $scope.departmentList = []; //部门列表
    $scope.politics = [];       //政治面貌列表
    $scope.marriages = [];      //婚姻状态
    $scope.jobName = [];        //婚姻状态

    $scope.empInfo = {};        //员工信息
    $scope.empInfoList = [];    //员工列表信息

    //获取数据字典列表
    var findUserSystemDDL = function() {
        $http({
            url:"/user/findUserSystemDDL",
            method:"GET"
        })
            .success(function(data) {
                console.log(data);
                $scope.genderList = data.genderList;
                $scope.departmentList = data.departmentList;
                $scope.politics = data.politics;
                $scope.marriages = data.marriages;
                $scope.jobName = data.jobName;
            })
            .error(function(data) {
                console.log(data);
            });
    };
    findUserSystemDDL();

    //获取用户列表
    var findUserList = function() {
        $http({
            url:"/user/empinfo/list",
            method:"GET"
        })
            .success(function(data) {
                $scope.empInfoList = data;
                console.log(data);
            })
            .error(function(data) {
                console.log(data);
            });
    };
    findUserList();

    /**添加员工信息*/
    $scope.addEmpInfo = function(empInfo) {

        empInfo.brithday = $('#flatpickr-tryme').val();
        console.log(empInfo);
        $http({
            url:"/user/addEmpInfo",
            method:"POST",
            data:empInfo
        })
            .success(function(data) {
                console.log(data);
                var status = data.status;
                if (status == 0) {
                    swal({
                        title: "保存成功!",
                        text: "成功添加【"+empInfo.employeeName+"】信息",
                        type:"success",
                        timer: 1500
                    });
                } else if (status == 1) {
                    alert("保存失败!");
                }

            })
            .error(function(data) {

                console.log(data);
                alert("保存失败!");
            });
    }

    /**删除员工信息*/
    $scope.removeItem = function(index, item) {
        $http({
            url:"/user/empInfo/remove",
            method:"DELETE",
            params:{
                itemId:item.ID
            }
        })
            .success(function(data) {
                var status = data.status;
                if (status == 0) {
                    swal({
                        title: "删除成功!",
                        text : "成功删除员工【"+item.EMPLOYEE_NAME+"】信息",
                        type : "success",
                        timer: 1500
                    });
                    //在界面上移除该该对象
                    $scope.empInfoList.splice(index,1);
                } else if (status == 1) {
                    alert("删除失败！");
                }
            })
            .error(function(data) {
                alert("删除失败！");
            });
    }
});

/**权限控制器*/
app.controller("popemCtrl",function($scope, $http) {

    $scope.role_name = "";          //角色名称
    $scope.role_flag = "";          //角色标志

    /**添加权限*/
    $scope.addPopem = function() {

        $http({
            url:"/user/addPopem",
            method:"POST",
            params:{
                role_name:$scope.role_name,
                role_flag:$scope.role_flag
            }
        })
            .success(function(data) {
                var status = data.status;
                if (status == 0) {
                    swal({
                        title: "保存成功!",
                        text: "成功添加【"+$scope.role_name+"】用户组",
                        type:"success",
                        timer: 1500
                    });
                } else if (status == 1) {
                    alert("保存失败！");
                }
            })
            .error(function(data) {
                console.log(data);
                alert("保存失败！");
            });
    }
});

/**资金管理控制器*/
app.controller("fundManagementCtrl", function($scope, $http) {

    $scope.bidList = [];                        //标的列表信息
    $scope.userInfoList = [];                   //用户列表信息

    $scope.rebateInfo = {};                     //投资返利的信息
    $scope.platformName = "";                   //平台的名称
    $scope.rebateInfo.investmentAmount = "";    //用户投资的资金
    $scope.rebateInfo.userId = 0;               //用户的主键ID
    $scope.rebateInfo.bidId = 0;                //平台的标的
    $scope.rebateInfo.platformReveue = "";      //标的所属平台的年化收益
    $scope.rebateInfo.platformId = "";          //标的所属平台的ID
    $scope.rebateInfo.selfPlatformReveue = "";  //标的本平台的年化收益

    $scope.userTelphoneList = [];               //用户的手机信息列表
    $scope.self_annualrate = 0.0;               //标的额外年化率
    $scope.annualrate = 0.0;                    //标的所属的平台的年化率

    /**获取投资返利的信息*/
    var getRebateInfoList = function() {

        $http({
            url:"/fundManager/getRebateList",
            method:"GET"
        })
            .success(function(data) {
                $scope.bidList = data.bidInfoList;
                //TODO 如果数据庞大的情况，这种做法是可取的
                $scope.userTelphoneList = data.userTelphoneList;
                console.log(data);
            })
            .error(function(data) {
                console.log(data);
            });
    };
    getRebateInfoList();

    /**标的选择发生变化的时候,响应的时间*/
    $scope.bidSelectChanges = function(bidId) {

        //没有选择的情况下
        if (bidId == 1) {
            $scope.platformName = "";
            return;
        }
        console.log(bidId);
        angular.forEach($scope.bidList, function(data,index,array){
            //data等价于array[index]
            if (data.ID == bidId) {
                $scope.platformName = data.P_NAME;
                $scope.self_annualrate = data.SELF_ANNUALRATE;
                $scope.annualrate = data.ANNUALRATE;
                $scope.rebateInfo.platformId = data.PLATFORMID;
                console.log("第三方平台的ID = " + $scope.rebateInfo.platformId);
                console.log("年化率 ：" + $scope.self_annualrate);
                console.log("第三方平台年化率 ：" + $scope.annualrate);

                /**更新应返现金额*/
                if ($scope.rebateInfo.investmentAmount != "") {
                    $scope.rebateInfo.platformReveue     = ($scope.investmentAmount * $scope.annualrate).toFixed(2);
                    $scope.rebateInfo.selfPlatformReveue = ($scope.investmentAmount * $scope.self_annualrate).toFixed(2);
                }

                return;
            }
        });
    }

    /**调用select2插件的方法*/
    $('.js-example-basic-single').select2();

    /**监听用户的输入的资金的变化*/
    $("#inv_amount").bind('input propertychange' ,function() {

        var amount = $("#inv_amount").val();
        $scope.investmentAmount = amount;
        if ($scope.self_annualrate != 0.0) {
            $scope.rebateInfo.platformReveue     = ($scope.annualrate * amount * 0.01).toFixed(2);
            $scope.rebateInfo.selfPlatformReveue = ($scope.self_annualrate * amount * 0.01).toFixed(2);
        }
    });

    /**监听用户输入的手机号码的实时变化，从而去访问服务器端获取数据*/
    /**$('body').on('input propertychange', '.select2-search__field', function() {

        // 密码检验
        var user_tel = $(".select2-search__field").val();
        if (user_tel.length < 5 || user_tel.length > 14) return;
        console.log(user_tel);
        queryUserTel(user_tel);
    });*/

    /**查询手机号码列表*/
    /**var queryUserTel = function(telPhone_num) {
        $http({
            url:'/user/queryTel',
            method:'GET',
            params:{
                user_tel:telPhone_num
            }
        })
            .success(function(data) {
                console.log(data);
                $scope.userTelphoneList = data;
            })
            .error(function(data) {
                console.log(data);
            });
    };*/

    /**监听数据的变化*/
    /**$scope.$watch('userTelphoneList',function(newValue,oldValue, scope){
        oldValue = newValue;
        console.log(oldValue);
        console.log(newValue);
    });*/

    /**添加用户投标的信息*/
    $scope.addRebate = function(rebateInfo) {

        rebateInfo.platformId = $scope.rebateInfo.platformId;
        console.log(rebateInfo);
        $http({
            url:'/user/addRebate',
            method:'POST',
            data:rebateInfo
        })
            .success(function(data) {
                var status = data.status;
                if (status == 0) {
                    $('.success_info').fadeIn(300,function(){
                        $('.success_info').fadeOut(3000);
                    });
                    //$scope.rebateInfo = {}; //清空信息
                } else if (status == 1) {
                    $('.fail_info').fadeIn(300,function(){
                        $('.fail_info').fadeOut(3000);
                    });
                }
                console.log(data);
            })
            .error(function(data) {
                    $('.fail_info').fadeIn(300,function(){
                        $('.fail_info').fadeOut(3000);
                    });
                    console.log(data);
            });
    };
});

/**第三方平台API控制器*/
app.controller("apiManagementCtrl", function($scope, $http) {

    $scope.platformApi = {};            //第三方平台的API接口
    $scope.platformApi.params = "";
    $scope.platformList = [];           //第三方平台数据列表
    $scope.apiType = [];                //第三方接口类型
    $scope.apiParamList = [];           //第三方平台的接口类型
    $scope.param_select = "";

    $http({
        url:"/platform/addApiWithInfo"
    })
        .success(function(data) {
            console.log(data);
            $scope.platformList = data.platformList;
            $scope.apiType      = data.apiTypeList;
            $scope.apiParamList = data.apiParamList;
        })
        .error(function(data) {
            console.log(data);
        });

    var showJson = "";  /**显示在界面的json格式*/
    var passJson = "";  /**传递到后台的json格式数据*/

    /**添加参数*/
    $scope.addParams = function() {
        var self_param_name = $("#select_api_params  option:selected").val();
        if (self_param_name == "") {
            alert("请选择输入框!");
            return;
        }
        var p_param_name = $('#p_param_name').val().trim();
        if (p_param_name == "") {
            alert("请输入参数的名字！");
            return;
        }

        console.log(self_param_name);
        console.log(p_param_name);

        if (showJson == "") {
            showJson = "{\""+p_param_name+"\":\"xxx\"}";
            passJson = "{\""+self_param_name+"\":\""+p_param_name+"\"}";
        } else {
            showJson = showJson.substring(0,showJson.length-1) + ",\""+p_param_name+"\":\"xxx\"}";
            passJson = passJson.substring(0,passJson.length-1) + ",\""+self_param_name+"\":\""+p_param_name+"\"}";

        }
        //显示到网页界面上
        $('.json-textarea-content').text(showJson);
        console.log(showJson);
        console.log(passJson);
    };

    /**放弃添加参数类型*/
    $scope.giveupParamSet = function() {
        showJson = "";  /**显示在界面的json格式*/
        passJson = "";  /**传递到后台的json格式数据*/
        $('.json-textarea-content').text("");
        $('#p_param_name').val("");
        $(".bg-mask").css("display","none");
        $("#addParamName").css("display","none");
        $('#mask-frame-id').removeClass('animated zoomIn');

    };
    /**完成添加参数的操作*/
    $scope.finishAddParams = function() {
        //给param属性赋值
        $scope.platformApi.params = passJson;
        //隐藏遮罩层
        $(".bg-mask").css("display","none");
        $("#addParamName").css("display","none");
        $('#mask-frame-id').removeClass('animated zoomIn');
        //显示到网页界面上
        $('.json-show-content').text(showJson);
    };

    /**添加平台API数据*/
    $scope.addPlatformApi = function(platformApi) {
        platformApi.params = $scope.platformApi.params;
        console.log(platformApi);
        $http({
            url:"/platform/api/add",
            method:"POST",
            data:platformApi
        })
            .success(function(data){
                var status = data.status;
                if (status == 0) {
                    //清空内容！
                    $scope.platformApi = {};
                    swal({
                        title: "添加成功!",
                        text: "成功添加标平台接口",
                        type:"success",
                        timer: 2000
                    });
                    window.location.href = "#apiList";
                } else {
                    alert("添加的接口信息已经重复！");
                }
            })
            .error(function(data){
                console.log(data);
            });
    };

    /**添加API接口参数的方法*/
    $scope.finishAddParamFlag = function(){
        var param_en_flag = $("#param-en-flag-id").val();
        var param_cn_flag = $("#param-cn-flag-id").val();
        if (param_cn_flag == "" && param_en_flag == "") {
            alert("参数不能为空！");
            return;
        }
        console.log(param_cn_flag+param_en_flag);
        $http({
            url:"/platform/api/addParamFlag",
            params:{
                param_en_flag:param_en_flag,
                param_cn_flag:param_cn_flag
            },
            method:"POST"
        })
            .success(function(data){
                //隐藏输入面板
                $('#addParamName').removeClass('animated flipInX');
                $('#addParamName').addClass('animated flipOutX',function(){
                    $(".addParamName").css("display","none");
                });
                //清空输入框的内容
                $("#param-en-flag-id").val("");
                $("#param-cn-flag-id").val("");
                console.log(data);
                var status = data.status;
                if (status == 0) {
                    $scope.apiParamList = data.apiParamList;
                } else if (status == 1) {
                    alert("添加失败！");
                }
            })
            .error(function(data){
                console.log(data);
            });

    };

    $scope.removeItem = function(item) {
        $http({
            url:"/platform/api/removeParamFlag",
            method:"DELETE",
            params:{
                name:item.name,
                description:item.description
            }
        }).success(function(data){
            console.log(data);
            var status = data.status;
            if (status == 0) {
                $scope.apiParamList = data.apiParamList;
                //隐藏面板
                //$('#manageParamName').removeClass('animated flipInX');
                //$('#manageParamName').addClass('animated flipOutX',function(){
                //    $(".manageParamName").css("display","none");
                //});
            } else if (status == 1) {
                alert("添加失败！");
            }

        }).error(function(data){
            console.log(data);
        });
    }

});
