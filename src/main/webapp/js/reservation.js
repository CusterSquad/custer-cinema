function showNewReservationForm() {
    $.get("/newreservation", function (data) {
        $("#main_container").load(data);
        $("#newreseration_li").addClass('active');
    })
}
function showModifyReservationForm() {
    $.get("/modifyreservation", function (data) {
        $("#main_container").load(data);
        $("#modifyreservation_li").addClass('active');
    })
}
function showForm() {
    $('#submitReservation').show();
}
