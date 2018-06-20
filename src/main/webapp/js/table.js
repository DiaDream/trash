function drawtable(){
    allobj=$('.parameter');
    for(var i=0;i<allobj.length;i++){
        var obj=allobj[i],
            pid = obj.getAttribute("pid"),
            lid = obj.getAttribute("lid"),
            sid = obj.getAttribute("sid"),
            cid = obj.getAttribute("cid"),
            h =document.getElementsByTagName("head"),
            latpaw =function(){
                if(sid && sid!=="0"){
                    var style = document.createElement("style");
                    var def = ".para_table{ border-collapse:collapse;width:98%;}.para_table tr:hover{background:#d1dae0}.para_table td{border:1px #999 solid;padding:5px;text-align:center;}.odd{background:#e1eaf0;}.even{background:#efefef}"
                    if(window.ActiveXObject){
                        style.setAttribute("type","text/css")
                        style.styleSheet.cssText = def
                    }else{
                        style.type="text/css"
                        //style.innerHTML = def
                    }
                    h[0].appendChild(style)
                }
            }
        var sc = document.createElement("script");
        sc.type="text/javascript"
        sc.src="http://js.sbmchina.com/xhr/parameter_api.php?id="+pid+"&lan="+lid+"&cid="+cid+"&callback=say"+(i+1);
        sc.charset="utf-8"
        h[0].appendChild(sc)
        latpaw()
    }
}

function tableStyle($table) {
    var $c = $("<table></table>").append($table)
    $c.find("table").addClass("table table-bordered table-hover text-center").each(function(){
        $tr = $(this).find("tr")
        $tr.eq(0).css({
            "backgroundColor": "#ccc",
            "textAlign" : "center",
            "paddingTop": 20,
            "paddingBottom": 20,
            "border": "none"
        })
    })
    return $c
}

function say1(word){
    var para = $('.parameter').eq(0)
    var $table = $("<div></div>").append(word)
    $c = tableStyle($table)
    para.html($c.html())
}
function say2(word){
    var para = $('.parameter')[1]
    var $table = $("<div></div>").append(word)
    $c = tableStyle($table)
    para.html($c.html())
}

function say3(word){
    var para = $('.parameter')[2]
    var $table = $("<div></div>").append(word)
    $c = tableStyle($table)
    para.html($c.html())
}

function say4(word){
    var para = $('.parameter')[3]
    var $table = $("<div></div>").append(word)
    $c = tableStyle($table)
    para.html($c.html())
}
drawtable()