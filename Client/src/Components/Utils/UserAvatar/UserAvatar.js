import './UserAvatar.css'
import off from '../../../images/apagar.png'
import { useNavigate } from 'react-router-dom'
import Swal from 'sweetalert2'

function UserAvatar(){
    const img = localStorage.getItem('img');
    const name = localStorage.getItem('name');
    const navigate = useNavigate();

    const onClickHandler = async (e) => {
        Swal.fire({
            title: 'Are you sure?',
            text: "You're go to log out!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Log out!'
          }).then((result) => {
            if (result.isConfirmed) {
                navigate("/LogIn");              
            }
          })
    }

    return(
        <div className='user-avatar'>
            <section className='log-out' onClick={onClickHandler}>
                <p>Log out</p>
                <img src={off} alt="button-log-out"/>
            </section>
            <img src={img} alt="user-logo"/>
            <h3>{name}</h3>
        </div>
    )
}

export default UserAvatar