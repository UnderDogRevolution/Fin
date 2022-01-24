//헤더 부분
$(".noticewrap").on("click", function (e) {

    if ($('.notice_box').hasClass("show")) {

        $('.notice_box').slideUp(200);
        $('.notice_box').removeClass("show");

    } else {

        $(".notice_box").slideDown(200);
        $(".notice_box").addClass("show");

    }
});
$(".namewrap").on("click", function (e) {

    if ($('.myclick').hasClass("show")) {

        $('.myclick').slideUp(200);
        $('.myclick').removeClass("show");

    } else {

        $(".myclick").slideDown(200);
        $(".myclick").addClass("show");

    }
});

$(".boardwrap").on("click", function (e) {

    if ($('.boardMenu').hasClass("show")) {

        $('.boardMenu').slideUp(200);
        $('.boardMenu').removeClass("show");

    } else {

        $(".boardMenu").slideDown(200);
        $(".boardMenu").addClass("show");

    }
});



window.onclick = function (event) {
    if (!(event.target.matches('.noticewrap') || event.target.matches('.notice_box'))) {

        $('.notice_box').slideUp(200);
        $('.notice_box').removeClass("show");
    }
    if (!(event.target.matches('.namewrap') || event.target.matches('.myclick') || event.target.matches('.myImg'))) {
        $('.myclick').slideUp(200);
        $('.myclick').removeClass("show");
    }

    if (!(event.target.matches('.boardwrap') || event.target.matches('.boardMenu')) ) {
        $('.boardMenu').slideUp(200);
        $('.boardMenu').removeClass("show");
    }




}