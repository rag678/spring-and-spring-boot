import { apiClient } from "./ApiClient";

export const executeBasicAuthenticationServiceApi =
    (token) => apiClient.get(`/basicauth`, {
        headers: {
            Authorization: token
        }
    });

    export const executeJwtAuthenticationServiceApi =
    (username,password) => apiClient.post(`/authenticate`, {
        username,password
    });