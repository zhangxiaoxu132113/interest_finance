<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/10
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--footer-->
<div class="footer">
    <div class="copyright">
        <div class="footer_logo">

            <%--<i><img src="/asset/img/logo_03.png" width="100%"/></i>--%>
            <c:forEach var="partner" items="${resultJson.partners}">
                <%--用EL表达式调用list对象的属性循环输出对象的各个属性值--%>
                    <a href="http://${partner.URL}"><i><img style="border-radius: 5px" src="${partner.IMGURL}" width="100%" height="71"/></i></a>
            </c:forEach>
            <%--<i><img src="/asset/img/logo_03.png" width="100%"/></i>--%>
            <%--<i><img src="/asset/img/logo_03.png" width="100%"/></i>--%>
            <%--<i><img src="/asset/img/logo_03.png" width="100%"/></i>--%>
            <%--<i><img src="/asset/img/logo_03.png" width="100%"/></i>--%>
            <div style="display: block;clear: both"></div>
        </div>
        <div class="aboutus" style="float: right;">
            <p class="ab">公司简介&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 使用帮助</p>
            <div class="aboutus_logo">logo</div>
            <p class="ab">客服电话：4000-xxx-xxx</p>
        </div>
        <div class="aboutus">
            <p>备案号：粤ICP备16049915号</p>
            <p>copyright@2015深圳前海艾德信科技有限公司 版权所有</p>
        </div>
        
    </div>
</div>
