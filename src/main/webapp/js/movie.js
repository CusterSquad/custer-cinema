function showNewMovieForm() {
  $.get("/newmovie", function (data) {
      $("#main_container").load(data);
      $("#newmovie_li").addClass("active");
  })
}
function showModifyMovieForm() {
    $.get("/modifymovie", function (data) {
        $("#main_container").load(data);
        $("#modifymovie_li").addClass("active");
    })
}
function getMovieById() {
    var request = document.getElementById("movieSelectList").value;
    $.get("/getMovieById/" + request, function (response) {
        $("#movieSelect").hide();
        $("#modifyMovieForm").show();
        var data = JSON.parse(response);
        console.log(data);

    });
}