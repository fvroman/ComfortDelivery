$(document).ready(function () {
    $(document).on("click submit", "#printLink", function (event) {
        var orderNum = parseInt($("#order_num").text());
        event.preventDefault();
        $.ajax({
            url: $(this).attr('href'),
            success: function () {
                var iframe = document.createElement('iframe');
                iframe.style.visibility = "hidden";
                iframe.src ="../reports/agreements/"+orderNum+".html";
                document.body.appendChild(iframe);
                iframe.contentWindow.focus();
                iframe.contentWindow.print();
            },
            cache: false
        });
    });
});