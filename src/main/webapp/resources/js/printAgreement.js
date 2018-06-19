$(document).ready(function () {
    $(document).on("click submit", "#printLink", function (event) {
        var orderNum = parseInt($("#order_num").text());
        event.preventDefault();
        alert(orderNum);
        $.ajax({
            url: $(this).attr('href'),
            success: function () {
                var objFra = document.createElement('iframe');
                objFra.style.visibility = "hidden";
                objFra.src ="../reports/agreements/"+orderNum+".pdf";
                document.body.appendChild(objFra);
                objFra.contentWindow.focus();
                objFra.contentWindow.print();
            },
            cache: false
        });
    });
});