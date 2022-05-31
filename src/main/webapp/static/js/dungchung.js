const DIACHI_API = "localhost:8080/api/";

function kiemTraFrmTrong(phanTuFrm){
    var phanTuInputs = phanTuFrm.querySelectorAll('input');
    var formHopLe = true;
    phanTuInputs.forEach(phanTuInput => {
        if (phanTuInput.value.length == 0){
            phanTuInput.classList.add('input--khonghople')
            formHopLe = false;
        }
        else{
            console.log(phanTuInput.value)
            phanTuInput.classList.remove('input--khonghople');
        }
    })
    if (formHopLe == false){
        document.querySelector('.kiem-tra-hop-le').classList.remove('object-an');
    }
    return formHopLe;
}

function kiemTraHopLeInput(phanTuInput){
    var hople = phanTuInput.value.length >= phanTuInput.getAttribute('minlength')
                && phanTuInput.value.length <= phanTuInput.getAttribute("maxlength");
    console.log(hople);
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
        return (true)
    }
    phanTuInput.classList.add('input--khonghople');
    return (false)
}
