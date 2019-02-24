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
    <link href="../../css/highlightJS/github.css" rel="stylesheet">
    <script src="../../js/highlight.pack.js"></script>
    <script>hljs.initHighlightingOnLoad()</script>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <script src="https://cdn.rawgit.com/google/code-prettify/master/loader/run_prettify.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <title>Truth Tree</title>
    <style>
        h1 {
            font-size: 23px;
            color: rgb(51, 51, 51);
            font-family: sans-serif;
            padding-left: 10px;
            padding-right: 10px;
            margin-top: 11px;
        }

        h3 {
            margin-top: 0px;
            margin-bottom: 20px;
        }

        h4 {
            text-align: center;
            background-color: #ffffff;
            padding-top: 5px;
            padding-bottom: 5px;
        }

        .stickyHeader {
            position: -webkit-sticky; /* Safari */
            position: sticky;
            top: 50px;
        }

        h4.top {
            margin-top: 0;
        }

        .navbar {
            margin-bottom: 10px;
            position: -webkit-sticky; /* Safari */
            position: sticky;
            top: 0;
            z-index: 999;
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
                min-width: 204px !important;
                overflow-x: hidden;
            }
        }

        code {
            font-family: monospace;
            color: black;
            background-color: #f8f8f8;
        }

        .text-block {
            padding: 0 10px;
        }

        .text-body {
            margin-bottom: 10px;
            font-size: 15px;
        }

        .collections-text, .time-range-text {
            float: left;
            width: auto;
            max-width: 815px;
        }

        .basic-information-text {
            float: left;
            width: 100%;
        }

        .collectionsCode, .timeRangeCode {
            float: left;
        }


        .codeBlock {
            max-height: 221px;
            width: 390px;
            overflow: auto;
            border-radius: 4px 4px 4px 4px;
        }

        .codeBlockLarge {
            max-height: 500px;
            width: 100%;
            overflow: auto;
            border-radius: 4px 4px 4px 4px;
            padding-left: 10px;
            padding-right: 10px;
        }

        .http {
            display: inline-block;
        }

        .basicInfoStatesCode, .basicInfoCountiesCode {
            display: inline-block;
            margin-left: 10px;
            margin-right: -1px;
        }

        .basicInfoCitiesCode {
            margin-top: 10px;
            margin-left: 10px;
            margin-right: -1px;
        }

        .attributesRequestURL {
            min-width: 780px;
        }

        pre.http {
            display: inline-block;
            padding:0px;
        }

        .table>tbody>tr>td, .table>tbody>tr>th, .table>tfoot>tr>td, .table>tfoot>tr>th, .table>thead>tr>td, .table>thead>tr>th {
            padding:4px;
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
        <h1>Truth Tree</h1>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
            <li><a href="api/attributes?attributeIds=4" style="font-size: 16px;">Attributes</a></li>
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
            <li><a href="api/time_range" style="font-size: 16px;">Time Range</a></li>
            <li><a href="swagger-ui.html" style="font-size: 16px; border-right: 1px;">Swagger</a>
            </li>
        </ul>
    </div>
</nav>
<div class="text-block">
    <h3>REST Endpoints</h3>
</div>
<div class="text-block text-body stickyHeader">
    <h4 class="top">Collection</h4>
</div>
<div class="text-block text-body collections-text">

    A collection is a logical grouping of two or more attributes. When a user wants to know what
    collections are available for a location, the locationId parameter can be provided. If
    locationId is not requested, all the collections containing attributes and properties will
    be returned.

    <h5>Request URL:</h5>
    <pre class="http"><code>/api/collections</code></pre>
    <br>
    <pre class="http"><code>/api/collections?locationId=420000000</code></pre>
</div>
<div class="collectionsCode codeBlock">
    <pre>/api/collections?locationId=420000000
<code class="json">[
   {
      "collection_id":0,
      "name":"All Other Non-insurance Funds",
      "attributes":[
         {
            "attribute_id":579,
            "name":"Oth_Nonin_Fd_Cash___Sec"
         }
      ],
      "properties":[
         {
            "name":"Oth Nonin Fd Cash Sec",
            "property_id":164
         }
      ]
   },
   {
      "collection_id":1,
      "name":"Long Term Debt Outstanding",
      "attributes":[
         {
            "attribute_id":527,
            "name":"Total_LTD_Out"
         },
         {
            "attribute_id":528,
            "name":"LTD_Out_Private_Purp"
         },
         {
            "attribute_id":529,
            "name":"LTD_Out_All_Other"
         },
         {
            "attribute_id":535,
            "name":"LTD_Out_General"
         },
         {
            "attribute_id":537,
            "name":"LTD_Out_Gen_Other_Educ"
         },
         {
            "attribute_id":538,
            "name":"LTD_Out_Gen_Other_NEC"
         }
      ],
      "properties":[
         {
            "name":"All Other",
            "property_id":91
         },
         {
            "name":"General",
            "property_id":119
         },
         {
            "name":"Private Purp",
            "property_id":131
         },
         {
            "name":"Gen Other NEC",
            "property_id":159
         },
         {
            "name":"Gen Other Educ",
            "property_id":163
         },
         {
            "name":"Total",
            "property_id":180
         }
      ]
   },

   ...

   {
      "collection_id":84,
      "name":"Unemployment Revenue",
      "attributes":[
         {
            "attribute_id":126,
            "name":"Total_Unemp_Rev"
         },
         {
            "attribute_id":127,
            "name":"Unemp_Payroll_Tax"
         },
         {
            "attribute_id":128,
            "name":"Unemp_Int_Revenue"
         },
         {
            "attribute_id":129,
            "name":"Unemp_Federal_Advances"
         },
         {
            "attribute_id":130,
            "name":"Total_Expenditure"
         }
      ],
      "properties":[
         {
            "name":"Int Revenue",
            "property_id":50
         },
         {
            "name":"Payroll Tax",
            "property_id":78
         },
         {
            "name":"Federal Advances",
            "property_id":166
         },
         {
            "name":"Expenditure",
            "property_id":170
         },
         {
            "name":"Total",
            "property_id":180
         }
      ]
   }
]</code></pre>
</div>
<div style="clear: both;"></div>
<div class="text-block text-body stickyHeader">
    <h4>Time Range</h4>
</div>
<div class="text-block text-body time-range-text">
    A time range based query will allow users to find a time range for the given attributes at the
    State, County, or City level.

    <h5>Request URL:</h5>
    <pre class="http"><code>/api/time_range?level=state&value=[1]&attributes=[00011,00022]</code></pre>
</div>
<div class="timeRangeCode codeBlock">
    <pre>
<code class="json">[
    {
        "name": "Alcohol",
        "collection_id": "123",
        "attributes": [
            {
                "name": "food_tax",
                "attribute_id": "00011",
                "startYear": 1955,
                "endYear": 2005
            }]
    },
    {
        "name": "Food",
        "collection_id": "345",
        "attributes": [
            {
                "name": "food_expenditure",
                "attribute_id": "00022",
                "startYear": 1955,
                "endYear": 2005
            }]
    }
]</code></pre>
</div>
<div style="clear: both;"></div>
<div class="text-block text-body stickyHeader">
    <h4>Basic Information</h4>
</div>
<div class="text-block text-body basic-information-text">
    A basic information query will return a list of all States, Counties, or Cities.

    <h5>Request URL:</h5>
    <pre class="http"><code class="http">/api/states</code></pre>
    <br>
    <pre class="http"><code class="http">/api/states?populationRange=minValue,maxValue</code></pre>
    <br>
    <pre class="http"><code class="http">/api/counties</code></pre>
    <br>
    <pre class="http"><code class="http">/api/cities</code></pre>
</div>
<div class="basicInfoStatesCode codeBlock">
    <pre>/api/states
<code class="json">[
    {
        "name": "ALABAMA",
        "id": 10000000,
        "state_code": 1,
        "abbreviation": "AL",
        "population": "4887871"
    },
    {
        "name": "ALASKA",
        "id": 20000000,
        "state_code": 2,
        "abbreviation": "AK",
        "population": "737438"
    },
    {
        "name": "ARIZONA",
        "id": 30000000,
        "state_code": 3,
        "abbreviation": "AZ",
        "population": "7171646"
    }
]</code></pre>
</div>
<div class="basicInfoStatesCode codeBlock">
    <pre>/api/states?populationRange=4000000,5000000
<code class="json">[
    {
        "name": "ALABAMA",
        "id": 10000000,
        "state_code": 1,
        "abbreviation": "AL",
        "population": "4887871"
    },
    {
        "name": "LOUISIANA",
        "id": 190000000,
        "state_code": 19,
        "abbreviation": "KY",
        "population": "4659978"
    },
    {
        "name": "KENTUCKY",
        "id": 170000000,
        "state_code": 17,
        "abbreviation": "AZ",
        "population": "4468402"
    },
    {
        "name": "OREGON",
        "id": 380000000,
        "state_code": 38,
        "abbreviation": "OR",
        "population": "4190713"
    }
]</code></pre>
</div>
<div class="basicInfoCountiesCode codeBlock">
    <pre>/api/counties
<code class="json">[
    {
        "county": 2,
        "name": "BALDWIN COUNTY",
        "id": 11002002,
        "state_code": 1
    },
    {
        "county": 5,
        "name": "BLOUNT COUNTY",
        "id": 11005005,
        "state_code": 1
    },
    {
        "county": 8,
        "name": "CALHOUN COUNTY",
        "id": 11008008,
        "state_code": 1
    }
]</code></pre>
</div>
<div class="basicInfoCitiesCode codeBlock">
    <pre>/api/cities
<code class="json">[
    {
        "county": 1,
        "id": 12001003,
        "name": "PRATTVILLE CITY",
        "state_code": 1
    },
    {
        "county": 2,
        "id": 12002002,
        "name": "DAPHNE CITY",
        "state_code": 1
    },
    {
        "county": 2,
        "id": 12002004,
        "name": "FAIRHOPE CITY",
        "state_code": 1
    }
]</code></pre>
</div>
<div style="clear: both;"></div>
<div class="text-block text-body stickyHeader">
    <h4>Attributes</h4>
</div>
<div class="text-block text-body">
    An attributes based query allows user to search for attributes values at each level.
    Moreover, user can mention one or more collection name(s) or property name(s) or any combination
    of both to query for all attributes pertaining to them. If user wishes to find specific
    attribute values within a year range or for a given list of years, corresponding search
    parameters can be used to find desired result.
</div>
<div class="text-block text-body">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Request URL</th>
            <th>Returns</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td class="attributesRequestURL">
                <pre class="http "><code class="http">/api/attributes?level=state</code></pre>
            </td>
            <td>
                All attributes for all states.
            </td>
        </tr>
        <tr>
            <td class="attributesRequestURL">
                <pre class="http"><code class="http">/api/attributes?level=state&value=[1,2,3]</code></pre>
            </td>
            <td>
                All attributes for States with IDs 1, 2, and 3.
            </td>
        </tr>
        <tr>
            <td class="attributesRequestURL">
                <pre class="http"><code class="http">/api/attributes?level=state&value=[1,2,3]&collection=[123]</code></pre>
            </td>
            <td>
                Attribute data for the collection with ID 123 for States with
                IDs 1, 2, and 3.
            </td>
        </tr>
        <tr>
            <td class="attributesRequestURL">
                <pre class="http"><code class="http">/api/attributes?level=state&value=[1,2,3]&collection=[123]&property=[00001]</code></pre>
            </td>
            <td>
                Attribute data for the collection with ID 123 and the property
                with ID 00001 for States with IDs 1, 2, and 3.
            </td>
        </tr>
        <tr>
            <td class="attributesRequestURL">
                <pre class="http"><code class="http">/api/attributes?level=state&value=[1,2,3]&collection=[123, 345]&property=[00001,0002]</code></pre>
            </td>
            <td>
                Attribute data for the collection with IDs 123 and 345 and the
                property
                with IDs 00001 and 00002 for States with IDs 1, 2, and 3.
            </td>
        </tr>
        <tr>
            <td class="attributesRequestURL">
                <pre class="http"><code class="http">/api/attributes?level=state&value=[1,2,3]&attributes=[00022,00033]</code></pre>
            </td>
            <td>
                Attribute data for the attributes with IDs 00022 and 00033 for
                States with IDs 1, 2, and 3.
            </td>
        </tr>
        <tr>
            <td class="attributesRequestURL">
                <pre class="http"><code class="http">/api/attributes?level=state&value=[1,2,3]&attributes=[00022, 00033]&yearRange=[startYear,endYear]</code></pre>
            </td>
            <td>
                Attribute data for the attributes with IDs 00022 and 00033
                between the years startYear and endYear (inclusive) for States with IDs 1, 2, and 3.
            </td>
        </tr>
        <tr>
            <td class="attributesRequestURL">
                <pre class="http"><code class="http">/api/attributes?level=state&value=[1,2,3]&attributes=[00022, 00033]&years=[listSpecificYears]</code></pre>
            </td>
            <td>
                Attribute data for the attributes with IDs 00022 and 00033 for
                the listed years for States with IDs 1, 2, and 3.
            </td>
        </tr>
        </tbody>
    </table>
</div>
<div class="attributesCode codeBlockLarge">
    <pre>/api/attributes?level=state&value=[1,2]&collection=[123]&property=[00001,00002]&yearRange=[2017,2018]
<code class="json">[
    {
        "States": [
        {
            "name":"WA",
            "state_id":"1",
            "collections": [
            {
                "name":"Alcohol",
                "collection_id":"123",
                "properties": [
                {
                    "name":"Tax",
                    "property_id":"00001"
                },
                {
                    "name":"Expenditure",
                    "property_id":"00002"
                }]
            },
            "attributes": [
            {
                "name":"alcohol_tax",
                "attribute_id":"00011",
                "data": [
                {
                    "Year":2017,
                    "Value":20
                },
                {
                    "Year":2018,
                    "Value":30
                }]
            },
            {
                "name":"alcohol_expenditure",
                "attribute_id":"00022",
                "data": [
                {
                    "Year":2017,
                    "Value":20
                },
                {
                    "Year":2018,
                    "Value":30
                }]
            }]
        },
        {
            "name":"CA",
            "state_id":"2",
            "collections":[
            {
                "name":"Alcohol",
                "collection_id":"123",
                "properties": [
                {
                    "name":"Tax",
                    "property_id":"00001"
                },
                {
                    "name":"Expenditure",
                    "property_id":"00002"
                }],
            }]
            "attributes": [
            {
                "name":"alcohol_tax",
                "attribute_id":"00011",
                "data": [
                {
                    "Year":2017,
                    "Value":20
                },
                {
                    "Year":2018,
                    "Value":30
                }]
            },
            {
                "name":"alcohol_expenditure",
                "attribute_id":"00022",
                "data": [
                {
                    "Year":2017,
                    "Value":20
                },
                {
                    "Year":2018,
                    "Value":30
                }]
            }]

        }]
    }
]</code></pre>
</div>
<div style="clear: both;"></div>
</body>
</html>
