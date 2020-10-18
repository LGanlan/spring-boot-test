layui.use(['form', 'table'], function () {
    var form = layui.form,
        layer = layui.layer,
        table = layui.table,
        $ = layui.$;

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
            url: ctxPath + "/servant/insert",
            data: data.field,
            //请求成功
            success: function (result) {
                if (result.code == 200) {
                    layer.msg("保存成功")
                } else {
                    layer.msg("保存失败");
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