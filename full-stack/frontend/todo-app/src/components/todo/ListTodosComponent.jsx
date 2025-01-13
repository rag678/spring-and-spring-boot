import { useEffect, useState } from "react";
import { deleteTodoForUsernameApi, retrieveAllTodosForUsernameApi } from "./api/TodoApiService";
import { useAuth } from "./security/AuthContext";
import { useNavigate } from "react-router-dom";

export default function ListTodosComponent() {

    // const today = new Date();
    // const targetDate = new Date(today.getFullYear() + 12, today.getMonth(), today.getDay());

    const authContext = useAuth();
    const username = authContext.username;

    const navigate = useNavigate();

    const [todos, setTodos] = useState([])
    const [message, setMessage] = useState(null)
    // const todos = [
    //     { id: 1, description: 'learn Aws', done: false, targetDate: targetDate },
    //     { id: 2, description: 'learn Devops', done: false, targetDate: targetDate },
    //     { id: 3, description: 'learn Spring', done: false, targetDate: targetDate }
    // ]

    useEffect(() => refreshTodo(), [])

    function refreshTodo() {
        retrieveAllTodosForUsernameApi(username)
            .then((response) => successResponse(response))
            .catch((error) => console.log(error))
            .finally(() => console.log('cleanup Param'))
    }

    function successResponse(response) {
        // console.log(response)
        setTodos(response.data)
    }

    function deleteTodo(id) {
        console.log("Clicked" + username + id)
        deleteTodoForUsernameApi(id, username)
            .then((response) => {
                setMessage(`Delete of todo with id = ${id} successful`)
                refreshTodo()
            })
            .catch((error) => console.log(error))
            .finally(() => console.log('cleanup Param'))
    }

    function updateTodo(id) {
        console.log("Clicked update" + username + id)
        navigate(`/todo/${id}`)
        // deleteTodoForUsernameApi(id,username)
        //     .then((response) => {
        //         setMessage(`Delete of todo with id = ${id} successful`)
        //         refreshTodo()
        //     })
        //     .catch((error) => console.log(error))
        //     .finally(() => console.log('cleanup Param'))
    }

    function addNewTodo(){
        navigate(`/todo/-1`)
    }

    return (
        <div className="container">
            <h1>Thing you want to do</h1>
            {message && <div className="alert alert-warning">{message}</div>}
            <div>
                <table className='table'>
                    <thead>
                        <tr>
                            <th>Description</th>
                            <th>Is Done ?</th>
                            <th>Target Date</th>
                            <th>Delete </th>
                            <th>Update </th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            todos.map(
                                todo => (
                                    <tr key={todo.id}>
                                        <td>{todo.description}</td>
                                        <td>{todo.done.toString()}</td>
                                        <td>{todo.targetDate}</td>
                                        <td>
                                            <button type="button" className="btn btn-danger m-1" onClick={() => deleteTodo(todo.id)}>
                                                Delete
                                            </button>
                                        </td>
                                        <td>
                                            <button type="button" className="btn btn-warning" onClick={() => updateTodo(todo.id)} >Update</button>
                                        </td>

                                    </tr>
                                )
                            )
                        }
                    </tbody>
                </table>
            </div>
            <div className="btn btn-success m-3" onClick={addNewTodo}>Add New Todo</div>
        </div>
    )
}
