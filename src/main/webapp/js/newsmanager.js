/************************新闻编辑页*****************************************/
//上传input相关操作
function toclick(obj){
	$(obj).next().click();
}
//赋值给展现的文本框
function toval(obj){
	$(obj).prev().val($(obj).val());
}
//验证表单
function validaForm(){
	if($("#title").val().trim().length<1){
		alert("标题不能为空");
		return;
	}
	//栏目名称赋值
	var options=$("#m_select2_1 option:selected"); //获取选中的项
	$("#columnName").val(options.text());
	//summernote 内容赋值
	var sHTML = $('#summernote').summernote('code');
	$("#content").val(sHTML);
	console.log(sHTML);
	//表单提交
	$("#newsform").submit();
}

function validaUpdateForm(){
	if($("#title").val().trim().length<1){
		alert("标题不能为空");
		return;
	}
	//栏目名称赋值
	var options=$("#m_select2_1 option:selected"); //获取选中的项
	$("#columnName").val(options.text());
	//summernote 内容赋值
	var sHTML = $('#updatesummernote').summernote('code');
	$("#content").val(sHTML);
	console.log(sHTML);
	//表单提交
	$("#newsupdateform").submit();
}
/************************************新闻列表页************************************/

var serv="";//服务器地址

function toAddpage(){
	$.ajax(
            {
                url : serv+"/news/editNews",
                dataType : "html",
                type : "post",
                error : function (data)
                {
                    alert('与服务器的连接发生异常！');
                    return;
                },
                success : function (data)
                {
                    $("#mainContent").html(data);
                    Dashboard.init();
                    // 这句不加左侧菜单的子菜单无法展现
                    mLayout.init();
                }
            });
}

function toUpdatepage(aid){
	$.ajax(
            {
                url : serv+"/news/updateNewsPage?aid="+aid,
                dataType : "html",
                type : "post",
                error : function (data)
                {
                    alert('与服务器的连接发生异常！');
                    return;
                },
                success : function (data)
                {
                    $("#mainContent").html(data);
                    Dashboard.init();
                    // 这句不加左侧菜单的子菜单无法展现
                    mLayout.init();
                }
            });
}
function searchNews(ser){
	serv=ser;
	$.post(ser+"/news/getNewsListByCondition",$("#searchNewsForm").serialize(),function(data){
		//遍历结果
		var str="";
		$.each(data.newsList,function(k,v){
			str+='<tr>'+
			'<th scope="row">'+v.articleId+'</th>'+
			'<td>'+v.title;
			if(v.important=="1"){
				str+='<span class="m-badge m-badge--danger m-badge--wide">'+
				'荐'+
				'</span></td>';
			}
			str+='<td>'+v.columnName+'</td>'+
			'<td>'+Format(v.releaseTime,"yyyy-MM-dd HH:mm")+'</td>'+
			'<td>'+v.author+'</td>'+
			'<td>'+v.clicktotal+'</td>'+
			'<td>'+getNewsStatus(v.checkStatus)+
			'</td>'+
			'<td>';
			if(v.status=="0"){
				str+='<a href="javascript:;" onclick="del('+v.articleId+',1)" class="m-portlet__nav-link btn m-btn m-btn--hover-danger m-btn--icon m-btn--icon-only m-btn--pill" title="删除">'+
				' <i class="la la-trash"></i>'+
				'</a>';
			}
			if(v.important!="1"){
				str+='<a href="javascript:;" onclick="recom('+v.articleId+',1)" class="m-portlet__nav-link btn m-btn m-btn--hover-success m-btn--icon m-btn--icon-only m-btn--pill" title="推荐">'+
				' <i class="la la-thumbs-o-up"></i>'+
				'</a>';
				
			}else{
				str+='<a href="javascript:;" onclick="recom('+v.articleId+',0)" class="m-portlet__nav-link btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill" title="取消推荐">'+
				' <i class="la la-thumbs-o-down"></i>'+
				'</a>';
			}
			str+='<a href="javascript:;" onclick="toUpdatepage('+v.articleId+')" class="m-portlet__nav-link btn m-btn m-btn--hover-brand m-btn--icon m-btn--icon-only m-btn--pill" title="编辑">'+
			'<i class="la la-edit"></i>'+
			'</a>'+
			'</td>'+
		'</tr>';
		
		});
		$("#tb_news").html("");
		$("#tb_news").html(str);
		var pagHtml="";
		// 分页数据
		var totalPage=data.totalPage;
		var curPage=data.curPage;
		console.log(data.totalPage);
		if(totalPage>0){//有数据显示页码  无数据不显示
			pagHtml+='<button type="button" onclick="toprev('+curPage+')" style="padding: 5px 10px" class="btn m-btn--square  btn-outline-metal">'+
			'《'+
			'</button>';
			if(curPage-3>0){
				pagHtml+='<button type="button" onclick="topage(1)" style="padding: 5px 10px" class="btn m-btn--square  btn-outline-metal">'+
				'1'+
				'</button>'+
				'<button type="button" style="padding: 5px 10px" class="btn m-btn--square  btn-outline-metal">'+
				'...'+
				'</button>';
				pagHtml+='<button type="button" onclick="topage('+(curPage-2)+')" style="padding: 5px 10px" class="btn m-btn--square  btn-outline-metal">'+
				(curPage-2)+
				'</button>';
				pagHtml+='<button type="button" onclick="topage('+(curPage-1)+')" style="padding: 5px 10px" class="btn m-btn--square  btn-outline-metal">'+
				(curPage-1)+
				'</button>';
			} else if(curPage-2>0){
				pagHtml+='<button type="button" onclick="topage('+(curPage-2)+')" style="padding: 5px 10px" class="btn m-btn--square  btn-outline-metal">'+
				(curPage-2)+
				'</button>';
				pagHtml+='<button type="button" onclick="topage('+(curPage-1)+')" style="padding: 5px 10px" class="btn m-btn--square  btn-outline-metal">'+
				(curPage-1)+
				'</button>';
			}else if(curPage-1>0){
				pagHtml+='<button type="button" onclick="topage('+(curPage-1)+')" style="padding: 5px 10px" class="btn m-btn--square  btn-outline-metal">'+
				(curPage-1)+
				'</button>';
			}
			pagHtml+='<button type="button" onclick="topage('+curPage+')" style="padding: 5px 10px" class="btn m-btn--square  btn-success">'+
			curPage+
			'</button>';
			if(curPage+3<=totalPage){
				pagHtml+='<button type="button" onclick="topage('+(curPage+1)+')" style="padding: 5px 10px" class="btn m-btn--square  btn-outline-metal">'+
				(curPage+1)+
				'</button>';
				pagHtml+='<button type="button" onclick="topage('+(curPage+2)+')" style="padding: 5px 10px" class="btn m-btn--square  btn-outline-metal">'+
				(curPage+2)+
				'</button>';
				pagHtml+='<button type="button" style="padding: 5px 10px" class="btn m-btn--square  btn-outline-metal">'+
				'...'+
				'</button>'+
				'<button type="button" onclick="topage('+totalPage+')" style="padding: 5px 10px" class="btn m-btn--square  btn-outline-metal">'+
				totalPage+
				'</button>';
			} else if(curPage+2<=totalPage){
				pagHtml+='<button type="button" onclick="topage('+(curPage+1)+')" style="padding: 5px 10px" class="btn m-btn--square  btn-outline-metal">'+
				(curPage+1)+
				'</button>';
				pagHtml+='<button type="button" onclick="topage('+(curPage+2)+')" style="padding: 5px 10px" class="btn m-btn--square  btn-outline-metal">'+
				(curPage+2)+
				'</button>';
			}else if(curPage+1<=totalPage){
				pagHtml+='<button type="button" onclick="topage('+(curPage+1)+')" style="padding: 5px 10px" class="btn m-btn--square  btn-outline-metal">'+
				(curPage+1)+
				'</button>';
			}
			
			pagHtml+='<button type="button" onclick="tonext('+curPage+','+totalPage+')" style="padding: 5px 10px" class="btn m-btn--square  btn-outline-metal">'+
			'》'+
			'</button>';
		}
		
		$("#pagenation").html("");
		$("#pagenation").html(pagHtml);
	});
}

//删除
function del(id,sta){
	if(confirm("确定要删除这篇新闻么")){
	$.post(serv+"/news/updateNews",{articleId:id,status:sta},function(data){
		if(data=="success"){
			alert("删除成功");
			$("#btn_search").click();
		}
	})
	}
}

//推荐
function recom(id,sta){
	var textStr="";
	if(sta==0){
		textStr="您确定要取消推荐这篇新闻么";
	}else{
		textStr="您确定要推荐这篇新闻么";
		
	}
	if(confirm(textStr)){
		$.post(serv+"/news/updateNews",{articleId:id,important:sta},function(data){
			if(data=="success"){
				alert("操作成功");
				$("#btn_search").click();
			}
		})
	}
	
}
//上一页
function toprev(cur){
	var pre=parseInt(cur)-1;
	if(pre<1){
		pre=1;
	}
	$("#cur_input").val(pre);
	$("#btn_search").click();
}
//下一页
function toprev(cur,total){
	var pre=parseInt(cur)+1;
	var tot=parseInt(total);
	if(pre>total){
		pre=total;
	}
	$("#cur_input").val(pre);
	$("#btn_search").click();
}
function topage(cur){
	$("#cur_input").val(cur);
	$("#btn_search").click();
}


/**********************UTIls***********************************/
function getNewsStatus(sta){ 
	var str="";
	if(sta=="0"){
		str='<span class="m-badge m-badge--primary m-badge--wide">'+
		'新建立'+
		'</span>';
	}else if(sta=="1"){
		str='<span class="m-badge m-badge--brand m-badge--wide">'+
		'已提交'+
		'</span>';
	}else if(sta=="2"){
		str='<span class="m-badge m-badge--success m-badge--wide">'+
		'已审核'+
		'</span>';
	}else if(sta=="3"){
		str='<span class="m-badge m-badge--danger m-badge--wide">'+
		'未通过'+
		'</span>';
	}
	return str;
}



function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "/";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    var hour=date.getHours() ;
    var min=date.getMinutes();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    if (hour >= 0 && hour <= 9) {
    	hour = "0" + hour;
    }
    if (min >= 0 && min <= 9) {
    	min = "0" + min;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
            + " " + hour+ seperator2 + min;
            //+ seperator2 + date.getSeconds();
    return currentdate;
}
//格式日期
function Format(now, mask) {
	var d = new Date(now);
	var zeroize = function(value, length) {
		if (!length)
			length = 2;
		value = String(value);
		for (var i = 0, zeros = ''; i < (length - value.length); i++) {
			zeros += '0';
		}
		return zeros + value;
	};

	return mask
			.replace(
					/"[^"]*"|'[^']*'|\b(?:d{1,4}|m{1,4}|yy(?:yy)?|([hHMstT])\1?|[lLZ])\b/g,
					function($0) {
						switch ($0) {
						case 'd':
							return d.getDate();
						case 'dd':
							return zeroize(d.getDate());
						case 'ddd':
							return [ 'Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri',
									'Sat' ][d.getDay()];
						case 'dddd':
							return [ 'Sunday', 'Monday', 'Tuesday',
									'Wednesday', 'Thursday', 'Friday',
									'Saturday' ][d.getDay()];
						case 'M':
							return d.getMonth() + 1;
						case 'MM':
							return zeroize(d.getMonth() + 1);
						case 'MMM':
							return [ 'Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
									'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec' ][d
									.getMonth()];
						case 'MMMM':
							return [ 'January', 'February', 'March', 'April',
									'May', 'June', 'July', 'August',
									'September', 'October', 'November',
									'December' ][d.getMonth()];
						case 'yy':
							return String(d.getFullYear()).substr(2);
						case 'yyyy':
							return d.getFullYear();
						case 'h':
							return d.getHours() % 12 || 12;
						case 'hh':
							return zeroize(d.getHours() % 12 || 12);
						case 'H':
							return d.getHours();
						case 'HH':
							return zeroize(d.getHours());
						case 'm':
							return d.getMinutes();
						case 'mm':
							return zeroize(d.getMinutes());
						case 's':
							return d.getSeconds();
						case 'ss':
							return zeroize(d.getSeconds());
						case 'l':
							return zeroize(d.getMilliseconds(), 3);
						case 'L':
							var m = d.getMilliseconds();
							if (m > 99)
								m = Math.round(m / 10);
							return zeroize(m);
						case 'tt':
							return d.getHours() < 12 ? 'am' : 'pm';
						case 'TT':
							return d.getHours() < 12 ? 'AM' : 'PM';
						case 'Z':
							return d.toUTCString().match(/[A-Z]+$/);
							// Return quoted strings with the surrounding quotes
							// removed
						default:
							return $0.substr(1, $0.length - 2);
						}
					});
};