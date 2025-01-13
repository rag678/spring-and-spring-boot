import { Link, useParams } from "react-router-dom";
import { useState } from "react";
import { retrieveHelloWorldParam} from "./api/HelloWorldApiService";
import { useAuth } from "./security/AuthContext";

export default function WelcomeComponent() {
    const { username } = useParams();
    const [message, setMessage] = useState(null)
    const authContext = useAuth()
    const token = authContext.token

    function callHelloWorldRestApi() {

        console.log("hello world Api called")

        // axios.get('http://localhost:8080/hello-world')
        // .then((response)=> succesfullResponse(response))
        // .catch((error) => errorResponse(error))
        // .finally(()=> console.log('cleanup'))

        // retrieveHelloWorldBean()
        //     .then((response) => succesfullResponse(response))
        //     .catch((error) => errorResponse(error))
        //     .finally(() => console.log('cleanup'))

            retrieveHelloWorldParam('name',token)
            .then((response) => succesfullResponse(response))
            .catch((error) => errorResponse(error))
            .finally(() => console.log('cleanup Param'))


    }

    function succesfullResponse(response) {
        console.log(response)
        setMessage(response.data.message)
    }

    function errorResponse(error) {
        console.log(error)
        // console.error(error)
    }




    return (
        <div className='WelcomeComponent'>
            <h1>WelCome Mere Dost {username}</h1>
            <div className="Welcome">
                Manage your Todos : <Link to="/todos">Go Here</Link>
            </div>
            <div>
                <button type="button" className="btn btn-success m-5" onClick={callHelloWorldRestApi}>Call Hello World</button>
            </div>
            <div className="text-info">{message}</div>
        </div>
    )
}