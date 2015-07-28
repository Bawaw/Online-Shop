<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Item Detail</title>
        <link href="resources/css/bootstrap.min.css" rel="stylesheet">
                <link rel="stylesheet" href="resources/css/jquery-ui.css">
                        <link href="resources/css/shop-homepage.css" rel="stylesheet">
         <script src="http://code.jquery.com/jquery-1.10.2.js"/>
        <script src="resources/js/jquery.js"></script>
        <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <!-- Bootstrap Core JavaScript -->
       
        <script src="resources/js/bootstrap.min.js"></script>
        <script src="resources/js/Shop.js"></script>
    </head>

    <body>
        <jsp:include page="Title.jsp"></jsp:include>
         <div class="row">

                <div class="col-md-3">
                    <p class="lead">${item.name}</p>
                    <div class="list-group">
                        <a id="All" href="shop?category=All" class="list-group-item">All</a>
                        <a id="Helm" href="shop?category=Helm" class="list-group-item">Helm</a>
                        <a id="Armor" href="shop?category=Armor" class="list-group-item">Armor</a>
                        <a id="Gauntlets" href="shop?category=Gauntlets" class="list-group-item">Gauntlets</a>
                        <a id="Shield" href="shop?category=Shield" class="list-group-item">Shield</a>
                        <a id="Sword" href="shop?category=Sword" class="list-group-item">Swords</a>
                    </div>
                </div>
                <div class="col-md-9">
            <div class="row">

                <div class="col-sm-4 col-lg-4 col-md-4">
                    <div class="thumbnail">
                        <div class="imageContainer">
                            <img src="resources/images/${item.imagePath}">
                    </div>
                    <div class="caption">
                        <h4 class="pull-right"><img src="resources/images/coin.png" height="10px" width="10px"></img>${item.price}</h4>
                        <h4><a href="#">${item.name}</a>
                        </h4>
                          <button id="${item.itemId}" class="PurchaseButton" type="button">Buy</button> 
                    </div>
                    <div class="ratings">
                        <p>
                            <c:forEach begin="1" end="${item.level}" varStatus="loop">
                                <span class="glyphicon glyphicon-star"></span>
                            </c:forEach>
                        </p>
                    </div>
                </div>
            </div>
                     <table class="table" >
                        <tr>
                            <td>Strength</td>
                            <td>Intelligence</td>
                            <td>Dexterity</td> 
                        </tr>
                        <tr>
                            <td>"${item.strength}"</td>
                            <td>"${item.intelligence}"</td> 
                            <td>"${item.dexterity}"</td>
                        </tr>
                    </table>
                    <div class = "itemDescription">
                    <p>${item.description}</p>
                    </div>
        </div>
        <button>Back</button>
        <button>Buy</button>

    </div>

</div>

</div>
<!-- /.container -->

<div class="container">

    <hr>

    <!-- Footer -->
    <footer>
        <div class="row">
            <div class="col-lg-12">
                <p>Copyright &copy; Your Website 2014</p>
            </div>
        </div>
    </footer>

</div>
<!-- /.container -->

<!-- jQuery -->

</body>
</html>
