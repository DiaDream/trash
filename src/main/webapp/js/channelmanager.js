 	//服务器地址
	var ser;
	//节点数组
	var ts = [];
    function MyTree(columnId, columnName,columnIntroduce, columnImage, status, columnParentid,ordinal,createTimeStr) {

        this.columnId = columnId;
        this.columnName = columnName;
        this.columnIntroduce = columnIntroduce;
        this.columnImage = columnImage;
        this.status = status;
        this.columnParentid = columnParentid;
        this.ordinal=ordinal;
        this.createTimeStr=createTimeStr;

    }
    //递归方法，参数node节点，pd是div对象
    function diGui(node, fid,indent) {
        $.each(ts, function (k, v) {
            if (node instanceof MyTree) {
                if (node.columnId == v.columnParentid) {
                	//style='text-indent:"+(10*indent)+"px'
                    var data = "<tr class='treegrid-" + v.columnId + " treegrid-parent-" + fid + "'>"
                        + "<td >&nbsp;" + v.columnName + "</td>"
                        + "<td >" + v.ordinal + "</td>"
                        + "<td>" +
                        '<span class="m-badge m-badge--'+(v.status == '0' ? "success" : "danger")+' m-badge--wide">'+
                        (v.status == '0' ? "使用中" : "已禁用") +
						'</span>'
                       + "</td>"
                        + "<td>" + v.columnIntroduce + "</td>"
                        + "<td>"+v.createTimeStr+"</td>"
                        + "<td>";
                    if(v.status == '0'){
                    	data+='<a onclick="deleteChannel('+v.columnId+')" class="m-portlet__nav-link btn m-btn m-btn--hover-danger m-btn--icon m-btn--icon-only m-btn--pill" title="删除">'+
						 '<i class="la la-trash"></i>'+
						'</a>';
                    }else{
                    	data+='<a onclick="rebackChannel('+v.columnId+')" class="m-portlet__nav-link btn m-btn m-btn--hover-danger m-btn--icon m-btn--icon-only m-btn--pill" title="删除">'+
						 '<i class="la la-repeat"></i>'+
						'</a>';
                    }
                    data+='<a onclick="updateChannel('+v.columnId+','+v.columnParentid+')" class="m-portlet__nav-link btn m-btn m-btn--hover-primary m-btn--icon m-btn--icon-only m-btn--pill" title="编辑">'+
						 '<i class="la la-edit"></i>'+
						'</a>' +
						'<a onclick="addChannel('+v.columnId+','+v.columnParentid+')" class="m-portlet__nav-link btn m-btn m-btn--hover-success m-btn--icon m-btn--icon-only m-btn--pill" title="添加子菜单">'+
						 '<i class="la la-plus"></i>'+
						'</a>' +
                       "</td>"
                        + "</tr> ";
                    $(".treegrid-" + fid).after(data);
                    var child = new MyTree(v.columnId, v.columnName,v.columnIntroduce, v.columnImage, v.status, v.columnParentid,v.ordinal,v.createTimeStr);
                    if(v.columnId==3){
                    	console.log(indent);
                    }
                    indent+=1;
                    diGui(child, v.columnId,indent);
                }
            }
        });
    }

    function selectAllMenu(sev) {
    	ser=sev;
        ts = [];
        $("#channel_tbody").html("");
       
        $.post(sev+"/channel/getAllColumnList", function (data) {
            //把数据放到通过封装到数组里面
            $.each(data, function (k, v) {
                var node = new MyTree(v.columnId, v.columnName,v.columnIntroduce, v.columnImage, v.status, v.columnParentid,v.ordinal,v.createTimeStr);
                ts.push(node);
            });
            //遍历数组添 拼接div
            $.each(ts, function (k, v) {
                if (v instanceof MyTree) {
                    if (v.columnParentid == -1) {
                        var dataHtml = "<tr class='treegrid-" + v.columnId + "'>"
                        + "<td>&nbsp;" + v.columnName + "</td>"
                        + "<td >" + v.ordinal + "</td>"
                        + "<td>" +
                        '<span class="m-badge m-badge--'+(v.status == '0' ? "success" : "danger")+' m-badge--wide">'+
                        (v.status == '0' ? "使用中" : "已禁用") +
						'</span>'
                       + "</td>"
                        + "<td>" + v.columnIntroduce + "</td>"
                        + "<td>"+v.createTimeStr+"</td>"
                        + "<td>";
                        if(v.status == '0'){
                        	dataHtml+='<a onclick="deleteChannel('+v.columnId+')"  class="m-portlet__nav-link btn m-btn m-btn--hover-danger m-btn--icon m-btn--icon-only m-btn--pill" title="删除">'+
   						 '<i class="la la-trash"></i>'+
 						'</a>';
                        }else{
                        	dataHtml+='<a onclick="rebackChannel('+v.columnId+')" class="m-portlet__nav-link btn m-btn m-btn--hover-danger m-btn--icon m-btn--icon-only m-btn--pill" title="删除">'+
   						 '<i class="la la-repeat"></i>'+
   						'</a>';
                        }
                        dataHtml+='<a onclick="updateChannel('+v.columnId+','+v.columnParentid+')" class="m-portlet__nav-link btn m-btn m-btn--hover-primary m-btn--icon m-btn--icon-only m-btn--pill" title="编辑">'+
						 '<i class="la la-edit"></i>'+
						'</a>' +
						'<a onclick="addChannel('+v.columnId+','+v.columnParentid+')" class="m-portlet__nav-link btn m-btn m-btn--hover-success m-btn--icon m-btn--icon-only m-btn--pill" title="添加子菜单">'+
						 '<i class="la la-plus"></i>'+
						'</a>' +
                       "</td>"
                        + "</tr> ";
                       // console.log(dataHtml);
                        $("#channel_tbody").append(dataHtml);
                        diGui(v, v.columnId,1);
                        $('.tree').treegrid({
                        	 expanderExpandedClass: 'glyphicon glyphicon-minus la la-compress',
                             expanderCollapsedClass: 'glyphicon glyphicon-plus la la-expand',
                             initialState: 'collapsed'
                        });
                    }
                }
            });
        });
    }

    function addChannel(id,fid) {
    	$("#channel_form")[0].reset();
        $("#modaltitle").text("添加子栏目");
        
        $("#columnParentid").val(id);
        $('#modal_channel').modal();
    }
    function addRoot(){
    	$("#channel_form")[0].reset();
    	 $("#modaltitle").text("添加根栏目");
    	  $("#columnParentid").val("-1");
          $('#modal_channel').modal();
    }
    function updateChannel(id,fid) {
    	$("#channel_form")[0].reset();
    	 $("#modaltitle").text("编辑栏目");
    	$.post(ser+"/channel/getColumnById", { "id": id }, function (result) {
           $("#columnId").val(result.columnId);
           $("#columnName").val(result.columnName);
           $("#columnimage").val(result.columnimage);
           $("#ordinal").val(result.ordinal);
           $("#columnIntroduce").val(result.columnIntroduce);
           
           $('#modal_channel').modal();
        });
    	
    }

    function deleteChannel(id) {
        var r = confirm("您确定要删除该栏目吗?");
        if (r == true) {
            $.post(ser+"/channel/updateColumnStatus", { "columnId": id,"status":"1" }, function (result) {
                if (result.result == "success") {
                    alert("删除成功");
                    selectAllMenu(ser);
                } else{
                    alert("删除失败");
                }
            });
        }
        
    }
    function rebackChannel(id) {
        var r = confirm("您确定要恢复该栏目吗?");
        if (r == true) {
        	 $.post(ser+"/channel/updateColumnStatus", { "columnId": id,"status":"0" }, function (result) {
                if (result.result == "success") {
                    alert("恢复成功");
                    selectAllMenu(ser);
                } else{
                    alert("恢复失败");
                }
            });
        }
        
    }

    //提交表单
    function addColumn() {
        var url = "";
        var cid=$("#columnId").val();
        console.log(cid+"栏目id");
        if (cid.trim()=="") {
            url = ser+"/channel/addColumn";
        } else{
            url = ser+"/channel/updateColumn";
        }
        if ($("#columnName").val().trim().length < 1) {
            alert("栏目名称不能为空");
            return;
        }
        var ord=$("#ordinal").val();
        var reg=/^[1-9]+\d*$/;
        if(!reg.test(ord)){
        	alert("序号格式不正确！");
            return;
        }
        
        //把idset进表单
        $("#channel_form").ajaxSubmit({
            type: 'post',
            url: url,
            success: function (data) {
              
                if (data.flag=="success") {
                    alert("操作成功");
                    selectAllMenu(ser);
                    $("#modal_channel").modal('hide');
                }
            },
            error: function (XmlHttpRequest, textStatus, errorThrown) {
               console.log(XmlHttpRequest);
               console.log(textStatus);
               console.log(errorThrown);
            }
        });
    }

//    $(function () {
//        selectAllMenu();
//
//        $("#sub_menu").click(function () {
//            //   alert(1);
//            var MenuID = $("#MenuID").val();
//            var MenuName = $("#MenuName").val();
//            var MenuUrl = $("#MenuUrl").val();
//            var MenuSuperior = $("#MenuSuperior").val();
//            if (MenuID == -1) {
//                var r = { "MenuName": MenuName, "MenuUrl": MenuUrl, "MenuSuperior": MenuSuperior };
//                $.post("/menu/Insert", $("#f1").serialize(), function (result) {
//                    if (result.result == "success") {
//                        alert("插入成功");
//                        selectAllMenu();
//                    } else if (result.result == "failed") {
//                        alert("插入失败");
//                    }
//                });
//            } else {
//                var r = { "MenuName": MenuName, "MenuUrl": MenuUrl, "MenuSuperior": MenuSuperior };
//                $.post("/menu/update", $("#f1").serialize(), function (result) {
//                    if (result.result == "success") {
//                        alert("修改成功");
//                        selectAllMenu();
//                    } else if (result.result == "failed") {
//                        alert("修改失败");
//                    }
//                });
//            }
//        });
//    });
