<%--
  Created by IntelliJ IDEA.
  User: Meng Sheng
  Date: 2016/9/19
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<script type="text/javascript" src="/asset/js/jquery-1.9.0.min.js"></script>
<!-- usercontent-->
<div class="usercon" ng-controller="integralCtrl">
  <div class="integral">
    <div class="itemtitle"><span>我的积分</span></div>
    <ul>
      <li>可用积分：<span>{{available_integral}}</span></li>
      <li>
        <p>本月获得：<span>{{sum_month_integral}}</span></p>
        <p>累计获得：<span>{{sum_integral}}</span></p>
      </li>
      <li><a href=""><div>积分换礼</div></a></li>
    </ul>
  </div>
  <div class="detail">
    <div class="itemtitle">
      <span>积分明细</span>
      <a class="rule" href="">积分规则</a>
    </div>
    <table>
      <tr>
        <th>时间</th>
        <th>来源</th>
        <th>积分动态</th>
        <th>积分合计</th>
      </tr>
      <tr ng-repeat="item in integrals">
        <td>{{item.CREATETIME | date:'yyyy-MM-dd HH:mm:ss'}}</td>
        <td>{{item.SOURCE}}</td>
        <td ng-if="item.SCORE_TYPE == 1">+{{item.SCORE}}</td>
        <td ng-if="item.SCORE_TYPE == 0">-{{item.SCORE}}</td>
        <td>{{item.TOTAL_INTEGRAL}}</td>
      </tr>
    </table>
    <div ng-if="integrals.length == 0" style="text-align: center;font-size: 16px;color:#686766;">
      无！
    </div>
  </div>
</div>