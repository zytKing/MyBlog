function openTab(text,url,icon) {
	var tabs = $("#tabs");
    //判断当前选项卡是否存在
    if(tabs.tabs('exists',text)){
        //如果存在 显示
        tabs.tabs("select",text);
    }else{
        //如果不存在 则新建一个
        tabs.tabs('add',{
            title:text,
            closable:true,   //是否允许选项卡摺叠。
            iconCls:icon,    //显示图标
            content:"<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='./html/"+url+"'></iframe>"
        });
    }
}


//加载分类下拉选
function showBlogType() {
$.ajax({
	url : "/blogType/sList",
	type : "get",
	dataType : "json",
	success : function(data) {
		var d = data.des;
		console.log(d);
		$('<option value="-1">请选择博客类别</option>').appendTo($('#blogTypeId'));
		$.each(d, function(i, t) {
			var o = $('<option></option>');
			o.attr("value", t.id).append(t.typename).appendTo($('#blogTypeId'));
		});
		$("#blogTypeId").combobox({});
	}
});
};

function getSelectionsIds(id){
	var itemList = id;
	var sels = itemList.datagrid("getSelections");
	var ids = [];
	for(var i in sels){
		ids.push(sels[i].id);
	}
	ids = ids.join(",");
	return ids;
}
//提交
/*function submitData() {
	var typeid = $('#blogTypeId').combo('getValue');
	console.log(typeid);
	if (typeid == -1) {
		$.messager.alert('提示', '未选择博客类型!');
		return;
	};
	 $.ajax({
		url : "/blog/saveOrUpdateBlog",
		type : "post",
		data : $('#blogAddForm').serialize(),
		dataType : "json",
		success : function(msg) {
			if(msg.code != 0){
				$.messager.alert('错误','保存失败');
				return ;
			}
			$.messager.alert('提示','保存成功!',undefined,function(){
				window.location.reload();
			});
		}
	})
}
*/
