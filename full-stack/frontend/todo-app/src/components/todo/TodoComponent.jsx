import { useNavigate, useParams } from "react-router-dom"
import { createTodoApi, retrieveTodoApi, updateTodoApi } from "./api/TodoApiService";
import { useEffect, useState } from "react";
import { useAuth } from "./security/AuthContext";
import { ErrorMessage, Field, Form, Formik } from 'formik'
import {moment} from 'moment'


export default function TodoComponent() {

    const authContext = useAuth()
    const username = authContext.username;
    const navigate = useNavigate()

    const { id } = useParams();
    const [description, setDescription] = useState('');
    const [targetDate, setTargetDate] = useState('');

    useEffect(
        () => retrieveTodo(), [id]
    )

    function retrieveTodo() {

        if (id != -1) {
            retrieveTodoApi(id, username)
                .then(
                    (response) => {
                        console.log(response)
                        setDescription(response.data.description)
                        setTargetDate(response.data.targetDate)
                    }
                )
                .catch((error) => console.log(error))
                .finally(() => console.log('cleanup Param'))
        }
    }

    function onSubmit(values) {
        const todo = {
            id: id,
            username: username,
            description: values.description,
            targetDate: values.targetDate,
            done: false
        }

        if (id == -1) {
            createTodoApi(username, todo)
                .then(
                    (response) => {
                        console.log(response)
                        navigate('/todos')
                    }
                )
                .catch((error) => console.log(error))
                .finally(() => console.log('cleanup - done'))
        }
        else {
            updateTodoApi(id, username, todo)
                .then(
                    (response) => {
                        console.log(response)
                        navigate('/todos')
                    }
                )
                .catch((error) => console.log(error))
                .finally(() => console.log('cleanup - done'))
        }
    }


    function validate(values) {
        let error = {
            // description : 'Enter a valid description',
            // targetDate : 'Enter a valid Target date'
        }

        if (values.description.length < 5) {
            error.description = 'Enter atleast 5 character'
        }
        // !moment(values.targetDate).isValid()
        if (values.targetDate == null || values.targetDate === '' ) {
            error.targetDate = 'Enter a valid date'
        }

        // console.log(values)
        return error
    }

    return (
        <div className="container">
            <h1>Enter Todo details</h1>
            <div>
                <Formik initialValues={{ description, targetDate }}
                    enableReinitialize={true}
                    onSubmit={onSubmit}
                    validate={validate}
                    validateOnChange={false}
                    validateOnBlur={false}
                >
                    {
                        (props) => (
                            <Form>
                                <ErrorMessage
                                    name='description'
                                    component="div"
                                    className="alert alert-warning"
                                />
                                <ErrorMessage
                                    name='targetDate'
                                    component="div"
                                    className="alert alert-warning"
                                />
                                <fieldset className="form-group">
                                    <label htmlFor="">Description</label>
                                    <Field type='text' className='form-control' name='description' />
                                </fieldset>
                                <fieldset className="form-group">
                                    <label htmlFor="">Target Date</label>
                                    <Field type='date' className='form-control' name='targetDate' />
                                </fieldset>
                                <div>
                                    <button className="btn btn-success m-5" type="submit">Save</button>
                                </div>
                            </Form>
                        )
                    }
                </Formik>
            </div>
        </div>
    )
}