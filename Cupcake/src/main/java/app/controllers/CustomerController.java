package app.controllers;

import app.entities.Order;
import app.exceptions.DatabaseException;
import app.persistence.ConnectionPool;
import app.persistence.CustomerMapper;
import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.List;

public class CustomerController {

    public static void addRoutes(Javalin app, ConnectionPool connectionPool) {
        // Change the endpoint path to "/customerList"
        app.get("/customerList", ctx -> showCustomerList(ctx, connectionPool));
        app.post("/deleteOrder", ctx -> deleteOrder(ctx, connectionPool));
    }

    public static void showCustomerList(Context ctx, ConnectionPool connectionPool) {
        try {
            // Retrieve the order list from the database using your connectionPool
            List<Order> customerList = CustomerMapper.getCustomer(connectionPool);

            // Add the order list to the context
            ctx.attribute("customerList", customerList);

            // Render the order list view
            ctx.render("Customer.html");
        } catch (DatabaseException e) {
            // Handle database exception
            ctx.status(500).result("Error retrieving order list: " + e.getMessage());
        }
    }

    public static void deleteOrder(Context ctx, ConnectionPool connectionPool) {
        int orderId = Integer.parseInt(ctx.formParam("orderId"));

        try {
            CustomerMapper customerMapper = new CustomerMapper(); // Instantiate OrderMapper
            customerMapper.deleteOrderAndOrderLinesByOrderId(connectionPool, orderId); // Call the new method
            ctx.result("Order and associated order lines deleted successfully");
        } catch (RuntimeException e) { // Catch RuntimeException from OrderMapper
            ctx.status(500).result("Error deleting order and order lines: " + e.getMessage());
        }
    }
}



