var price = document.querySelectorAll(".lht-price-detail")
for(let i = 0;i<price.length;i++)
{
    let money = price[i].innerText
    var price1 = Number(money.substring(0,money.indexOf(' ')))
    document.querySelectorAll(".lht-price-detail")[i].innerHTML = new Intl.NumberFormat({ style: 'currency', currency: 'JPY' }).format(price1)+" VND"
}