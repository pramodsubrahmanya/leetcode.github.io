$.ajax({
    url: "http://code.groupsone.com/leetcode.github.io/header.html",
    success: function (data) {
        $('body').append(data);
    },
    dataType: 'html'
});