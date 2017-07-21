<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>SpringBoot Demo</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <jsp:include page="../inc/easyui.jsp"></jsp:include>
    <script>
        $(function () {
            demoDatagrid = $('#demo_datagrid'); //数据datagrid
            demoAddDialog = $('#demo_add_dialog');//新增dialog
            demoAddForm = $('#demo_add_form');//新增form
            loadDemoDatagrid();
            //初始化dialog
            demoAddDialog.dialog({
                title: '添加',
                closed: false,
                cache: false,
                modal: true
            }).dialog("close");

            //Ajax调用
            <%--var list = eval("(" + $.ajax({--%>
            <%--url: "${basePath}testBeans/getAll",--%>
            <%--dataType: "json",--%>
            <%--async: false,--%>
            <%--cache: false,--%>
            <%--type: "post"--%>
            <%--}).responseText + ")");--%>
            <%--if (list != null && list != undefined && list.length != 0) {--%>
            <%--for (var i = 0; i < list.length; i++) {--%>
            <%--demoDatagrid.datagrid('appendRow', list[i]);--%>
            <%--}--%>
            <%--}--%>

        });

        //初始化datagrid
        function loadDemoDatagrid() {
            demoDatagrid.datagrid({
                width: 800,
                height: 400,
                border: true,
                title: '测试数据',
                idField: 'ID_TEST_',
                pagination: true,
                rownumbers: true,
                url: '${basePath}testBeans/datagrid',
                columns: [[{
                    field: 'name_TEST_',
                    title: 'Name',
                    width: 100
                }, {
                    field: 'sex_TEST_',
                    title: 'Sex',
                    width: 100
                }, {
                    field: 'create_TIME_STR',
                    title: 'CreateDatetime',
                    width: 100,
                    align: 'right'
                }, {
                    field: 'gongzi_TEST_',
                    title: 'Money',
                    width: 100,
                    align: 'right'
                }]]
            });

            //使用getAll进入index页面时调用
            <%--var list =${list};--%>
            <%--if(list != null && list != undefined && list.length != 0 ) {--%>
            <%--console.info(JSON.stringify(list));--%>
            <%--for (var i = 0; i < list.length; i++) {--%>
            <%--demoDatagrid.datagrid('appendRow', list[i]);--%>
            <%--}--%>
            <%--}--%>
        }

        //保存方法
        function save() {
            console.log($.serializeObject(demoAddForm));//序列化表单为object
            demoAddForm.form('submit', {
                url: '${basePath}testBeans/addTb',
                onSubmit: function () {
                },
                success: function (isSuccess) {
                    var msg = "";
                    if (isSuccess) {
                        demoDatagrid.datagrid('reload');
                        demoAddDialog.dialog('close');
                        demoAddForm.form("reset");
                        msg = "添加成功！";
                    }else{
                        msg = "添加失败！";
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

easyui 扩展使用 my97datepiker 属性和my97官方一致
<input class="easyui-my97 easyui-validatebox"
       data-options="doubleCalendar:true,required:true" type="text"
       name="entity.mohkTime" id="mohkTime" style="width: 185px;"></input>
<input id="vv" class="easyui-validatebox"
       data-options="required:true,validType:'email'"/>
<div class="easyui-panel" data-options="title:'nihao'">
    <table id="demo_datagrid"></table>
</div>
<i class="bicon-font"></i>

<a href="#" class="easyui-linkbutton"
   onclick="demoAddDialog.dialog('open');">添加</a>
<div id="demo_add_dialog">
    <form id="demo_add_form" method="post">
        <table>
            <tr>
                <th>姓名</th>
                <td><input class="easyui-validatebox" name="NAME_TEST_"
                           data-options="required:true"/>
                </td>
            </tr>
            <tr>
                <th>性别</th>
                <td><select name="SEX_TEST_" class="easyui-combobox"
                            data-options="required:true">
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
                </td>
            </tr>
            <tr>
                <th>月薪</th>
                <td><input class="easyui-numberbox" name="GONGZI_TEST_"
                           data-options="required:true,min:0,precision:2"/>
                </td>
            </tr>
        </table>
        <a href="#" class="easyui-linkbutton" onclick="save();">保存</a>
    </form>
</div>
</body>
</html>