layui.use(['table', 'miniPage', "form"], function () {
    var $ = layui.$;
    var table = layui.table;
    var miniPage = layui.miniPage;
    var form = layui.form;

    var column = [[
        {field: 'id', hide: true}
        , {field: 'name', title: '姓名', align: "center"}
        , {field: 'classId', title: '职阶', align: "center"}
        , {field: 'scoreId', title: '评分', align: "center"}
        , {field: 'isHas', title: '已拥有', align: "center"}
        , {title: '操作', minWidth: 150, toolbar: '#tableBar', align: "center"}
    ]]

    table.render({
        elem: '#dataTable'
        , height: "full-241"
        , width: "1318"
        , toolbar: '#toolbar'
        , url: contextPath + '/servant/list/' //数据接口
        , page: true //开启分页
        , cols: column
    });

    // 监听搜索操作
    $("#searchBtn").click(function () {
        let name = $("#name").val();
        let classId = $("#classId").val();
        let scoreId = $("#scoreId").val();
        let isHas = $("#isHas").val();

        //执行搜索重载
        table.reload('dataTable', {
            url: contextPath + '/servant/list/'
            , where: {
                name: name,
                classId: classId,
                scoreId: scoreId,
                isHas: isHas
            }
        });
        return false;
    });

    /**
     * toolbar事件监听
     */
    table.on('toolbar(dataTableFilter)', function (obj) {
        var content = miniPage.getHrefContent(ctxPath + '/servant/add');
        var openWH = miniPage.getOpenWidthHeight();

        var index = layer.open({
            title: '添加从者',
            type: 1,
            shade: 0.2,
            maxmin: true,
            shadeClose: true,
            area: [openWH[0] + 'px', openWH[1] + 'px'],
            offset: [openWH[2] + 'px', openWH[3] + 'px'],
            content: content,
        });

        $(window).on("resize", function () {
            layer.full(index);
        });
    });

    table.on('tool(dataTableFilter)', function (obj) {
        var data = obj.data;
        if (obj.event === 'edit') {

            var content = miniPage.getHrefContent(ctxPath + '/servant/edit?id=' + data.id);
            var openWH = miniPage.getOpenWidthHeight();

            var index = layer.open({
                title: '编辑从者',
                type: 1,
                shade: 0.2,
                maxmin: true,
                shadeClose: true,
                area: [openWH[0] + 'px', openWH[1] + 'px'],
                offset: [openWH[2] + 'px', openWH[3] + 'px'],
                content: content,
            });
            $(window).on("resize", function () {
                layer.full(index);
            });
        } else if (obj.event === 'delete') {
            layer.confirm('真的删除么', function (index) {
                console.info(data.id)
                $.ajax({
                    //请求方式
                    type: "POST",
                    //请求地址
                    url: ctxPath + "/servant/delete",
                    data: {
                        id: data.id
                    },
                    //请求成功
                    success: function (result) {
                        if (result.code == 200) {
                            layer.msg("删除成功")
                        } else {
                            layer.msg("删除失败");
                        }
                        obj.del();
                    },
                    //请求失败，包含具体的错误信息
                    error: function (e) {
                        layer.msg("请求失败");
                    }
                });
                layer.close(index);
            });
        }
    });

});