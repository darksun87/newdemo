jQuery(function() {
    $(".wbs-login-input", window.top.document).blur(function() {
        var $this = $(this);
        if ($.trim($this.val()) == "") {
            $("#wbs-login-empty", window.top.document).html($this.attr("field") + "不能为空！").show();
        } else {
            $("#wbs-login-empty", window.top.document).html("").hide();
        }
    });
    $(".wbs-login-input", window.top.document).keyup(function(e) {
        if (e.keyCode == 13) {
            $("#wbs-login-btn", window.top.document).click();
        }
    });

    $("#wbs-login-empty", window.top.document).hide().on("click", function() {
        $.wbsAlert({
            "info": $("#wbs-login-empty", window.top.document).html()
        });
    });

    $("#wbs-login-btn", window.top.document).bind("click", function() {
        $("#wbs-login-empty", window.top.document).hide();

        var flag = true;
        $(".wbs-login-input", window.top.document).each(function(n, v) {
            if ($.trim($(v).val()) == "") {
                $("#wbs-login-empty", window.top.document).html("用户名和密码不能为空！").show();
                flag = false;
                return false;
            }
        });

        var postData = {
            "loginname": $("#wbs-login-username", window.top.document).val(),
            "password": $("#wbs-login-password", window.top.document).val()
        };

        if (flag) {
            $.ajax({
                "cache": false,
                "type": "get",
                "url": "checkUser.html",
                "data": postData,
                "success": function(data) {
                    var status = data.status;
                    var targetresult = data.message;
                    if (status == "1") {
                        window.top.location.href = "index.html";
                    } else {
                        $("#wbs-login-empty", window.top.document).html(targetresult).show();
                    }
                }
            });
        }
    });

    $("#wbs-reset-btn", window.top.document).bind("click", function() {
        $(".wbs-login-input", window.top.document).val("");
    });

    $("body").on("setLayput", function() {
        $("#login").css({
            "padding-top": 0,
            "padding-left": 0
        });
        $("#login_bg,body").css({
            "width": 0,
            "height": 0
        });
        var scrollbarH = $(window).width() > $("#login>table").outerWidth(true) ? 0 : 18;
        var scrollbarV = $(window).height() > $("#login").height() ? 0 : 18;
        $("#login").css({
            "padding-top": scrollbarV == 0 ? ($(window).height() - 0 - $("#login").height()) / 2 : 0,
            "padding-left": scrollbarH == 0 ? ($(window).width() - 0 - $("#login>table").outerWidth(true)) / 2 : 0
        });
        $("#login_bg,body").css({
            "width": scrollbarH == 0 ? $(window).width() : $("#login>table").outerWidth(true),
            "height": scrollbarV == 0 ? $(window).height() : $("#login").height()
        });
        $(".div_copyright").show();
    });
    $("body").triggerHandler("setLayput");
    window.onresize = function() {
        $("body").triggerHandler("setLayput");
    };

    $(".wbs-login-input", window.top.document)
        .focus(function(e) {
            $(this).parent().parent().parent().addClass("table_login_input_focus");
        })
        .blur(function(e) {
            $(this).parent().parent().parent().removeClass("table_login_input_focus");
        });
});