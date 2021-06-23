<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="model.Item"%>
<%@page import="Dao.ItemDao"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Update Item</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">
    <!-- Main css -->
    <link rel="stylesheet" href="css/additem.css">
</head>
<body>
    <%
		ItemDao itemDao = new ItemDao();
		String code = request.getParameter("code");
        Item item = itemDao.getItem(code);
	%>

    <div class="main">
        <section class="signup">
            <div class="container">
                <div class="signup-content">
                    <form method="POST" action="UpdateServlet" class="signup-form">
                        <h2 class="form-title">Update Item</h2>
                        <div class="form-group">
                            <label for="code">Item Code:</label><br>
                            <input type="text" class="form-input" name="code" id="code" value="<%=item.getItemCode()%>" readonly required/>
                        </div>
                        <div class="form-group">
                            <label for="name">Item Name:</label><br>
                            <input type="text" class="form-input" name="name" id="name" value="<%=item.getItemName()%>" required/>
                        </div>
                        <div class="form-group">
                            <label for="price">Item Price:</label><br>
                            <input type="text" class="form-input" name="price" id="price" value="<%=item.getPrice()%>" required/>
                        </div>
                        <div class="form-group">
                            <label for="quantity">Item Quantity:</label><br>
                            <input type="text" class="form-input" name="quantity" id="quantity" value="<%=item.getQuantity()%>" required/>
                        </div>
                        <div class="form-group">
                            <label for="supplier">Item Supplier:</label><br>
                            <input type="text" class="form-input" name="supplier" id="supplier" value="<%=item.getSupplier()%>" required/>
                        </div>
                        <div class="form-group">
                            <input type="submit" name="submit" id="submit" class="form-submit" value="Update Item"/>
                        </div>
                    </form>
                </div>
            </div>
        </section>
    </div>
</body>
</html>