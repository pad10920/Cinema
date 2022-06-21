
function checktime(){
  
    var x = document.getElementById("timebd_1").value;
    var y = document.getElementById("timekt_1").value;
     var x1 = new Date(x);
     var y1= new Date(y);
    if(x>y){
          
          alert("nhập lại")
    }
}