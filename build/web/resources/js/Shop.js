/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    $(document).on('click', '.PurchaseButton', function() {
        $.get('DataManageController/ItemDetail?id=' + event.target.id, function (json) {
              $('#purchaseName').text(json.name);
              $('#purchaseStr').text(json.strength);
               $('#purchaseInt').text(json.intelligence);
               $('#purchaseDex').text(json.dexterity);
               $('#purchaseCost').text(json.price);
               $('#purchaseButtonSpan button').attr("id",json.itemId);
               
        });
        $( "#dialog" ).dialog();
        $('.ui-dialog-titlebar-close').html('X');
    });
    
     $('#dialog .PurchaseButton').click(function (event) {
       $.post( "purchase", { itemId: $('#dialog .PurchaseButton').attr("id")}, function(data) {
            var obj = jQuery.parseJSON( data );
            $("#userGold").text(obj.gold);
            $("#messages").empty();
            $('#messages').append(obj.message);
            $( "#dialog" ).dialog("close");
            $('html, body').animate({ scrollTop: 0 }, 'slow');
        });
        
    });
    
    $('.list-group-item').click(function (event) {
        if(document.title === "Item Shop"){
        event.preventDefault();
        $.get('DataManageController/ShopItems?category=' + event.target.id, function (json) {
            
            $('#itemStock').empty();
            var html = "";
            if(!json) html = '<div>nothing here, yet...</div>';
            $.each(json, function (index, element) {
                var stars = '';
                for(i=0;i<element.level;i++)
                    stars += '<span class="glyphicon glyphicon-star"></span>';
                html += '<div class="col-sm-4 col-lg-4 col-md-4"><div class="thumbnail"><div class="imageContainer"><span class="alignHelper"><img src="resources/images/'+ element.imagePath + '"></span></div><div class="caption"><h4 class="pull-right"><img src="resources/images/coin.png" height="25px" width="25px"></img>'+ element.price + '</h4><h4><a href="ItemDetail?id='+ element.itemId + '">'+ element.name + '</a></h4><p>'+ element.description + '</p></div><div class="ratings"><p>'+ stars + '<button id='+ element.itemId +' class="PurchaseButton" type="button">Buy</button></p></div></div></div>';
            });
            $(html).hide().appendTo("#itemStock").fadeIn(1000);
        });
        }
    });

});

