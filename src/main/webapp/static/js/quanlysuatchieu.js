function start(){
    layListRap();
}
start();
var indicator_2 = document.querySelector('.nav-2-indicator');
var items_2 = document.querySelectorAll('.nav-2-item');
var content_2 = document. querySelectorAll('.themx');
var themX = document.querySelector("#themXuat");
var suaX = document.querySelector("#suaXuat");
function handleIndicator(el) {
    items_2.forEach(function (item) {
        item.classList.remove('is-active');
        item.removeAttribute('style');

    });
    content_2.forEach(function(it){
          it.classList.remove('active');
    });
    indicator_2.style.width = "".concat(el.offsetWidth, "px");
    indicator_2.style.left = "".concat(el.offsetLeft, "px");
    indicator_2.style.backgroundColor = el.getAttribute('active-color');
    el.classList.add('is-active');
    el.style.color = el.getAttribute('active-color');
    
}
items_2.forEach(function (item) {
    // console.log("hhh",item);
    // console.log(item.getAttribute("value"));
    item.addEventListener('click', function (e) {
        handleIndicator(e.target);
        if(item.getAttribute("value")=="themXuat"){
             themX.style.display=("block");
             suaX.style.display=("none");
        }
        else{
            themX.style.display=("none");
             suaX.style.display=("block");
        }
    });
    item.classList.contains('is-active') && handleIndicator(item);
});
function chon(){
    var url = DIACHI_API + '/quanlyphim/';
    fetch(url)
        .then(response => response.json())
        .then(listPhim => {
            var danhSachPhimElm = document.getElementById("danhSachPhim");
            danhSachPhimElm.innerHTML = "";
            listPhim.forEach(phim => {
                var theloai = phim.theLoais.map(data => data.tenLoai).join(", ");
                var trangThai = "Phim sắp chiếu"
                if (phim.trangThai == 1)
                    trangThai = "Phim đang chiếu";
                if (phim.trangThai == 2)
                    trangThai = "PHim đặc biệt"
                var html = `
                            <div class="xx-2" onclick="sc(${phim.idPhim}, '${phim.tenPhim}')">
                                <div class="ds-2">${phim.tenPhim}</div>
                                <div class="ds-2">${phim.thoiLuong}</div>
                                <div class="ds-2">${phim.quocGia}</div>
                                <div class="ds-2">${trangThai}</div>
                                <div class="ds-2">${theloai}</div>
                            </div>
                            `
                danhSachPhimElm.innerHTML += html;
            })
        })
        .then(function (){
            var hien = document.querySelector(".ds2");
            hien.style.display = "block";
        })
}
function chon2(){
    var url = DIACHI_API + '/rap/'
    fetch(url)
        .then(res => res.json())
        .then(rapList => {
            var danhsachphim = document.getElementById('danhsachrapsua');
            danhsachphim.innerHTML = '';
            rapList.forEach(rap => {
                var html = `
                    <div class="item-rap" onclick="hienThiListShow(${rap.idRap})">${rap.tenRap}</div>
                `
                danhsachphim.innerHTML += html;
            })
        })
        .then(function (){
            var hien2 = document.querySelector(".danhsach2");
            hien2.style.display = "block";
        })
}
function dong(){
    var hien = document.querySelector(".ds2");
    hien.style.display = "none";
}
function dong2(){
    var hien = document.querySelector(".danhsach2");
    hien.style.display = "none";
}
function sc(idPhim, tenPhim){
    document.getElementById('tenphim').setAttribute('idPhim', idPhim);
    document.getElementById('tenphim').value = tenPhim;
    const element = document.querySelector("#getid");
    element.scrollIntoView();
}
function back(){
    var yht = document.querySelector(".danhsach-xc");
    var zht = document.querySelector(".danhsach2");
    yht.style.display = "none";
    zht.style.display= "block";
}

function dongsua(){
    var t= document.querySelector(".nhapsuaxc");
    t.style.display = "none";
}

// ------- them suat chieu -------
// layList phim

function layListRap(){
    var url = DIACHI_API + '/rap/';
    fetch(url)
        .then(res => res.json())
        .then(listRap => {
            showListRap(listRap);
        })
}
function showListRap(listRap){
    var rapEle = document.getElementById('chonrap');
    listRap.forEach(rap => {
        var option = document.createElement("option");
        option.text = rap.tenRap;
        option.value = rap.idRap;
        rapEle.appendChild(option);
    })
}

function layDanhSachPhong(){
    var ngayChieu = document.getElementById('thoigianngay').value;
    var thoigianbd = document.getElementById('thoigianbd').value;
    var thoigiankt = document.getElementById('thoigiankt').value;
    var rap = document.getElementById('chonrap').value;
    if (ngayChieu != '' && thoigiankt != '' && thoigianbd != '' && Number(rap)>=0){
        var url = DIACHI_API + `/phongchieu?ngaychieu=${ngayChieu}&thoigianbd=${thoigianbd}&thoigiankt=${thoigiankt}&idRap=${rap}`
        fetch(url)
            .then(res => res.json())
            .then(data => {
                showListPhong(data);
            })
    }
}

function showListPhong(listPhong){
    var phongchieu = document.getElementById('chonPhongChieu');
    phongchieu.innerHTML = '';
    listPhong.forEach(phong => {
        html = `
            <label>
                <input name="phongchieu" type="checkbox" idPhong="${phong.idPhongchieu}"/>
                ${phong.tenPhong}
            </label>
        `
        phongchieu.innerHTML += html;
    })
}
function themSuatChieu(){
    var idPhim = document.getElementById('tenphim').getAttribute('idphim');
    var ngayChieu = document.getElementById('thoigianngay').value;
    var thoigianbd = document.getElementById('thoigianbd').value;
    var thoigiankt = document.getElementById('thoigiankt').value;
    var giave = document.getElementById('giave').value;

    var phongchieuElm = document.querySelectorAll('input[name=phongchieu]:checked');
    var phongchieu = new Array();
    phongchieuElm.forEach(phong => {
        phongchieu.push(phong.getAttribute('idPhong'));
    })
    var formData = new FormData();
    formData.append("giave", giave);
    formData.append("idphim", idPhim);
    formData.append("ngaychieu", ngayChieu);
    formData.append("thoigianbd", thoigianbd);
    formData.append("thoigiankt", thoigiankt);
    formData.append("phongchieu", phongchieu);


    var url = DIACHI_API + '/quanlysuatchieu/'
    fetch(url, {
        method: 'POST',
        body: formData
    })
        .then(response => response.toString())
        .then(data => {
            // alert(data);
        })
}
// sua show
function hienThiListShow(idRap){
    var url = DIACHI_API + `/quanlysuatchieu?rapId=${idRap}`;
    fetch(url)
        .then(response => response.json())
        .then(listShow => {
            var listShowElm = document.getElementById('listshowsua');
            listShowElm.innerHTML = '';
            listShow.forEach(show => {
                var html = `
                            <div class="thongtin">
                                <div class="k p-xc">${show.phim.tenPhim}</div>
                                <div class="k n-xc">${show.ngaychieu}</div>
                                <div class="k tbd-xc">${show.thoigianBd}</div>
                                <div class="k tkt-xc">${show.thoigianKt}</div>
                                <div class="k gia-xc">${show.giaVe}</div>
                                
                                <div class="options">
                                <div class="e suatt" onclick="suaShow(${show.IdSuatchieu})">Sửa</div>
                                <div class="e xoatt" onclick="xoaShow(${show.IdSuatchieu})">Xóa</div>
                            </div>
                            </div>
                            
                `
                listShowElm.innerHTML += html;
            })

        })
        .then(function (){
            var yht = document.querySelector(".danhsach-xc");
            var zht = document.querySelector(".danhsach2");
            // console.log(yht);
            yht.style.display = "block";
            zht.style.display= "none";
        })
}

function suaShow(showId){
    var url = DIACHI_API + '/quanlysuatchieu/' + showId;
    fetch(url)
        .then(response => response.json())
        .then(show => {
            document.getElementById('dulieushowsu').setAttribute("idShow", show.IdSuatchieu);
            var tenphim = document.getElementById('tenphimsua');
            tenphim.innerText = show.phim.tenPhim;
            document.getElementById("giavesua").value = show.giaVe;
            var selectPhimSua = document.getElementById('showListPhimSua');
            selectPhimSua.innerHTML = '';
            var option = document.createElement('option');
            option.value = show.phim.idPhim;
            option.text = show.phim.tenPhim;
            option.selected = true;
            selectPhimSua.appendChild(option);
        })
        .then(function (){
            getListPhimSua();
        })
    var t= document.querySelector(".nhapsuaxc");
    t.style.display = "block";
}
function getListPhimSua(){
    var url = DIACHI_API + '/quanlyphim/';
    fetch(url)
        .then(response => response.json())
        .then(phimList => {
            var selectPhimSua = document.getElementById('showListPhimSua');
            phimList.forEach(phim => {
                if (phim.idPhim != selectPhimSua.value){
                    var option = document.createElement('option');
                    option.value = phim.idPhim;
                    option.text = phim.tenPhim;
                    selectPhimSua.appendChild(option);
                }
            })
        })
}
function commitSuaShow(){
    var idPhim = document.getElementById('showListPhimSua').value;
    var idShow = document.getElementById('dulieushowsu').getAttribute("idShow");
    var giave = document.getElementById('giavesua').value;

    var formData = new FormData();
    formData.append("giave", giave);
    formData.append("idphim", idPhim);
    formData.append("idSuatchieu", idShow);

    var url = DIACHI_API + '/quanlysuatchieu/'
    fetch(url, {
        method: 'PUT',
        body: formData
    })
        .then(response => response.toString())
        .then(function (){
            dongsua();
            back();
        })
}
function xoaShow(idShow){
    var formData = new FormData();
    formData.append("idSuatchieu", idShow);

    var url = DIACHI_API + '/quanlysuatchieu/'
    fetch(url, {
        method: 'DELETE',
        body: formData
    })
        .then(response => response.toString())
        .then(function (){
            dongsua();
            back();
        })
}