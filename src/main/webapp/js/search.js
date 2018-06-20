;function jumpurl(){
        var searchtext=$('.header-nav #searchkey').val();
        var url="http://www.shibangchina.com/search.html";
        if(searchtext.length>0){
            url+="?searchtext="+searchtext;
            window.open(encodeURI(url));
        }
    }
function showcookies() {
  var searchcookie = Array(0);
  var searchkey = '';
  $(".header-nav .search-cookie").empty();
  if (!window.localStorage) {
    alert("娴忚鍣ㄦ敮鎸乴ocalstorage");
    return false;
  } else {
    if (localStorage.getItem("search")) {
      searchcookie = JSON.parse(localStorage.getItem("search"));
    }
    for (var i = 0; i < searchcookie.length; i++) {
      searchkey += "<li data-key='" + searchcookie[i] + "'>" + searchcookie[i] + "</li>";
    }
    $(".header-nav .search-cookie").append(searchkey).on('click', 'li', function(e) {
          e = e || window.event;
          e.stopPropagation();
          $('.header-nav .search-cookie').addClass('hide');
          var b = $(this).data('key');
            $('.header-nav #searchkey').val(b);
            jumpurl();
        });
  }
}
    $(document).ready(function() {
        showcookies();
        $('.header-nav #search-button').on('click', function(e) {
                      e = e || window.event;
                      e.stopPropagation();
          $('.header-nav .main-nav').addClass('hide');
          $('.header-nav .search-content').fadeIn();
        });
        $('.header-nav #searchkey').on('click', function(e) {
          $(".header-nav .search-cookie").removeClass('hide');
                      e = e || window.event;
                      e.stopPropagation();

        });


        $('.header-nav #searchbutton').on('click', function(event) {
        
        jumpurl();
  });
        $('.header-nav #searchkey').bind('keypress', function(event) {
    if (event.keyCode == "13") {
        jumpurl();
    }
  });

    $(document).on('click',function(){
       $(".header-nav .search-cookie").addClass('hide');
        $('.header-nav .main-nav').removeClass('hide');
        $('.header-nav .search-content').hide();
});
 

      });