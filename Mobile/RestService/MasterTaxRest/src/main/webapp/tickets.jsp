
<%@page import="com.masterTax.pojo.Ticket"%>
<%@page import="com.masterTax.data.MasterData"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="js/lib/jquery-1.11.2.min.js"></script>
<script src="js/lib/jquery.mobile-1.4.5.min.js"></script>
<div data-role="header">
    <h1 style="white-space: normal;text-align: left;margin: 0;padding: 0">
        <div style="width: 15%;display: inline-block">
            <img src="img/icon/mastertax.png" style="max-width: 100%;height: auto;vertical-align: middle"/>
        </div> 
        <div style="display: inline-block;width:79%;text-align: center"> MasterTax Support</div>
    </h1>
</div>
<%
    //String hrefUrl = "http://localhost/MTS/AppResource/rs/detail";
    List<Ticket> dataList = MasterData.getTicketList();
    System.out.println("The size is "+dataList.size());
    pageContext.setAttribute("list", dataList);

%>
<div data-role="main" class="ui-content">
    <div data-role="collapsibleset">

        <c:forEach var="ticketObj" items="${list}">
            <div data-role="collapsible">
                <h3><c:out value="${ticketObj.id}"/> -- <c:out value="${ticketObj.category}"/></h3>

                <h3><c:out value="${ticketObj.category}"/></h3>
                <c:out value="${ticketObj.description}"/>
                <div style="float: right">
                    <a href="#detailedTicketPage" data-transition="slide" onclick="loadSpecificTicketDetail(<c:out value="${ticketObj.id}"/>)">
                        <img src="img/Button-Next-icon.png"/>
                    </a>
                </div>

            </div>
        </c:forEach>

    </div>
</div>




