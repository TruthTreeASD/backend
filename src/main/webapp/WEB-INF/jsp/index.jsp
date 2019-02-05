<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="../../css/bootstrap.min.css" rel="stylesheet">

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <title>TruthTree</title>
    <style>
        h1 {
            font-size: 23px;
            color: rgb(51, 51, 51);
            font-family: sans-serif;
            padding-left: 10px;
            padding-right: 10px;
            margin-top: 11px;
        }

        .dropdown:hover > .dropdown-menu {
            display: block;
        }

        .dropdown-menu {
            min-width: 100px !important;
            margin-left: 8px;
        }

        .dropdown-menu li a {
            padding: 5px 5px;
            font-weight: 300;
        }

        .multi-column-dropdown {
            list-style: none;
            margin: 0px;
            padding: 0px;
        }

        .multi-column-dropdown li a {
            display: block;
            clear: both;
            line-height: 1.428571429;
            color: #333;
            white-space: normal;
        }

        .multi-column-dropdown li a:hover {
            text-decoration: none;
            color: #fff;
            background-color: #999;
        }

        @media (max-width: 250px) {
            .dropdown-menu.multi-column {
                min-width: 200px !important;
                overflow-x: hidden;
            }
        }

        #col {
            width: 33.33333333%;
        }

    </style>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse"
                data-target="#bs-example-navbar-collapse-1">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <h1>TruthTree</h1>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
            <li><a href="api/attributes" style="font-size: 16px;">Attributes</a></li>
            <li class="dropdown">
                <a class="dropdown-toggle" style="font-size: 16px;">Basic Info <b
                        class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li>
                        <div class="row">
                            <div class="col-md-12">
                                <ul class="multi-column-dropdown">
                                    <li><a href="api/states">States</a></li>
                                    <li><a href="api/counties">Counties</a></li>
                                    <li><a href="api/cities">Cities</a></li>
                                </ul>
                            </div>
                        </div>
                    </li>
                </ul>
            </li>
            <li><a href="api/collections" style="font-size: 16px;">Collections</a></li>
        </ul>
    </div>
</nav>
</body>
</html>