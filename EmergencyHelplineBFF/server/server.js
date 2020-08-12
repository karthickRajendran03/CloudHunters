//import dotenv from "dotenv";
//import express from "express";
//import * as routes from "./routes";

//dotenv.config();

//const port = process.env.SERVER_PORT;
//c//onst app = express();

//r/outes.register(app);

//app.listen(port, () => {
    // tslint:disable-next-line:no-console
    //console.log(`Server started at http://localhost:${port}`);
//});


const express = require('express')
const bodyParser = require('body-parser')
const cors = require('cors')
const dotenv = require('dotenv')
dotenv.config();
const movieRouter = require('./routers/index')

const app = express()
const apiPort = 3000

app.use(bodyParser.urlencoded({ extended: true }))
app.use(cors())
app.use(bodyParser.json())

app.get('/', (req, res) => {
    res.send('Hello World!')
})

app.use('/api', movieRouter)

app.listen(apiPort, () => console.log(`Server running on port ${apiPort}`))