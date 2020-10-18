layui.use(['table'], function () {
    var table = layui.table;

    var column = [[
        {field: 'id', hide: true}
        , {field: 'name', title: '姓名', align: "center"}
        , {field: 'class', title: '职阶', align: "center"}
        , {field: 'score', title: '评分', align: "center"}
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

});