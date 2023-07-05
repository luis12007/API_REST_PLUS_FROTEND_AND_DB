import './FieldDateComponent.css'
import alert from '../../../../images/signo-de-exclamacion.png'
import InputComponent from './InputComponent/InputComponent'

function FieldDateComponent(props){
    return(
        <div className='field-date-component'>
            <section className='description-field-date'>
                <img src={props.img} alt="calendar-field"/>
                <section className='description-field'>
                    <section className='title-field-date'>
                        <h3>{props.title}</h3>
                        <img src={alert} alt="alert-img"/>
                    </section>
                    <p>{props.one}</p>
                    <p>{props.second}</p>
                </section>
            </section>
            <section className='inputs-field-date'>
                <InputComponent title="Date:" type="date" placeholder="dd/mm/yyyy" identifier="date"/>
                <InputComponent title="Time" type="time" placeholder="00:00" identifier="time"/>
                <InputComponent title="Place:" type="text" placeholder="Ej: Estadio Cuscatlán" identifier="place"/>
            </section>
        </div>
    )
}

export default FieldDateComponent