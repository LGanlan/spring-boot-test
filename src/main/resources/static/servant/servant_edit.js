layui.use(['form', 'table'], function () {
    var form = layui.form,
        layer = layui.layer,
        $ = layui.$;

    $.ajax({
        //请求方式
        type: "POST",
        //请求地址
        url: ctxPath + "/servant/detail",
        data: {
            id: $("#id").val()
        },
        //请求成功
        success: function (result) {
            if (result.code == 200) {
                form.val('form', result.data);
            } else {
                layer.msg("获取数据失败");
            }
        },
        //请求失败，包含具体的错误信息
        error: function (e) {
            layer.msg("请求失败");
        }
    });

    /**
     * 初始化表单，要加上，不然刷新部分组件可能会不加载
     */
    form.render();

    // 当前弹出层，防止ID被覆盖
    var parentIndex = layer.index;

    //监听提交
    form.on('submit(saveBtn)', function (data) {
        $.ajax({
            //请求方式
            type: "POST",
            //请求地址
            url: ctxPath + "/servant/update",
            data: data.field,
            //请求成功
            success: function (result) {
                if (result.code == 200) {
                    layer.msg("修改成功")
                } else {
                    layer.msg("修改失败");
                }
            },
            //请求失败，包含具体的错误信息
            error: function (e) {
                layer.msg("请求失败");
            }
        });
        layer.close(parentIndex);
        parent.location.reload();
    });

});