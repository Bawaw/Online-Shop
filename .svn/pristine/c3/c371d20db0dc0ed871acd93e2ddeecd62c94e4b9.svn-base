<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="backgroundLandscape">  
    <div id="backgroundOverlay">  
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="shop">Shop</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="inventory">Inventory</a>
                        </li>
                    </ul>
                    <div class="pull-right">
                        <div class="profileInfo" style="margin-top:10px;"><img src="resources/images/coin.png" height="25px" width="25px"></img><span id="userGold">${user.gold}</span> <a href="signOut" >| logout</a> </div> 
                    </div>
                    <!-- /.navbar-collapse --> 
                </div>
                <!-- /.container -->

        </nav>  
`              <div id="dialog" title="Purchase" hidden="true">
            <h3>Purchase <span id="purchaseName">itemname</span>?</h3>
            <div id="stats"> 
                <table class="table" >
                    <tr>
                        <td>Strength</td>
                        <td>Intelligence</td>
                        <td>Dexterity</td> 
                    </tr>
                    <tr>
                        <td id="purchaseStr">str</td>
                        <td id="purchaseInt">int</td> 
                        <td id="purchaseDex">dex</td>
                    </tr>
                </table>
            </div>
            <div class="ratings">
                <p>
                    <span class="glyphicon glyphicon-star"></span>
                    <span class="glyphicon glyphicon-star"></span>
                    <span class="glyphicon glyphicon-star"></span>
                    <span class="glyphicon glyphicon-star"></span>
                    <span id="purchaseButtonSpan"><button class="PurchaseButton">Purchase for <img src="resources/images/coin.png" height="25px" width="25px"></img><span id="purchaseCost">2</span></button></span>
                </p>
            </div>
        </div>
        <!-- Page Content -->
        <div class="container">
            <div class="row carousel-holder">
                
                <div class="col-md-12">
                    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                        </ol>
                        <div class="carousel-inner" style="height:300px;">
                            <div class="item active">
                                <img class="slide-image" src="resources/images/Diablo3_Slide1.jpg" alt="">
                            </div>
                            <div class="item">
                                <img class="slide-image" src="resources/images/Diablo3_Slide4.jpg" alt="">
                            </div>
                            <div class="item">
                                <img class="slide-image" src="resources/images/Diablo3_Slide3.jpg" alt="">
                            </div>
                        </div>
                        <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left"></span>
                        </a>
                        <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right"></span>
                        </a>
                    </div>
                </div>
                <div id="messages"></div>
            </div>


