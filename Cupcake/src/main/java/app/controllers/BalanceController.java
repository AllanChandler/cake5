package app.controllers;

import app.exceptions.DatabaseException;
import app.persistence.ConnectionPool;
import app.persistence.BalanceMapper;
import io.javalin.http.Context;
import io.javalin.Javalin;

public class BalanceController {

    public static void addRoutes(Javalin app, ConnectionPool connectionPool) {
        // Define route to handle form submission
        app.post("/addBalance", ctx -> addBalance(ctx, connectionPool));
        app.get("/addBalance", ctx -> ctx.render("Balance.html"));

    }

    public static void addBalance(Context ctx, ConnectionPool connectionPool) {
        // Extract email and balance from the request
        String email = ctx.formParam("email");
        int balance = 5;  ////////////// TJEK OM DET BEHØVES SAMT SKRIV EN KOMMENTAR NÅR MAN KLIKKER PÅ ADD BALANCE BUTTON////////////////

        try {
            // Parse balance from form parameter
            balance = Integer.parseInt(ctx.formParam("balance"));

            // Call the method to add balance to the user's account
            BalanceMapper.addBalance(email, balance, connectionPool);

            // Set success message
            ctx.attribute("message", "Balance added successfully");
        } catch (NumberFormatException e) {
            // Handle the case when the balance parameter cannot be parsed as an integer
            ctx.attribute("error", "Invalid balance value");
        } catch (DatabaseException e) {
            // Handle database exception
            ctx.attribute("error", "Failed to add balance: " + e.getMessage());
        }

        // Render the view (assuming you have a corresponding HTML file)
        ctx.render("Balance.html");
    }
}
