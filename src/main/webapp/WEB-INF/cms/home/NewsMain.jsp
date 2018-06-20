<%--
  ~ 版权所有 2018 ，xieyunbo.com
  --%>

<%--
  Created by IntelliJ IDEA.
  User: BBZZ
  Date: 2018/6/5
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<html>
<head>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="Chrome=1,IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="" />
    <meta charset="utf-8" />
    <title>
        动态
    </title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/common.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" />

    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.11.1.min.js"></script>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>

<div class="pro-carousel-box">
    <div data-ride="carousel" data-interval="4000" class="carousel slide" id="carousel-slide">
        <div role="listbox" class="carousel-inner">
            <div class="item active">
                <a href="#" target="_blank"><div class="banners topic2017-banner"></div></a>

            </div>
            <div class="item ">
                <div class="jzgl_banner jzgl_banner_lf">
                    <div class="container">
                        <h1>安得智联智慧物流</h1>
                        <p>双十一处理1000万件快递商品、流水线项目</p>
                        <p class="mt20"><a href="newslist.html" class="orange">了解更多</a></p>
                    </div>
                </div>
            </div>

            <div class="item">
                <div class="jzgl_banner jzgl_banner_zhoushan">
                    <div class="container">
                        <h1>泉州新雅仕</h1>
                        <p>新雅仕冷库设备是由迪夫伦提供各种大型冷库项目...</p>
                        <p class="mt20"><a href="newslist.html" class="orange">了解更多</a></p>
                    </div>
                </div>
            </div>

        </div>
        <ol class="carousel-indicators">
            <li class="active" data-slide-to="0" data-target="#carousel-slide">&nbsp;</li>
            <li data-slide-to="1" data-target="#carousel-slide">&nbsp;</li>
            <li data-slide-to="2" data-target="#carousel-slide">&nbsp;</li>

        </ol>
    </div>
</div>

<!-- center of the page -->
<div id="content" class="mt65">
    <div class="container media_text">
        <div class="container">
            <div class="col-xs-12 text-center">
                <h1><strong>公司新闻</strong></h1>
                <a href="newslist.html" class="more orange" >了解更多</a> </div>
        </div>
        <div class="container mt45 mb65 company_news">
            <div class="col-xs-12 col-sm-4">
                <a href="newsdetail.html"><img src="images/news/news1.jpg" width="350" height="240" alt=""  class="img-responsive center-block"/></a>
                <h3 class="mt26"><a href="#"><strong>热烈祝贺迪夫伦参加“亚洲物流双年展”取得圆满成功</strong></a></h3>
                <p class="text">　第十五届中国国际物流节</p>
                <p class="text"><a href="#"><span></span></a>2018-04-24</p>
            </div>
            <div class="col-xs-12 col-sm-4">
                <a href="#"><img src="images/news/news1.jpg" width="350" height="240" alt=""  class="img-responsive center-block"/></a>
                <h3 class="mt26"><a href="newsdetail"><strong>热烈祝贺迪夫伦参加“亚洲物流双年展”取得圆满成功</strong></a></h3>
                <p class="text">　第十五届中国国际物流节</p>
                <p class="text"><a href="newsdetail"><span></span></a>2018-04-24</p>
            </div>
            <div class="col-xs-12 col-sm-4">
                <a href="#"><img src="images/news/news1.jpg" width="350" height="240" alt=""  class="img-responsive center-block"/></a>
                <h3 class="mt26"><a href="newsdetail"><strong>热烈祝贺迪夫伦参加“亚洲物流双年展”取得圆满成功</strong></a></h3>
                <p class="text">　第十五届中国国际物流节</p>
                <p class="text"><a href="newsdetail"><span></span></a>2018-04-24</p>
            </div>
        </div>
    </div>
    <div class="bg paddingtop80 paddingbottom80">
        <div class="container">
            <div class="two_media">
                <div class="special_report">
                    <div class="special_img">
                        <img src="images/news/special_report.jpg" alt="" />
                    </div>
                    <div class="special_text">
                        <h3><a href="newslist.html">专题报道</a></h3>
                        <ul>
                            <li class="hot-title"><a href="#">5.20牺牲小爱 奉献大爱</a></li>
                            <li><a href="newsdetail">四年风雨路 亲情一家人</a></li>
                            <li><a href="newsdetail">中国冷链腾飞</a></li>
                        </ul>
                        <p class="more"><a href="#">了解更多</a></p>
                    </div>
                </div>
                <div class="journal">
                    <img src="images/news/journal.jpg" alt="" />
                    <h3><a href="newslist.html">公司周报</a></h3>
                    <p><a href="newsdetail">四月第六三期:2018直击“设备现场”</a></p>
                    <p class="more"><a href="newsdetail">了解更多</a></p>
                </div>
            </div>
            <script type="text/javascript">
                (function(){
                    $(".journal").height($(".special_report").height());
                })()
            </script>


        </div>
    </div>

    <div class="paddingtop80 hot-med paddingbottom80">
        <div class="container">
            <div class="col-xs-12 text-center mb30">
                <h1><strong>行业聚焦</strong></h1>
            </div>
            <div class="col-sm-6 pull-right col-xs-12 mb20"> <a href="#"><img src="images/hotspot.jpg" width="539" height="360" alt=""  class="img-responsive center-block"/></a> </div>
            <div class="col-sm-6 col-xs-12">
                <div class="text border-bottom hot_media">
                    <strong><a href="#">固定式升降机可以处理什么样的货物？效率如何？</a></strong>
                    <p>吧啦吧巴拉，叽叽哇哇这里就是来介绍一下这两个方面的问题。</p>
                </div>
                <ul class="list-unstyled mb20 hot-media-list">
                    <li><a href="#">输送带怎样效率最高</a></li>
                    <li><a href="#">不同提升机的应用区别</a></li>
                    <li><a href="#">自动输送带的原理是怎样的？</a></li>
                    <a href="#" class="btn btn-primary">了解更多</a>
                </ul>
            </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
