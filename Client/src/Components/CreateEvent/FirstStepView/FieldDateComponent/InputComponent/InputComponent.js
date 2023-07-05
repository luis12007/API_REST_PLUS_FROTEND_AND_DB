import './InputComponent.css'

function InputComponent(props){
    return(
        <div className='input-component'>
            <p>{props.title}</p>
            <input type={props.type} name={props.identifier} id={props.identifier} placeholder={props.placeholder}/>
        </div>
    )
}

export default InputComponent