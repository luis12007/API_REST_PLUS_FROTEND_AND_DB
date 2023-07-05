import { useNavigate } from 'react-router-dom';
import AuthComponent from './AuthComponent/AuthComponent'
import './Form.css'
import welcome from '../../../images/felpudo.png'
import swal from 'sweetalert2'
import { gapi } from 'gapi-script';
import GoogleLogin from 'react-google-login';
import { useEffect, useState } from 'react'
import ServicesUser from '../../../Services/UserService';

function Form() {

    const clienteID = "924185836691-ose9n1vlvp9o2kbcmr4umbg11jfrls0v.apps.googleusercontent.com"
    const navigate = useNavigate();

    useEffect(() => {
        const start = () => {
            gapi.auth2.init({
                client_id: clienteID
            })
        }
        gapi.load('auth2', start)
    }, [])

    const handleAccess = async (response) => {
        const fullName = `${response.profileObj.givenName} ${response.profileObj.familyName}`;
        const responseAPI = await ServicesUser.SingUp(true, fullName, null, response.profileObj.email, true);
        console.log(responseAPI.status)
        if (responseAPI.status === 200) {
        swal.fire({
            position: 'center-center',
            icon: 'success',
            title: 'Signed up successfully!',
            showConfirmButton: false,
            timer: 1500
        });
        navigate('/LogIn')
    } else if (responseAPI.status === 406) {
        swal.fire({
            position: 'center-center',
            icon: 'error',
            title: 'The user already exists',
            showConfirmButton: false,
            timer: 1500
        });
        console.log(responseAPI)
        navigate('/LogIn')
    };
    };

    const handleFailure = (response) => {
        swal.fire({
            position: 'center-center',
            icon: 'error',
            title: 'Access denied',
            showConfirmButton: false,
            timer: 1500
        });
    };


    const onClickHandlerLogIn = async (e) => {
        e.preventDefault()
        navigate('/LogIn')
    }

    return (
        <div className='form-sign-up'>
            <h1>Welcome!</h1>
            <img src={welcome} alt="welcome-img" />
            {/* <AuthComponent /> */}
            <GoogleLogin 
                className="button-google"
                clientId={clienteID}
                buttonText="Sign up with Google"
                onSuccess={handleAccess}
                onFailure={handleFailure}
                cookiePolicy={'single_host_origin'}
            />
            <a onClick={onClickHandlerLogIn} href="." className='href-SingUp'>Do you already have an account? Sign in here!</a>
        </div>
    )
}

export default Form