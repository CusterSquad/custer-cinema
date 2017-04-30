function showNewScreeningForm() {
    $.get("/newscreening", function (data) {
        $("#main_container").load(data);
        $("#newscreening_li").addClass('active');
    })
}
function showModifyScreeningForm() {
    $.get("/modifyscreening", function (data) {
        $("#main_container").load(data);
        $("#modifyscreening_li").addClass('active');
    })
}