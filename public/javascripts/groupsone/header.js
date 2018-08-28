$.ajax({
    url: "http://code.groupsone.com/header.html",
    success: function (data) {
        $('body').append(data);
    },
    dataType: 'html'
});