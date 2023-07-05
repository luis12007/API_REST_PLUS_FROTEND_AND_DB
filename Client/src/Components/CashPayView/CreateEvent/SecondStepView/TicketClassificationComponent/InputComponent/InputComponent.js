import './InputComponent.css'

function InputComponent(){
    return(
        <div className='input-component'>
                <h3>Class:</h3>
                <input type='text' placeholder='Ej:Platinum' className='input-text'/>
        </div>
    )
}

export default InputComponent;