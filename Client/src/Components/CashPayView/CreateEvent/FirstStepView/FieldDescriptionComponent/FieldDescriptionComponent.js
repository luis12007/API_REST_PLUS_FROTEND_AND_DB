import './FieldDescriptionComponent.css'
import alert from '../../../../images/signo-de-exclamacion.png'

function FieldDescriptionComponent(props) {
    return(
        <div className='field-event-description'>
            <section className='field-description'>
                <section className='complete-description-field'>
                    <img src={props.img} alt="write-field"/>
                    <section className='note-and-title-field'>
                        <section className='title-field'>
                                <h3>{props.title}</h3>
                                <img src={alert} alt="required-field" className='alert-img'/>
                            </section>
                            <p>{props.note}</p>
                        </section>
                </section>
                <input type='text' placeholder={props.placeholder}/>
            </section>
        </div>
    )
}

export default FieldDescriptionComponent