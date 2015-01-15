var host = "http://10.0.2.2/MTS"; //10.0.2.2  //localhost //hyrdlt1299



function autheticateUser() {
    //authenticate the user
    var userid = $("#user").val();
    var pass = $("#password").val();
    var authUrl = host + "/AppResource/rs/auth";
    var data = {
        user: userid,
        pass: pass
    };

    $.ajax({
        url: authUrl,
        type: "POST",
        data: data,
        contentType: "application/json; charset=utf-8",
        success: function (response, status, xhr) {
            if (response == "failure") {
                $("#loginfailanchor").click();
            } else {
                loadTicketDetails();
                $('#gotoTicketsPageAnchor').click();
            }
        }
    });

}

function loadTicketDetails() {

    var formUrl = host + "/tickets.jsp";
    $.get(formUrl, function (response, status, xhr) {
         $("#tdmc").html(response);
//        setTimeout(function(){
//            $("#tdmc").html(response);
//        },2000);
        
        //document.getElementById("loginForm").reset();
    });
}

function loadSpecificTicketDetail(ticketId) {
    resetValues();
    var url = host + "/AppResource/rs/detail?id=" + ticketId;
    $.getJSON(url, function (resJSON, status, xhr) {
        var resObj = resJSON;

        $("#hiddenTID").val(resObj.id);
        $('#detailedTicketHeader').html(resObj.category);
        $('#detailedTicketContent').html(resObj.description);
        // console.info(resObj.category);
    });

}
function resetValues() {
    //Values reset for specific ticket screen
    $('#detailedTicketHeader').html("");
    $('#detailedTicketContent').html("");
    $('#rc').hide();
    $('#markasdonecheckbox').prop("checked", false);
    $('#checkboxLabel').removeClass("ui-checkbox-on");
    $('#checkboxLabel').addClass("ui-checkbox-off");
    //value reset for details screen
    $("#tdmc").html("");
    console.info('reached here ');
}
function markTicketAsDone() {
    var tid = $("#hiddenTID").val();
    console.info('say ' + tid);
    var url = host + "/AppResource/rs/complete/" + tid;
    $.get(url, function (response, status, xhr) {
        console.info('The staus is ' + status);
        if (xhr.status == 200) {

            $('#rc').show();
        }
    });
}