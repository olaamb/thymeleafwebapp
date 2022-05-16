var today = new Date();

var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();

//Check below if you want hour, minute and seconds also(remember to change date to dateTime also

// var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
//
// var dateTime = date+' '+time;

document.getElementById("p1").innerHTML = date;