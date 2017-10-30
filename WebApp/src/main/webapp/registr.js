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
              if(data.length==0){
                  document.getElementById("out").innerHTML="Нет таких маршрутов";
              }
             else {

                      document.getElementById("out").innerHTML=data;

                  }
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

