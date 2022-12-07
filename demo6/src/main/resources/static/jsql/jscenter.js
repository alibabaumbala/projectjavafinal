
// PHÂN TRANG
var items = $('.tritem');
console.log(items);
numItems = $('table.table tr:last').index()+1;
var perPage = 5;

items.slice(perPage).hide();
console.log($('#pagination-container'));
$('#pagination-container').pagination({
    items: numItems,
    itemsOnPage: perPage,
    prevText: "&laquo;",
    nextText: "&raquo;",
    onPageClick: function (pageNumber) {
        var showFrom = perPage * (pageNumber - 1);
        var showTo = showFrom + perPage;
        items.hide().slice(showFrom, showTo).show();
    }
});

//SEARCH
function searchBar() {
    $('#search_field').on('keyup', function() {
        console.log("ok")
        let searchString = $(this).val();
        $(".emp_card").each(function(index, value) {
            currentName = $(value).text()
            if( currentName.toUpperCase().indexOf(searchString.toUpperCase()) > -1) {
                $(value).show();
            } else {
                $(value).hide();
            }
        });
    });
};
searchBar();
