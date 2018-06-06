$(document).ready(function () {
    //attach autocomplete
    $("#search").autocomplete({
        minLength: 1,
        delay: 500,
        source: function (request, response) {
            $.getJSON("/getSearchMatches", request, function (result) {
                response($.map(result, function (item) {
                    return {
                        label: item.productName,
                        value: item.productName,
                        subcategory: item.subcategory
                    }
                }));
            });
        }
    }).autocomplete("instance")._renderItem = function (ul, item) {
        return $("<li>")
            .append("<div>" + "<span class='autocomplete-label'>" + item.label + "</span>" +
                "<span class='autocomplete-subcategory'>" + item.subcategory + "</span>" + "</div>")
            .appendTo(ul);
    };
});
