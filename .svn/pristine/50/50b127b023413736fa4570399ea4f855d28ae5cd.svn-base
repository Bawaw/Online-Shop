<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <!--<fmt:setLocale value="en"/>-->
    <fmt:setBundle basename="messages" />
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <link rel="stylesheet" href="resources/css/reset.css">
        <link rel='stylesheet prefetch' href='http://daneden.github.io/animate.css/animate.min.css'>
        <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Roboto:400,100,400italic,700italic,700'>
        <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css'>
        <link rel="stylesheet" href="resources/css/style.css">
        <script src="resources/jquery/LoginFrontend.js"></script>
    </head>

    <body>
        <div id="backgroundLandscape">  
            <div id="backgroundOverlay">  
        <div id = "serverState"></div>
                
        <div class='form aniamted bounceIn'>
            <div class='switch'>
                <i class='fa fa-pencil fa-times'></i>
            </div>
            
            
            <div class='switch'>
            <i class='fa fa-pencil fa-times'></i>
            <div class='tooltip'>Register</div>
            </div>
            <div class='login'>
                <h2><fmt:message key="login.title"/></h2>
                <div id="errors">
                <c:forEach var="error" items="${errorMessages}">
                        <div class='alert'>
                          <div class='fa fa-times-circle'></div>${error}</div>
                </c:forEach>
                </div>
  
                <form  method="post" action="login">
                    <input placeholder='Username' type='username'  id='username' name='username' value = "<c:out value="Admin" />">
                    <input placeholder='Password' type='password' ide='password' name='password' value = "<c:out value="t" />">
                    <input type="submit" id="loginButton" value="Log in">
                </form>
            </div>
            <div class='register'>
                <h2><fmt:message key="register.title"/></h2>
                <div id="errors">
                <c:forEach var="error" items="${errorMessages}">
                        <div class='alert'>
                          <div class='fa fa-times-circle'></div>${error}</div>
                </c:forEach>
                </div>
                <form  method="post" action="register">
                    <input placeholder='Username' type='username'  id='username' name='username' value = "<c:out value="" />">
                    <input placeholder='nickname' type='nickname'  id='nickname' name='nickname' value = "<c:out value="" />">
                    <input placeholder='Password' type='password' ide='password' name='password' value = "<c:out value="" />">
                    <input id="loginButton" type="submit" value="Register">
                </form>
            </div>
            <footer>
                <a href='http://baldercroquet.webringcatharsis.com'><fmt:message key="linkwebsite"/></a>
            </footer>
        </div>
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

        <script src="resources/js/index.js"></script>

    </body>
</html>
