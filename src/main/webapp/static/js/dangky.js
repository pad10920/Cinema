function dangKyTaiKhoan(){
    var dangKyFrm = document.getElementById('form-dangky');

    if (kiemTraFrmTrong(dangKyFrm)){
        var coTheSubmit = true;

        if(kiemTraHopLeEmail(document.getElementById('email')) == false ||
            kiemTraTrungMatKhau(document.getElementById('re-password')) == false) {
            coTheSubmit = false;
        }

        if (coTheSubmit){
            document.querySelector('.phan-hoi').hidden = true;
        }
        else{
            document.querySelector('.phan-hoi').textContent = 'Email không hợp lệ hoặc Mật khẩu không trùng nhau'
            document.querySelector('.phan-hoi').hidden = false;
        }

        if(coTheSubmit){
            var username = document.getElementById('username').value;
            var email = document.getElementById('email').value;
            var url = DIACHI_API + `/dang-ky?username=${username}&email=${email}`;
            fetch(url)
                .then(response => response.text())
                .then(data => {
                    if (data == 0)
                        dangKyFrm.submit();
                    else {
                        var phanHoi = '';
                        if (data == 1)
                            phanHoi = 'Tên tài khoản đã được sử dụng';
                        else if (data == 2)
                            phanHoi = 'Email đã được sử dụng';
                        else
                            phanHoi = 'Tên tài khoản và email đã được sử dụng';
                        document.querySelector('.phan-hoi').textContent = phanHoi;
                        document.querySelector('.phan-hoi').hidden = false;
                    }
                })
        }
    }

}

function kiemTraTrungMatKhau(elm){
    var matKhau = String (document.getElementById('password').value);
    var matKhauXacNhan = String (elm.value);
    if (matKhau.localeCompare(matKhauXacNhan) == 0){
        elm.classList.remove("input--khonghople")
        return (true)
    }
    else{
        elm.classList.add("input--khonghople");
    }
    return (false);
}

function quenMatKhau(){
    var quenMatKhauFrm = document.getElementById('frm-quen-mat-khau');
    var phanHoiElm = document.querySelector('.phan-hoi');
    if (kiemTraFrmTrong(quenMatKhauFrm)){
        var coTheSubmit = true;
        if (kiemTraHopLeEmail(document.getElementById('email')) == false){
            phanHoiElm.textContent = "Địa chỉ Email không hợp lệ";
            phanHoiElm.hidden = false;
            coTheSubmit = false;
        }

        if (coTheSubmit == true){
            moModal();
            quenMatKhauFrm.submit();
        }
    }
}