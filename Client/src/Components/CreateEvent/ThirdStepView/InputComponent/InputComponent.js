import './InputComponent.css'
import alert from '../../../../images/signo-de-exclamacion.png'

function InputComponent(props){
    return(
        <div className='input-component'>
            <img src={props.one} alt="pencil-img"/>
            <section className='description-input'>
                <section className='title-input'>
                   <h3>{props.title}</h3>
                   <img src={alert} alt="alert-img"/> 
                </section>
                <p>{props.note}</p>
            </section>
        </div>
    )
}
export default InputComponent;