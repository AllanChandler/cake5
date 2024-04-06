package app.controllers;

import app.entities.Topping;
import app.exceptions.DatabaseException;
import app.persistence.ConnectionPool;
import app.persistence.ToppingMapper;
import io.javalin.http.Context;
import io.javalin.Javalin;

import java.util.List;

public class ToppingController {

    public static void addRoutes(Javalin app, ConnectionPool connectionPool) {
        // Define route to show topping list
        app.post("/toppingList", ctx -> showToppingList(ctx, connectionPool));
    }

    public static void showToppingList(Context ctx, ConnectionPool connectionPool) {
        try {
            // Retrieve the topping list from the database using your connectionPool
            List<Topping> toppingList = ToppingMapper.getToppings(connectionPool);

            // Add the topping list to the context
            ctx.attribute("toppingList", toppingList);

            // Render the topping list view
            ctx.render("Cupcake.html");
        } catch (DatabaseException e) {
            // Handle database exception
            ctx.status(500).result("Error retrieving topping list: " + e.getMessage());
        }
    }
}