 function reg () {
    var last = document.getElementById("n1").value;
    var first = document.getElementById("n2").value;
   // var pass = document.getElementById("passReg").value;
    $.ajax({
        type: "POST",
        url: "/TicketSales",
        dataType: "json",
        data: {requestType: "registr", last: last, first: first}
    });
}