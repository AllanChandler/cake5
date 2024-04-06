package app.controllers;

import app.entities.Bund;
import app.exceptions.DatabaseException;
import app.persistence.ConnectionPool;
import app.persistence.BundMapper;
import io.javalin.http.Context;
import io.javalin.Javalin;

import java.util.List;
public class BundController {

    public static void addRoutes(Javalin app, ConnectionPool connectionPool) {
        // Define route to show bund list
        app.post("/bundList", ctx -> showBundList(ctx, connectionPool));
    }

    public static void showBundList(Context ctx, ConnectionPool connectionPool) {
        try {
            // Retrieve the bund list from the database using your connectionPool
            List<Bund> bundList = BundMapper.getBunds(connectionPool);

            // Add the bund list to the context
            ctx.attribute("bundList", bundList);

            // Render the bund list view
            ctx.render("Cupcake.html");
        } catch (DatabaseException e) {
            // Handle database exception
            ctx.status(500).result("Error retrieving bund list: " + e.getMessage());
        }
    }
}
