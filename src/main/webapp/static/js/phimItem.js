const movieID = sessionStorage.getItem('movieID')
console.log(movieID);
var imgDetail = document.querySelector('.trai img')
const phai = document.querySelector('.phai')
fetch('http://localhost:8080/Cinema/api/phim/' + movieID)
.then(response => response.json())
.then(data => {
    var html = `<h2>${data.tenPhim}</h2>
                <div class="thong-tin">
                    <span><b>Mô tả: </b>${data.moTa}</span>
                    <span><b>Thể loại: </b>${data.loaiPhim}</span>
                    <span><b>Thời lượng: </b>${data.thoiLuong} phút</span>
                    <span><b>Quốc gia: </b>${data.quocGia}</span>
                </div>
                <div class="mua-ve">
                    <button>Mua vé</button>
                </div>`
    phai.innerHTML = html;
    imgDetail.src = 'view/img/' + data.anhPhim;
    
})
