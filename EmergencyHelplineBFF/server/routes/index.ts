import * as express from "express";
import {login, register} from "../app/appservice";

export const emergencyappBFF = (app: express.Application) => {
    app.get("/", (req: express.Request, res: express.Response) => {
        res.send("Hello world!");
    });

    app.get("/api/login", (req: express.Request, res: express.Response) => {
        const authToken = req.header("Authorization");
        login(authToken, req)
            .then((claimables) => {
                res.send(claimables);
            }, (reason) => {
                res.status(500).send(reason.toString());
            });
    });
    app.get("/api/register", (req: express.Request, res: express.Response) => {
        const access_token = req.params.access_token;
        register(access_token, req)
            .then((claimables) => {
                res.send(claimables);
            }, (reason) => {
                res.status(500).send(reason.toString());
            });
    });
};
