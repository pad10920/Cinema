/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


const cinemaBtns = document.querySelectorAll('.cinema-menu button')
const cinemaList = document.querySelectorAll('.cinema')
var cinema_list = document.querySelector('.cinema-list')
cinemaBtns.forEach((btn) => {
    btn.addEventListener('click', (e) => {
        const type = e.target.getAttribute('type-cinema')

        // remove and set active fpr button
        document
            .querySelector('.cinema-menu button.active')
            .classList.remove('active')
        e.target.classList.add('active')

        // filter elements
        cinemaList.forEach((item) => {
            if (type == 'all' || item.getAttribute('type-cinema') == type)
                item.classList.remove('hide')
            else item.classList.add('hide')
        })
    })
})


cinemaBtns.forEach(btn => {
    btn.addEventListener('click', e => {
        var loai = e.target.getAttribute('type-cinema');

        phimTheoLoai(loai);
    })
})
phimTheoLoai(1)
function phimTheoLoai(loai){
    var html = ""
    fetch('http://localhost:8080/Cinema/api/phim/loai/' + loai)
        .then(response => response.json())
        .then(data => {
                console.log(data);
                for (var item in data) {
                    html += `<div class="cinema" type-cinema="pre">
                    <div class="cinema-item cinema-item-${data[item].idPhim}" >
                        <img src="static/img/${data[item].anhPhim}">
                    </div>

                    <h4>${data[item].tenPhim}</h4>
                    <p><span>Thể loại: </span>${data[item].loaiPhim}</p>
                    <p><span>Thời lượng: </span>${data[item].thoiLuong} phút</p>
                    <button onclick="phimFunction(${data[item].idPhim})"><i class="fa-solid fa-ticket"></i><a href="phim?mid=${data[item].idPhim}">Mua vé</a></button>
                </div>`;

                }
                cinema_list.innerHTML = html


            }
        )
}
function  phimFunction(e){
    sessionStorage.setItem('movieID', e);
}
