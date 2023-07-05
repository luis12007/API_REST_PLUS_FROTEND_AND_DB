import AuthComponent from './AuthComponent/AuthComponent'
import './Form.css'
import welcome from '../../../images/felpudo.png'
import swal from 'sweetalert2'
import { useNavigate } from 'react-router-dom'
import { gapi } from 'gapi-script';
import GoogleLogin from 'react-google-login';
import { useEffect, useState } from 'react'
import ServicesUser from '../../../Services/UserService';

function Form() {

    const navigate = useNavigate();
    const clienteID = "924185836691-ose9n1vlvp9o2kbcmr4umbg11jfrls0v.apps.googleusercontent.com"

    useEffect(() => {
        const start = () => {
            gapi.auth2.init({
                client_id: clienteID
            })
        }
        gapi.load('auth2', start)
    }, [])

    const onClickHandler = async (e) => {
        e.preventDefault();
        swal.fire({
            position: 'center-center',
            icon: 'error',
            title: 'Access denied',
            showConfirmButton: false,
            timer: 1500
        })
    }

    const onClickHandlerSignUp = async (e) => {
        e.preventDefault();
        navigate('/SignUp')
    }

    const handleAccess = async (response) => {
        const fullName = `${response.profileObj.givenName} ${response.profileObj.familyName}`;
        const responseAPI = await ServicesUser.SingIn(fullName, null);
        localStorage.setItem('token', responseAPI.token);
        localStorage.setItem('img', response.profileObj.imageUrl);
        localStorage.setItem('name', fullName);
        localStorage.setItem('email', response.profileObj.email);
        if (responseAPI == null) {
            swal.fire({
                position: 'center-center',
                icon: 'error',
                title: 'User not found',
                showConfirmButton: false,
                timer: 1500
            });
            navigate('/LogIn')
        } else {
        swal.fire({
            position: 'center-center',
            icon: 'success',
            title: 'Log in successfully!',
            showConfirmButton: false,
            timer: 1500
        });
        navigate('/HomeLog')
    }
    };

    const handleFailure = () => {
        swal.fire({
            position: 'center-center',
            icon: 'error',
            title: 'Access denied',
            showConfirmButton: false,
            timer: 1500
        });
    };

    return (
        <div className='form-log-in'>
            <h1>Welcome!</h1>
            <img src={welcome} alt="welcome-img" />
           {/*  <AuthComponent /> */}
            <GoogleLogin 
                className="button-google"
                clientId={clienteID}
                buttonText="LogIn with Google"
                onSuccess={handleAccess}
                onFailure={handleFailure}
                cookiePolicy={'single_host_origin'}
            />
            <a onClick={onClickHandlerSignUp} href='.' className='href-Login'>You don't have an account? Sign up here!</a>
        </div>
    )
}

export default Form