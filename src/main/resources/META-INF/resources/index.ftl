<@module.page>
<#--每个页面都需要包含头标签comm.page,标签体内是自己的页面正文-->
<@module.head title="指标列表">
<link href="${relpath!}eui/old/themes/${theme!}/checkbox.css" rel="stylesheet" type="text/css" />
<style>
</style>
</@module.head>
<@module.body>
<div class = "eui-layout-container" id = "etree">
</div>
<script>
require(["eui/modules/etree"], function(etree){
    var treeobj1 = new etree.ETree({
        wnd : this.wnd,
        parentElement : document.getElementById("etree"),
        width: "100%",
        hieght: "100%",
        enableCheckBoxes: true,
        enableAutoCheckSubItems: true,
        enableAutoCheckGrayParent: true,
        oncontextmenu : function(){
            //屏蔽系统右键
            return false;
        }
    });
    var treedata = [
        {id:"level11", caption:"第1级1", level: 1},
        {id:"level12", caption:"第1级2", level: 1}
    ];
    //模拟数据创建
    var rootitem = treeobj1.getRootItem();
    rootitem.loadFromArray(treedata, function(item, userObj){
        item.showCheckBox(true);
        item.setItemImage("");
        var data = [],
        level = userObj.level;
        if(level === 2)return;
        for(var i = 0; i < 2; i++){
        data.push({id:("level"+ level + i), caption:("第" + level + "级sdjsjdfsjkdhfskjhf" + i), level: level+ 1});
        }
        item.loadFromArray(data, arguments.callee);
    });
});


</script>
</@module.body>
</@module.page>