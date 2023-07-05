import Form from '../Form/Form'
import Logo from '../../Utils/Logo/Logo'
import './FormContainer.css'

function FormContainer(){
    return(
        <div className='form-container'>
            <div className='form-logo'>
                <Logo/>
            </div>
            <div className='form-auth'>
                <Form/>
            </div>
        </div>
    )
}

export default FormContainer