<%--
  Created by IntelliJ IDEA.
  User: vitelon
  Date: 2016/9/16
  Time: 1:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<script type="text/javascript" src="/asset/js/jquery-1.9.0.min.js"></script>
<!-- usercontent-->
<div class="usercon"  ng-controller="tradLogCtrl">
  <div class="tradlog">
    <div class="itemtitle"><span>交易记录</span></div>
    <table>
      <tr>
        <th>交易类型</th>
        <th>交易金额</th>
        <th>资金总额</th>
        <th>可用余额</th>
        <th>冻结总额</th>
        <th>待收总额</th>
        <th>时间</th>
      </tr>
      <tr ng-repeat="item in tradLogs">
        <td>{{item.TYPE}}</td>
        <td>{{item.AMOUNT}}</td>
        <td>{{item.TOTALACCOUNT}}</td>
        <td>{{item.AVAILABLEBALANCE}}</td>
        <td>{{item.FREEZEWITHDRAWALS}}</td>
        <td>{{item.FREEZEREDATE}}</td>
        <td>{{item.t_createtime | date:'yyyy-MM-dd HH:mm:ss'}}</td>
      </tr>
    </table>
    <div ng-if="tradLogs.length == 0" style="text-align: center;font-size: 16px;color:#686766;">
      无！
    </div>
    <p class="unit">以上金额单位（元）</p>
  </div>
</div>