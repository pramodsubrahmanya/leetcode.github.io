$.ajax({
    url: "http://code.groupsone.com/header.html",
    success: function (data) {
        $('body').append(data);
    },
    dataType: 'html'
});

$.ajax({
    url: "http://code.groupsone.com/public/templates/problems.html",
    success: function (data) {
        problemTable(data);
    },
    dataType: 'html'
});

function problemTable(data) {

}