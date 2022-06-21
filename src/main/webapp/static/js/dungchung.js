const DIACHI_API = "/api";

function kiemTraFrmTrong(phanTuFrm){
    var phanTuInputs = phanTuFrm.querySelectorAll('input');
    var formHopLe = true;
    phanTuInputs.forEach(phanTuInput => {
        if (phanTuInput.value.length == 0){
            phanTuInput.classList.add('input--khonghople')
            formHopLe = false;
        }
        else{
            phanTuInput.classList.remove('input--khonghople');
        }
    })
    if (formHopLe == false){
        document.querySelector('.phan-hoi').textContent = 'Không được để trống thông tin'
        document.querySelector('.phan-hoi').hidden = false;
    }
    return formHopLe;
}

function kiemTraHopLeInput(phanTuInput){
    var hople = phanTuInput.value.length >= phanTuInput.getAttribute('minlength')
                && phanTuInput.value.length <= phanTuInput.getAttribute("maxlength");
    if (hople == false){
        phanTuInput.classList.add('input--khonghople');
    }
    else{
        phanTuInput.classList.remove('input--khonghople');
    }
    return hople;
}
function kiemTraHopLeEmail(phanTuInput){
    var email = phanTuInput.value;
    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email)){
        phanTuInput.classList.remove('input--khonghople');
        return true;
    }
    phanTuInput.classList.add('input--khonghople');
    return false;
}

function moModal(){
    document.querySelector('.modal').style.display = 'flex';
    document.getElementsByTagName('body')[0].classList.add('modal-open');
}
function tatModal(){
    document.querySelector('.modal').style.display = 'none';
    document.getElementsByTagName('body')[0].classList.remove('modal-open');
}