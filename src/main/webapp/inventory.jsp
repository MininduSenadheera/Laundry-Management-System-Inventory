<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Item"%>
<%@page import="Dao.ItemDao"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Inventory</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="css/inventory.css">
</head>
<body>
	<%
		ItemDao itemDao = new ItemDao();
		ArrayList<Item> itemList = itemDao.getItems();
	%>
	<div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
				<div class="table100">
					<table>
						<thead>
							<tr class="table100-head">
								<th class="column1">Item Code</th>
								<th class="column2">Item Name</th>
								<th class="column3">Quantity</th>
								<th class="column4">Unit Price</th>
								<th class="column5">Supplier</th>
								<th class="column6">Total value</th>
								<th class="column7"></th>
								<th class="column8"></th>
							</tr>
						</thead>
						<tbody>
                            <%for(Item item: itemList){ %>
                                <tr>
                                    <td class="column1"><%=item.getItemCode()%></td>
                                    <td class="column2"><%=item.getItemName()%></td>
                                    <td class="column3"><%=item.getQuantity()%></td>
                                    <td class="column4"><%=item.getPrice()%></td>
                                    <td class="column5"><%=item.getSupplier()%></td>
                                    <td class="column6"><%=(item.getPrice()*item.getQuantity())%></td>
                                    <td class="column7">
                                        <a href="updateitem.jsp?code=<%=item.getItemCode()%>" class="btn btn-sm btn-primary">Update Item</a>
                                    </td>
                                    <td class="column8">
                                        <form action="DeleteServlet" method="post">
                                            <input type="hidden" id="code" name="code" value="<%=item.getItemCode()%>">
                                            <input type="submit" class="btn btn-sm btn-delete" value="Delete Item">
                                        </form>										
                                    </td>
                                </tr>		
                            <%}%>						
						</tbody>
					</table>
				</div>
				<br><br>
				<center>
					<p>To add a new item go to <b><a href="additem.jsp">Add Item page</a><b></P>
				<center>
			</div>
		</div>
	</div>
</body>
</html>