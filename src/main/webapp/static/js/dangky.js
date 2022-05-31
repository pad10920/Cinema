function dangKyTaiKhoan(){
    var dangKyFrm = document.getElementById('form-dangky');
    var coTheSubmit = true;

    if (kiemTraFrmTrong(dangKyFrm)){
        dangKyFrm.querySelectorAll('input').forEach(phanTu => {
            if (phanTu.classList.contains("input--khonghople")){
                coTheSubmit = false;
            }
        })



        if(coTheSubmit){
            
        }
    }

}

function kiemTraTrungMatKhau(elm){
    var matKhau = String (document.getElementById('password').value);
    var matKhauXacNhan = String (elm.value);
    if (matKhau.localeCompare(matKhauXacNhan) == 0){
        elm.classList.remove("input--khonghople")
    }
    else{
        elm.classList.add("input--khonghople");
    }
}