<%--
  Created by IntelliJ IDEA.
  User: joey
  Date: 2017/7/21
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>登录</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <jsp:include page="../inc/easyui.jsp"></jsp:include>
    <script>
        $(function () {
            $('#dd').dialog({
                title: 'My Dialog',
                width: 400,
                height: 200,
                closed: false,
                cache: false,
                modal: true,
                buttons: [{
                    text: '登录',
                    handler: function () {
                        login();
                    }
                }, {
                    text: '重置',
                    handler: function () {
                        $("#login_form").form("reset");
                    }
                }]
            });
        });

        function login(){
            $("#login_form").form('submit', {
                url: '${basePath}doLogin/login',
                onSubmit: function () {
                },
                success: function (isSuccess) {
                    var msg = "";
                    if (isSuccess) {
                        window.location.href = "${basePath}";
                    }else{
                        msg = "登录失败，账号密码均为admin！";
                    }
                    $.messager.show({
                        title: '提示',
                        msg: msg
                    });
                }
            });
        }
    </script>


</head>

<body>
<div id="dd">
    <div fit="true" style="text-align: center;">
        <form id="login_form" method="post">
            用户名：<input id="name" name="name" class="easyui-validatebox" data-options="required:true" value="admin"/>
            <p></p>
            密&nbsp;&nbsp;码：<input id="pwd" name="pwd" class="easyui-validatebox" type="password"
                                  data-options="required:true" value="admin"/>
        </form>
    </div>
</div>
</body>
</html>
