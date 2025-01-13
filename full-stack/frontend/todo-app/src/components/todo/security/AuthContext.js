import { createContext, useContext, useState } from "react";
import { apiClient } from "../api/ApiClient";
import { executeBasicAuthenticationServiceApi, executeJwtAuthenticationServiceApi } from "../api/AuthenticateApiService";

// 1. create context 
export const AuthContext = createContext()

export const useAuth = () => useContext(AuthContext)

// 2. shared the reated context with other element
export default function AuthProvider({ children }) {

    const [isAuthenticated, setAuthenticated] = useState(false)
    const [username, setUsername] = useState(null)
    const [token, setToken] = useState(null)

    // function login(username,password){
    //     if (username === 'Anurag' && password === 'dummy') {
    //         setAuthenticated(true)
    //         setUsername(username)
    //         console.log('success')
    //         return true;
    //     }
    //     else {
    //         setAuthenticated(false)
    //         setUsername(null)
    //         return false;
    //     }
    // }
    // async function login(username, password) {

    //     const basicToken = "Basic " + window.btoa(username + ":" + password);

    //     try {
    //         const response = await executeBasicAuthenticationServiceApi(basicToken)

    //         if (response.status == 200) {
    //             setAuthenticated(true)
    //             setUsername(username)
    //             setToken(basicToken)
    //             apiClient.interceptors.request.use(
    //                 config => {
    //                     console.log("intercept and logging")
    //                     config.headers.Authorization=basicToken
    //                     return config
    //                 }
    //             )
    //             console.log('success')
    //             return true;
    //         }
    //         else {
    //             logout()
    //             return false;
    //         }
    //     }
    //     catch (error) {
    //         logout()
    //         return false;
    //     }
    // }

    async function login(username, password) {

        const basicToken = "Basic " + window.btoa(username + ":" + password);

        try {
            const response = await executeJwtAuthenticationServiceApi(username,password)

            if (response.status == 200) {
                const jwtToken = 'Bearer ' + response.data.token
                setAuthenticated(true)
                setUsername(username)
                setToken(jwtToken)
                apiClient.interceptors.request.use(
                    config => {
                        console.log("intercept and logging")
                        config.headers.Authorization=jwtToken
                        return config
                    }
                )
                console.log('success')
                return true;
            }
            else {
                logout()
                return false;
            }
        }
        catch (error) {
            logout()
            return false;
        }
    }

    function logout() {
        setUsername(null)
        setAuthenticated(false)
        setToken(null)
    }

    return (
        <AuthContext.Provider value={{ isAuthenticated, login, logout, username,token }}>
            {children}
        </AuthContext.Provider>
    )
}