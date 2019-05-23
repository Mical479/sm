<%--
  Created by IntelliJ IDEA.
  User: 17578
  Date: 2019/5/23
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=8">
    <title>个人信息</title>
    <link rel="stylesheet" type="text/css" href="../css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../css/thems.css">
    <script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function () {
            //自适应屏幕宽度
            window.onresize = function () {
                location = location
            };

            var main_h = $(window).height();
            $('.hy_list').css('height', main_h - 45 + 'px');

            var main_w = $(window).width();
            $('.xjhy').css('width', main_w - 40 + 'px');

        });
    </script>
</head>

<body onLoad="Resize();">
<div id="right_ctn">
    <div class="right_m">
        <div class="hy_list">
            <div class="box_t">
                <span class="name">个人信息</span>
            </div>
            <div class="space_hx">&nbsp;</div>
            <div class="xjhy">
                <!--高级配置-->
                <ul class="hypz gjpz clearfix">
                    <li class="clearfix">
                        <span class="title">账户名：</span>
                        <div class="li_r">
                            <span class="title">${USER.account}</span>
                        </div>
                    </li>
                    <li class="clearfix">
                        <span class="title">状态：</span>
                        <div class="li_r">
                            <span class="title">${USER.status}</span>
                        </div>
                    </li>
                    <li class="clearfix">
                        <span class="title">部门：</span>
                        <div class="li_r">
                            <span class="title">${USER.department.name}</span>
                        </div>
                    </li>
                    <li class="clearfix">
                        <span class="title">姓名：</span>
                        <div class="li_r">
                            <span class="title">${USER.name}</span>
                        </div>
                    </li>
                    <li class="clearfix">
                        <span class="title">性别：</span>
                        <div class="li_r">
                            <span class="title">${USER.sex}</span>
                        </div>
                    </li>
                    <li class="clearfix">
                        <span class="title">身份证号：</span>
                        <div class="li_r">
                            <span class="title">${USER.idNumber}</span>
                        </div>
                    </li>
                    <li class="clearfix">
                        <span class="title">出生日期：</span>
                        <div class="li_r">
                            <span class="title"><fmt:formatDate value="${USER.bornDate}" pattern="yyyy-MM-dd"/></span>
                        </div>
                    </li>
                    <li class="clearfix">
                        <span class="title">入职时间：</span>
                        <div class="li_r">
                            <span class="title"><fmt:formatDate value="${USER.workTime}"
                                                                pattern="yyyy-MM-dd HH:mm"/></span>
                        </div>
                    </li>
                    <li class="clearfix">
                        <span class="title">离职时间：</span>
                        <div class="li_r">
                            <c:if test="${USER.leaveTime eq null}">
                                <span class="title">该员工暂未离职</span>
                            </c:if>
                            <c:if test="${USER.leaveTime != null}">
                                <span class="title"><fmt:formatDate value="${USER.leaveTime}" pattern="yyyy-MM-dd HH:mm" /></span>
                            </c:if>
                        </div>
                    </li>
                    <li class="clearfix">
                        <span class="title">备注：</span>
                        <div class="li_r">
                            <span class="title">${USER.info}</span>
                        </div>
                    </li>
                </ul>
                <!--高级配置-->
            </div>
        </div>
    </div>
</div>
</body>
</html>
