package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Item;

public class ItemDao {

    //database connection
    protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/laundry_management_system","root","");

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

    //add item
    public boolean AddItem(Item item) throws ClassNotFoundException{

        //sql statement
        String Add_Item_SQL = "INSERT INTO inventory" + " (item_name, unit_price, quantity, supplier) VALUES " + " (?,?,?,?) ";

        //boolean variable to return
        boolean trueorfalse = false; 

        try(
            //database connection
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(Add_Item_SQL);)
            {
            statement.setString(1, item.getItemName());
            statement.setDouble(2, item.getPrice());
            statement.setInt(3, item.getQuantity());
            statement.setString(4, item.getSupplier());

                //running the sql query
                int result = statement.executeUpdate(); 
                
                //checking whether added successful
                if (result > 0){
                    trueorfalse = true;
                }
                statement.close();

            //closing the database connection
            connection.close();

        } catch (SQLException e){
            e.printStackTrace();
        } 

        return trueorfalse;
    }

    //get item by item code
    public Item getItem(String code) throws ClassNotFoundException{

        //SQL
        String Get_Items_SQL = "SELECT * FROM inventory WHERE item_code = ?";

        Item item = new Item();

        try(
            //database connection
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(Get_Items_SQL);){
                
            statement.setString(1, code);

            //start query and retrieve data
            ResultSet itemdetails = statement.executeQuery();
            itemdetails.next();
            item.setItemCode(itemdetails.getString("item_code"));
            item.setItemName(itemdetails.getString("item_name"));
            item.setPrice(itemdetails.getDouble("unit_price"));
            item.setQuantity(itemdetails.getInt("quantity"));
            item.setSupplier(itemdetails.getString("supplier"));

            //end db connection
            connection.close();

        } catch (SQLException e){
            e.printStackTrace();
        } 
        return item;
    }

    //get all items
    public ArrayList<Item> getItems() throws ClassNotFoundException{

        //SQL
        String Get_Items_SQL = "SELECT * FROM inventory";

        //Creating an array list of items
        ArrayList<Item> itemList = new ArrayList<Item>();

        try(
            //database connection
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(Get_Items_SQL);){

            //start query and retrieve data
            ResultSet itemdetails = statement.executeQuery();
            while(itemdetails.next()){
                Item item = new Item();
                item.setItemCode(itemdetails.getString("item_code"));
                item.setItemName(itemdetails.getString("item_name"));
                item.setPrice(itemdetails.getDouble("unit_price"));
                item.setQuantity(itemdetails.getInt("quantity"));
                item.setSupplier(itemdetails.getString("supplier"));
                itemList.add(item);
            }
            //end db connection
            connection.close();

        } catch (SQLException e){
            e.printStackTrace();
        } 
        return itemList;
    }


    //update items
    public boolean UpdateItem(String code, Item item) throws ClassNotFoundException{

         //sql statement
        String Update_Item_SQL = "UPDATE inventory SET item_name = ?, unit_price = ?, quantity = ?, supplier = ? WHERE item_code = ?";

        //boolean variable to return
        boolean trueorfalse = false; 

        try(
            //database connection
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(Update_Item_SQL);){  

                statement.setString(1, item.getItemName()); 
                statement.setDouble(2, item.getPrice()); 
                statement.setInt(3, item.getQuantity()); 
                statement.setString(4, item.getSupplier()); 
                statement.setString(5, code);

                //running the sql query
                int result = statement.executeUpdate(); 
                
                //checking whether update successful
                if (result > 0){
                    trueorfalse = true;
                }
                statement.close();

            //closing the database connection
            connection.close();

        } catch (SQLException e){
            e.printStackTrace();
        } 

        return trueorfalse;
    }

    //delete item
    public boolean deleteItem(String code) throws ClassNotFoundException{

        //SQL
        String Delete_Item_SQL = "DELETE FROM inventory WHERE item_code = ?";

        //boolean variable to return
        boolean trueorfalse = false; 

        try(
            //database connection
            Connection connection = getConnection();

            PreparedStatement statement = connection.prepareStatement(Delete_Item_SQL);){

            statement.setString(1, code);

            //running the sql query
            int result = statement.executeUpdate();
            
            //checking whether deleted successful
            if (result > 0){
                trueorfalse = true;
            }
            statement.close();

            //end db connection
            connection.close();

        } catch (SQLException e){
            e.printStackTrace();
        } 
        return trueorfalse;
    }
}
