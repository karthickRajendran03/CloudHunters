import axios from "axios";
import Big from "big.js";
// import {IClaimable, IRawClaimableResponse} from "../model/entities";
import * as express from "express";
import moment from "moment";

export function login(authToken: string, request: any) {
    return axios({
        data: request,
        headers: {Authorization: authToken},
        method: "post",
        url: "http://localhost:8080/oauth/token",

    })
        .then((response) => {
            return (response.data);
        }, (reason) => {
            return Promise.reject(reason);
        });
}

export function register(accessToken: string, request: any) {
    return axios({
        // headers: {"X-Auth-Token": authToken},
        data: request,
        method: "post",
        url: "http:/localhost:9300/authDetails/register"
    })
        .then((response) => {
            return (response.data);
        }, (reason) => {
            return Promise.reject(reason);
        });
}
function formatDate(dateString: string) {
    const date = moment(dateString);
    return date.format("d MMM YYYY");
}

function formatPrice(subunits: number, currencyCode: string) {
    const currencyFormat = new Intl.NumberFormat("en-AU", {style: "currency", currency: currencyCode});
    const divisor = Math.pow(10, currencyFormat.resolvedOptions().maximumFractionDigits);
    const units = Big(subunits).div(divisor);
    return currencyFormat.format(Number(units));
}
