$(document).on("click",".delete-link , .add-to-bin-button, .increaseLink, .decreaseLink",function (event) {
    var total = $("#total");
    var oldVal = parseInt(total.text());
    var newVal;
    event.preventDefault();
    $.ajax({
        url: $(this).attr('href'),
        success: function() {
            $(".order-bin-items").load(location.href+" .order-bin-items>*","");
            total.load(location.href + " #total", function () {
                newVal = parseInt(total.text());
                //Анимация изменяюшейся суммы
                $(".order-bin-total").each(function () {
                    $(this).prop('Counter',oldVal).animate({
                        Counter: newVal
                    }, {
                        duration: 500,
                        easing: 'swing',
                        step: function (now) {
                            $(this).text(Math.ceil(now));
                        }
                    });
                });
            });

        },
        cache: false
    });

    return false;
});
