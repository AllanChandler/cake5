package app;

import app.config.ThymeleafConfig;
import app.controllers.BundController;
import app.controllers.CustomerController;
import app.controllers.OrderController;
import app.controllers.ToppingController;
import app.controllers.BalanceController;
import app.persistence.*;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinThymeleaf;

public class Main {

    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
    private static final String URL = "jdbc:postgresql://localhost:5432/%s?currentSchema=public";
    private static final String DB = "cupcake";

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance(USER, PASSWORD, URL, DB);


    public static void main(String[] args) {

        // Initialize Javalin and Jetty webserver
        Javalin app = Javalin.create(config -> {
            config.staticFiles.add("/public");
            config.fileRenderer(new JavalinThymeleaf(ThymeleafConfig.templateEngine()));
        }).start(7070);

        // Define routes and handlers
        app.get("/", ctx -> {
            ctx.attribute("toppingList", ToppingMapper.getToppings(connectionPool));
            ctx.attribute("bundList", BundMapper.getBunds(connectionPool));
            ctx.render("Cupcake.html");
        });

        // Add routes for controllers
        BundController.addRoutes(app, connectionPool);
        OrderController.addRoutes(app, connectionPool);
        ToppingController.addRoutes(app, connectionPool);
        CustomerController.addRoutes(app, connectionPool);
        BalanceController.addRoutes(app, connectionPool);
    }
}