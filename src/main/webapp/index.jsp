<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <!-- Bootstrap -->
<%--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">--%>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="${APP_PATH}/assets/jquery/jquery-v1.12.4.js" type="text/javascript"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<%--    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>--%>

</head>
<body>
    <br>
    <br>
    <a href="findAll" class="btn btn-success">查看所有用户-GET</a><br>
    <br>
    <form class="form-inline">
        <div class="form-group">
            <label for="name">name</label>
            <input type="text" class="form-control" id="name" placeholder="姓名">
        </div>
        <div class="form-group">
            <label for="gender">gender</label>
            <input type="text" class="form-control" id="gender" placeholder="性别">
        </div>
        <div class="form-group">
            <label for="email">email</label>
            <input type="email" class="form-control" id="email" placeholder="邮箱">
        </div>
        <button id="btn-insert" class="btn btn-info">添加-POST</button>
        <button id="btn-update" class="btn btn-primary">更新-PUT</button>
        <button id="btn-ptong" class="btn btn-primary">测试普通参数传递</button>
    </form>

    </form>
    <script type="text/javascript">
        $(function () {
            $("#btn-insert").click(function () {
                const formData = {
                    name: $("#name").val(),
                    gender: $("#gender").val(),
                    email: $("#email").val()
                }
                $.ajax({
                    url: '${APP_PATH}/insert',
                    type: 'post',
                    data: JSON.stringify(formData),
                    dataType: 'json',
                    contentType: "application/json; charset=utf-8",
                    success: function (data) {
                        console.log(data)
                    }
                })
            })

            $("#btn-update").click(function (){
                const formData = {
                    name: $("#name").val(),
                    gender: $("#gender").val(),
                    email: $("#email").val()
                }
                $.ajax({
                    url: "update",
                    type: 'PUT',
                    data: JSON.stringify(formData),
                    dataType: 'json',
                    contentType: "application/json; charset=utf-8",
                    success: function (data){
                        console.log(data)
                    }
                })
            })

            $("#btn-delete").click(function () {
                $.ajax({
                    url: $("#userId").val(),
                    type: 'DELETE',
                    success: function (data){
                        console.log(data)
                    }
                })
            })

            $("#btn-ptong").click(function () {
                $.ajax({
                    url: 'findOne',
                    type: 'GET',
                    data: {
                        name: $("#name").val(),
                        gender: $("#gender").val(),
                        email: $("#email").val()
                    },
                    async: true,
                    dataType: "JSON",
                    success: function (data) {
                        alert(data)
                    }
                })
            })
        })

    </script>
</body>
</html>
