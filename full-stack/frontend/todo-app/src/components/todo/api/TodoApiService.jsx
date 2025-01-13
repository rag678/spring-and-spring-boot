import { apiClient } from "./ApiClient";


export const retrieveAllTodosForUsernameApi =
    (name) => apiClient.get(`/users/${name}/todos`);

export const deleteTodoForUsernameApi =
    (id, name) => apiClient.delete(`/users/${name}/todos/${id}`);

export const retrieveTodoApi =
    (id, name) => apiClient.get(`/users/${name}/todos/${id}`);

export const updateTodoApi =
    (id, name, todo) => apiClient.put(`/users/${name}/todos/${id}`, todo);
export const createTodoApi =
    (name, todo) => apiClient.post(`/users/${name}/todos`, todo);