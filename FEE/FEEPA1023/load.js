

$(document).ready(function() {
    
    
    
        $("#view-contents").click(function(){
            console.log('ok')
            $("#content-main").html("<h1 style=' margin-left:20rem'>Loading</h1>")
            setTimeout(loadPagae, 2000);
            function loadPagae() {
            $("#content-main").load("view-content.html");
            }
        })
    


})