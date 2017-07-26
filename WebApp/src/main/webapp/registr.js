 function search_plane () {
    var from = document.getElementById("от").value;
    var to = document.getElementById("куда").value;
     $.ajax({
         type: "POST",
         url: "/TicketSales",
         dataType: "json",
         data: {requestType: "searchPlane", from: from, to: to},
         success: function (data) {
             console.log(data);
            document.getElementById("out").innerHTML=data;
             
         }
     });

}

function chosePlane() {
    var plane=document.getElementById("plane").value;
    $.ajax({
        type: "POST",
        url: "/TicketSales",
        dataType: "json",
        data: {requestType: "choseSeat",plane: plane},
        success: function (data) {
            console.log(data)
            document.location.href = 'Seat.html';
            document.getElementById("seat").innerHTML=data;



        }
    });
}

 // function registerPass() {
 //     var last=document.getElementById("plane").value;
 //     var first=document.getElementById("plane").value;
 //     $.ajax({
 //         type: "POST",
 //         url: "/TicketSales",
 //         dataType: "json",
 //         data: {requestType: "register",last: last,first:first},
 //
 //     });
 // }