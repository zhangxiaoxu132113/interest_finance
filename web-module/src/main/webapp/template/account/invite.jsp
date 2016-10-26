<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/23
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<script type="text/javascript" src="/asset/js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="/asset/js/clipboard.min.js"></script>

<!-- usercontent-->
<div class="usercon" ng-controller="inviteCtrl">
  <div class="myinvite">
    <div class="itemtitle"><span>我的推广</span></div>
    <ul>
      <li>累计奖励（元）：<span>0</span></li>
      <li>成功推荐（人）：<span>0</span></li>
      <li>累计推荐（人）：<span>{{invitecount}}</span></li>
    </ul>
  </div>
  <div class="mylink">
    <div class="itemtitle">
      <span>我的推广</span>
      <div class="linkbox">localhost:8080/user/invite/register/${global_user.INVITECODE}.html</div>
      <a href="javascript:void(0);" class="inviteBtn" data-clipboard-text="">复制</a>
    </div>
  </div>
  <div class="mylist">
    <div class="itemtitle">
      <span>推荐列表</span>
      <a class="rule" href="">奖励规则</a>
    </div>
    <div class="carsousel_body">
      <input type="hidden" name="userId" >
      <table>
        <tr>
          <th>被推荐人</th>
          <th>注册时间</th>
          <th>首投金额</th>
          <th>产品期限</th>
          <th>审核状态</th>
        </tr>
        <tr ng-repeat="item in invites">
          <td>{{item.USERNAME}}</td>
          <td>{{item.CREATETIME | date:'yyyy-MM-dd HH:mm:ss'}}</td>
          <td>XXXX</td>
          <td>XXXX</td>
          <td>XXXX</td>
        </tr>
      </table>
    </div>
    <div ng-if="invites.length == 0" style="text-align: center;font-size: 16px;color:#686766;">
      无！
    </div>
  </div>
</div>


<script>
  $(document).ready(function() {

    //点击复制邀请链接事件
    $('.inviteBtn').click(function(){
      var cb = new Clipboard('.inviteBtn');//实例化复制
      $('.inviteBtn').attr('data-clipboard-text', $('.linkbox').text());
      alert("复制成功！");
    });

  });

</script>