
// var $jq = jQuery.noConflict();
$('.uudai-list-info').slick({
    infinite: true,
    slidesToShow: 3,
    slidesToScroll: 2,
    arrows:true,
    draggable:false,
    prevArrow:"<button type='button' class='slick-prev slick-arrow'><i class='fa-sharp fa-solid fa-arrow-right'></i></button>",
    nextArrow:"<button type='button' class='slick-next slick-arrow'><i class='fa fa-angle-right' aria-hidden='true'></i></button>"
});

// SLIDE ITEM IMAGE DETAIL
$('.slider-for').slick({
    slidesToShow: 1,
    slidesToScroll: 1,
    arrows: false,
    fade: true,
    asNavFor: '.slider-nav'
});
$('.slider-nav').slick({
    slidesToShow: 4,
    slidesToScroll: 1,
    asNavFor: '.slider-for',
    dots: true,
    autoplay:true,
    focusOnSelect: true
});

$('a[data-slide]').click(function(e) {
    e.preventDefault();
    var slideno = $(this).data('slide');
    $('.slider-nav').slick('slickGoTo', slideno - 1);
});



window.onload = function()
{
    var hotelAPI = "http://localhost:3001/api/listhotel"

    //CLICK VÔ HÌNH ĐIỂM ĐẾN Ở TRNAG CHỦ
    let apiPlaceHotel = "";
    let itemPlace = document.querySelectorAll(".img-place")
    itemPlace.forEach(item=>{
        item.onclick = function(e)
        {
            // console.log(item)
            let index = e.target.className.indexOf(' ')
            apiPlaceHotel=e.target.className.substring(0,index)
            window.location.href="/list-hotel/"+apiPlaceHotel;
        }
    })
    function start()
    {
        getHotel(renderHotel)
        getHotel(renderRoom)
    }
    start()

    function getHotel(callback)
    {
        fetch(hotelAPI)
            .then(function(response){
                return response.json()
            })
            .then(callback)
    }

    function renderHotel(hotels)
    {
        let item = document.querySelector('.list-hotel').getAttribute("value")
        var listHotel = document.querySelector('.list-hotel')
        let huy = "hotels[0]."+item
        let keywordsearchbynamehotel = document.getElementById("keywordsearchbynamehotel").value;
        var html =eval(huy).map(ele=>{
            if (ele.name_hotel.toUpperCase().includes(keywordsearchbynamehotel.toUpperCase())==true)
            {
                return `
                        <div class="lht-item ${ele.star}" namePlace="${ele.id}">
                            <div class="combo-title">
                                <i class="fas fa-clock"></i>
                                <p>${ele.intro}</p>
                            </div>
                            <div class="lht-main" valueNamePlace="huy" >
                                <div class="lht-img">
                                    <div class="lht-img-img" style="background-image:url('${ele.img_hotel}')"></div>
                                    <div class="voucher">
                                      <div>
                                        <p class="voucher-label">${ele.voucher}</p>
                                      </div>
                                    </div>
                                </div>
                                <div class="lht-content">
                                    <p class="lht-name">${ele.name_hotel}</p>
                                    <div class="lht-content_rate">
                                        <div class="lht-content_rate_star">
                                            ${
                    ele.star==5?'<span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span>'
                        :ele.star==4?'<span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span>'
                            :ele.star==3?'<span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span>'
                                :ele.star==2?'<span class="fa fa-star checked"></span><span class="fa fa-star checked"></span>'
                                    :ele.star==1?'<span class="fa fa-star checked"></span>'
                                        :''
                }
                                        </div>
                                        
                                        <div class="lht-content_rate_mark">
                                            <p style="margin-right: 5px">${ele.point}</p>
                                            <p style="color: #9fc43a;font-size: 14px;margin-right: 5px;">Tuyệt vời</p>
                                            <p style="font-size: 14px">| ${ele.count_cmt} đánh giá</p>
                                        </div>
                                    </div>
                                    <div class="lht-direct">
                                        <a href="">
                                            <span class="fa fa-map-marker"></span>
                                            ${ele.address} - <b style="color: #0b3af4">Xem bản đồ</b style="color: #40a6f2">
                                        </a>
                                    </div>
                                    <div class="lht-character" value-character="${ele.character}">
                                    </div>
                                    <div class="bonus-charact">
                                        <div>
                                            <span class="fa fa-star checked" style="color: white;"></span>
                                        </div>
                                        <div>${ele.bonus_character}</div>
                                    </div>
                                </div>
                                <div class="lht-price">
                                    <div id="status_room" value-status-room="${ele.status}">
                                        <div class="lht-price-detail" id="huy">${ele.price} VND</div>
                                        <div class="type_room">
                                            <div>
                                                <p style="font-weight:bold">${ele.type_room}</p>
                                                <p>${ele.type_room_bonus}</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                        </div>`
            }
        })
        listHotel.innerHTML=html.join('');

        //CLICK VÔ TỪNG KHÁCH SẠN MUỐN XEM
        let itemHotel = document.querySelectorAll('.lht-item')
        itemHotel.forEach(ele=>{
            ele.onclick = function(e)
            {
                let idHotel = ele.getAttribute("namePlace")
                window.location.href="/list-hotel/"+item+"/"+idHotel
            }
        })
        //SET PRICE
        var price = document.querySelectorAll(".lht-price-detail")
        for(let i = 0;i<price.length;i++)
        {
            let money = price[i].innerText
            var price1 = Number(money.substring(0,money.indexOf(' ')))
            document.querySelectorAll(".lht-price-detail")[i].innerHTML = new Intl.NumberFormat({ style: 'currency', currency: 'JPY' }).format(price1)+" VND"
        }


        //CHARACTER
        let listCharacter = document.querySelectorAll('.lht-character')
        listCharacter.forEach(item=>{
            let arrCharacter = item.getAttribute('value-character').split(',');
            let itemCharacter = ''
            for(let i = 0;i<arrCharacter.length;i++)
            {
                let htmlCharacter = arrCharacter[i]
                itemCharacter += `<div class="lht-character_item"><span class="fa fa-check"></span>${htmlCharacter}</div>`

            }
            item.innerHTML = itemCharacter
        })

        //STATUS_ROOM
        let status_room = document.querySelectorAll('#status_room')
        // console.log(status_room[0]);
        status_room.forEach(ele=>{
            // console.log(ele.getAttribute('value-status-room'));
            if(ele.getAttribute('value-status-room')=="Hết phòng")
            {
                ele.querySelector('.type_room').style.display="none"
                ele.querySelector('.lht-price-detail').innerHTML = '<div class="lht-price-detail" id="huy"><span class="fa fa-clock-o"></span>HẾT PHÒNG</div>'

            }
        })

        //KHU VỰC
        var listKhuVuc = document.querySelector('.list-khuvuc')
        var htmlkv = eval("hotels[1].kv_"+item).map(ele=>{
            return `<div label="1sao" class="filter-hotel-by-star">
                    <input type="checkbox">
                    ${ele.namekv}
                </div>`
        })
        listKhuVuc.innerHTML=htmlkv.join('');

        // LOẠI HÌNH NHÀ Ở
        var listLoaiHinhNhaO = document.querySelector('.list-loaihinhnhao')
        var htmlTypeRoom = hotels[2].type_room_phuquoc.map(ele=>{
            return `<div label="1sao" class="filter-hotel-by-star">
                    <input type="checkbox">
                    ${ele.type_room}
                </div>`
        })
        listLoaiHinhNhaO.innerHTML=htmlTypeRoom.join('');

        // KINH NGHIỆM DU LỊCH
        var kndl = document.querySelector('.kndl-content')
        var htmlKNDL = "hotels[3].kndl_"+item
        console.log(htmlKNDL)
        kndl.innerHTML=eval(htmlKNDL);

        // FILTER
        var allCheckboxes = document.querySelectorAll('input[type=checkbox]');
        var allhotel = Array.from(document.querySelectorAll('.lht-item'));
        var checked = {};
        getChecked('checkboxstar');
        getChecked('checkboxkv');


        Array.prototype.forEach.call(allCheckboxes, function (el) {
            el.addEventListener('change', toggleCheckbox);
        });

        function getChecked(name) {
            checked[name] = Array.from(document.querySelectorAll('input[name=' + name + ']:checked')).map(function (el) {
                return el.value;
            });
        }


        function setVisibility()
        {
            let x=0
            allhotel.map(function (el) {
                var checkboxstar = checked.checkboxstar.length ? _.intersection(Array.from(el.classList), checked.checkboxstar).length : true;
                var checkboxkv = checked.checkboxkv.length ? _.intersection(Array.from(el.classList), checked.checkboxkv).length : true;
                // var position = checked.position.length ? _.intersection(Array.from(el.classList), checked.position).length : true;
                // var nbaTeam = checked.nbaTeam.length ? _.intersection(Array.from(el.classList), checked.nbaTeam).length : true;
                // var conference = checked.conference.length ? _.intersection(Array.from(el.classList), checked.conference).length : true;
                if (checkboxstar && checkboxkv) {
                    el.style.display = 'block';
                    x++
                } else {
                    el.style.display = 'none';
                }
            });
            return x;
        }



        function toggleCheckbox(e) {
            getChecked(e.target.name);
            setVisibility();
        }

        // PHÂN TRANG
        var items = $(".list-hotel .lht-item");
        let numItems = items.length
        var perPage = 8;

        items.slice(perPage).hide();
        console.log($('#pagination-container'));
        $('#pagination-container').pagination({
            items: numItems,
            itemsOnPage: perPage,
            prevText: "&laquo;",
            nextText: "&raquo;",
            onPageClick: function (pageNumber) {
                var showFrom = perPage * (pageNumber - 1);
                var showTo = showFrom + perPage;
                items.hide().slice(showFrom, showTo).show();
            }
        });
    }





    function renderRoom(rooms)
    {
        let result = ""
        function temp()
        {
            let x = document.querySelector('#demo-flight-booking-single')
            x.onchange = function()
            {
                result = this.value;
                result = result.replace(' - ','*')
                result = result.replaceAll('/','-')
                let arrDate = result.split('*')
                let xx = document.querySelectorAll('.room-item')
                xx.forEach(ele=>{
                    ele.onclick = function(e)
                    {
                        let idroom = e.target.getAttribute('value')
                        e.target.setAttribute("href",`/user/${item}/${idhotel}/${idroom}/checkin=${arrDate[0]}/checkout=${arrDate[1]}`)
                    }
                })

            }
        }
        temp()

        //DANH SÁCH CÁC PHÒNG CỦA KHÁCH SẠN
        var listroomblock = document.querySelector('.list-room-block')
        let item = document.querySelector('.list-room-block').getAttribute("locationhotel")
        let idhotel = document.querySelector('.list-room-block').getAttribute("idhotel")
        let huy = "rooms[0]."+item
        // console.log(huy)
        var index = eval(huy).findIndex(obj => obj.id==idhotel);
        let listroomwhereid = "rooms[0]."+item+"["+index+"].list_room"
        var htmlListRoomChoose = eval(listroomwhereid).map(ele=>{
            return `
      <div class="room-item" id="${ele.idroom}">
        <div class="row">
          <div class="room-item-img col-md-5">
              <img class="" src="${ele.imgroom}" alt="">
          </div>
          <div class="col-md-7">
              <div>
                  <h3 style="font-size: 2.75rem;font-weight:bold">${ele.nameroom}</h3>
                  <div style="font-size: 16px;font-weight: 400">
                    <div>${ele.adult} Người lớn</div>
                    <div>${ele.child} Trẻ em</div>
                  </div>
                  <div style="float: right;font-size:20px;transform: translateY(-20%)">
                      <p>Chỉ từ</p>
                      <p class="lht-price-detail" style="color: #f39f2d; font-weight: 700;">${ele.priceroom}</p>
                      <p>/đêm</p>
                  </div>
                  <div style="clear: both;display: flex;justify-content: space-between;font-size: 20px !important;">
                      <button type="button" style="background-color: white;color: black;font-size: 20px;border-bottom: 1px solid blue;padding: 0px" data-toggle="modal" data-target="#myModal" data-whatever="${ele.nameroom}">Xem phòng</button>
                      <a  class="btn-search-click btn-search-click-listhotel chonphong" value = ${ele.idroom} style="width:fit-content;padding: 6px;font-size: 20px">Chọn phòng</a>
                  </div>
              </div>
          </div>
        </div>
      </div>
    `
        })
        listroomblock.innerHTML=htmlListRoomChoose.join('')



    //    INTRO DETAIL
        let introHotel = document.querySelector('.lht-content')
        let ele = eval("rooms[0]."+item+"["+index+"]")
        // console.log(ele.name_hotel);
        let htmlIntro = `
                      <p class="lht-name" style="font-size: 20px !important">${ele.name_hotel}</p>
                      <div class="lht-content_rate">
                          <div class="lht-content_rate_star">
                              <span class="fa fa-star checked"></span>
                              <span class="fa fa-star checked"></span>
                              <span class="fa fa-star checked"></span>
                              <span class="fa fa-star checked"></span>
                              <span class="fa fa-star checked"></span>
                          </div>
                          
                          <div class="lht-content_rate_mark">
                              <p style="margin-right: 5px">${ele.point}</p>
                              <p style="color: #9fc43a;font-size: 14px;margin-right: 5px;">Tuyệt vời</p>
                              <p style="font-size: 14px">| ${ele.count_cmt} đánh giá</p>
                          </div>
                      </div>
                      <div class="lht-direct">
                          <a href="">
                              <span class="fa fa-map-marker"></span>
                              ${ele.address}
                          </a>
                      </div>
                    `
        introHotel.innerHTML = htmlIntro
        document.querySelector('.introaftermap').innerText = "Trải nghiệm phải thử ở " + document.querySelector('.lht-name').innerText;


        //XỬ LÝ MODAL XEM PHÒNG
        $('#myModal').on('show.bs.modal', function (event) {
            var button = $(event.relatedTarget) // Button that triggered the modal
            var recipient = button.data('whatever') // Extract info from data-* attributes
            // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
            // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
            var modal = $(this)
            modal.find('.modal-title').text(recipient)
            // modal.find('.modal-body input').val(recipient)
        })
    }

}

