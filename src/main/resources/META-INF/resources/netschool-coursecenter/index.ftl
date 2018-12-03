<@module.page>
<#--每个页面都需要包含头标签comm.page,标签体内是自己的页面正文-->
<@module.head title="指标列表">
<style>
</style>
</@module.head>
<@module.body>
<div id="epanelsplitter" class = "eui-layout-container" >
<div id = "etree" class="eui-layout-left" style="background-color: #132a4f;">
</div>
<div class="eui-layout-content">
主题区域
</div>
</div>
<script>
require(["eui/modules/etree","eui/modules/epanelsplitter", "eui/modules/etabctrl"], function(obj, obj1, etabctrl){
	var splitpaneobj = new obj1.EPanelSplitter({
        wnd : window,
        ishorizontal: true,
        fixedright: false,
        parentElement : document.getElementById("epanelsplitter"),
        fixedSize: 270
    });
    
    //因为看不清，将2边都设置上背景色，方便查看
    var leftcontainer = splitpaneobj.getLeftComponentContainer(),
        rightcontainer = splitpaneobj.getRightComponentContainer();
    EUI.addClassName(leftcontainer, "example_panel");
    EUI.addClassName(rightcontainer, "example_panel");
    

	var tabobj = new etabctrl.ETabCtrl({
			wnd : window,
			//parentElement : document.getElementById("etabctrl"),
			enableclosed: true,
			enablereverse: true
	})

    var treeobj1 = new obj.ETree({
        wnd : this.wnd,
        parentElement : document.getElementById("etree"),
        width: "100%",
        hieght: "100%",
        baseCss : "eui-tree-accordion",
        enableCheckBoxes: false,
        enableAutoCheckSubItems: true,
        enableAutoCheckGrayParent: true,
        oncontextmenu : function(){
            //屏蔽系统右键
            return false;
        }
    });
    var treedata = [
        {id:"level11", caption:"课程中心", level: 1},
        {id:"level12", caption:"我的课程", level: 1},
        {id:"level13", caption:"课程收藏夹", level: 1},
        {id:"level14", caption:"我的培训班", level: 1}
    ];
    //模拟数据创建
    var rootitem = treeobj1.getRootItem();
    rootitem.loadFromArray(treedata, function(item, userObj){
        item.showCheckBox(false);
        item.setItemImage("");
        var data = [],
        level = userObj.level;
        if(level === 2)return;
        for(var i = 0; i < 2; i++){
        	if(userObj.id == 'level11'){
        		data.push({id:("level"+ level + i), caption:("课程目录"+ i), level: level+ 1});
        	}
        }
        item.onclick = function(etreeItem, event){
        	var userObject = etreeItem.userObj;
        	var itemId = userObject.id;
        	showTab(itemId);
        };
        item.loadFromArray(data, arguments.callee);
    });
    
    splitpaneobj.setComponent(treeobj1, true, 1);
    
    
    
	
	
	function showTab(itemId){
		if(itemId=='level11'){
			queryPage(0, "课程中心", "/page/rms/learnresourcesmgr");
		}else if(itemId=='level12'){
			queryPage(1, "我的课程", "/page/rms/learnresourcesmgr");
		}else if(itemId=='level13'){
			queryPage(2, "课程收藏夹", "/page/rms/learnresourcesmgr");
		}else if(itemId=='level14'){
			queryPage(3, "我的培训班", "/page/rms/learnresourcesmgr");
		}
	}
	
	function queryPage(num, caption, url){
			tabobj.add(caption, "", {"iconhint" : "预览" });
			EUI.ajax({
				url:url,
 				type: "get",
 				callback: function(queryObj){
 					tabobj.getBodyDom(num).innerHTML = queryObj.getResponseText();
 				},
 				waitMessage: {message: "正在装入...", finish: ""}
			})
	}
	
	queryPage(0, "课程中心", "/page/rms/learnresourcesmgr");
	//设置打开的标签页
	tabobj.setActive(0);

	splitpaneobj.setComponent(tabobj, false, 2);

});

/**
require(["eui/modules/epanelsplitter"], function(epanelsplitter){
    var splitpaneobj = new epanelsplitter.EPanelSplitter({
        wnd : window,
        ishorizontal: true,
        fixedright: false,
        parentElement : document.getElementById("epanelsplitter"),
        fixedSize: 270
    });
    
    splitpaneobj.setComponent(treeobj1, true, 1)
    //因为看不清，将2边都设置上背景色，方便查看
    var leftcontainer = splitpaneobj.getLeftComponentContainer(),
        rightcontainer = splitpaneobj.getRightComponentContainer();
    EUI.addClassName(leftcontainer, "example_panel");
    EUI.addClassName(rightcontainer, "example_panel");
});
**/
</script>
</@module.body>
</@module.page>