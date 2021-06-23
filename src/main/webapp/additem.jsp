<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Add New Item</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">
    <!-- Main css -->
    <link rel="stylesheet" href="css/additem.css">
</head>
<body>
    <div class="main">
        <section class="signup">
            <div class="container">
                <div class="signup-content">
                    <form method="POST" action="NewItemServlet" class="signup-form">
                        <h2 class="form-title">Add New Item</h2>
                        <div class="form-group">
                            <input type="text" class="form-input" name="name" id="name" placeholder="Enter the item name" required/>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-input" name="price" id="price" placeholder="Enter the item price" required/>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-input" name="quantity" id="quantity" placeholder="Enter the item quantity" required/>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-input" name="supplier" id="supplier" placeholder="Enter the item supplier's name" required/>
                        </div>
                        <div class="form-group">
                            <input type="submit" name="submit" id="submit" class="form-submit" value="Add Item"/>
                        </div>
                    </form>
                </div>
            </div>
        </section>
    </div>
</body>
</html>