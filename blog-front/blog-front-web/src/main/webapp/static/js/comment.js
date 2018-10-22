function showBlogType(){
$.ajax({
		url:"/blogFront/blogType",
		type:"get",
		dataType:"json",
		success:function(msg){
			if(msg.code != 0){
				alert("出错了");
				return ;
			}
			//typeUl
			//console.log(msg.des);
			
			var html = "";
			$.each(msg.des,function(i,data){
				html = html+"<li><a href='../html/list.html?typeId="+data.id+"'>"+data.typename+"</a></li>";
			});
			$('.typeUl').append(html);
		}
	}); 
}

function xxx(msg){
	var data = msg.des.list
	var content = "";
	$.each(data,function(i,blog){
		var t = new Date(blog.date).toLocaleString(); 
		content = content
			+"<li> <span class='blogpic'><a href='/'><img src='../static/images/zd01.jpg'></a></span>"
			+" <h3 class='blogtitle'><a href='/'>"+blog.title+"</a></h3>"
			+" <div class='bloginfo'>"
			+"   <p>"+blog.digest+"</p>"
			+" </div>"
			+" <div class='autor'><span class='lm'><a href='/' title='TypeName' target='_blank' class='classname'>"+blog.blogType.typename+"</a></span><span class='dtime'>"+t+"</span><span class='viewnum'>浏览（<a href='/'>0</a>）</span><span class='readmore'><a href='../html/blogContent.html?id="+blog.id+"'>阅读原文</a></span></div>"
			+"</li>";
	});
	$("#blogList").append(content);
	
}

function GetRequest() { 
	var url = location.search; //获取url中"?"符后的字串 
	var theRequest = new Object(); 
	if (url.indexOf("?") != -1) { 
	var str = url.substr(1); 
	strs = str.split("&"); 
	for(var i = 0; i < strs.length; i ++) { 
	theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]); 
	} 
	} 
	return theRequest; 
} 