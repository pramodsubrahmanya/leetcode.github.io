$.ajax({
    url: "/header.html",
    success: function (data) {
        $('body').append(data);
    },
    dataType: 'html'
});

$.ajax({
    url: "./public/templates/problems.html",
    success: function (data) {
        problemTable(data);
    },
    dataType: 'html'
});

function problemTable(data) {
    $('#problemlinks').append(data);
    $('#dtBasicExample').DataTable();
    $('.dataTables_length').addClass('bs-select');
}