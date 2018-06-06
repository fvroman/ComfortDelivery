$(document).on("click",".delete-link , .add-to-bin-button",function (event) {
    event.preventDefault();
    $.ajax({
        url: $(this).attr('href'),
        success: function(response) {
            $(".order-bin-items").load(location.href+" .order-bin-items>*","");
        },
        cache: false
    });
    return false;
});


