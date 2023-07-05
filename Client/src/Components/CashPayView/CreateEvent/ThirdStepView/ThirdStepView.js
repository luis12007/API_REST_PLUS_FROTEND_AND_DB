import './ThirdStepView.css'
import logo from '../../../images/pinata.png'
import InputComponent from './InputComponent/InputComponent';
import CommonInputComponent from './CommonInputComponent/CommonInputComponent';
import SimpleComponent from './SimpleComponent/SimpleComponent';
import pencil from '../../../images/lapiz.png'
import stars from '../../../images/estrellas.png'
import ValorationComponent from './ValorationComponent/ValorationComponent';
import meta from '../../../images/linea-de-meta.png'

function ThirdStepView(){
    return(
        <div className='third-step-create-event'>
            <form className='third-step-form'>
                <section className='title-third-step'>
                    <img src={logo} alt="pinata-title"/>
                    <h2>Create Event</h2>
                </section>
                <InputComponent one={pencil}
                title="Add contact resources to provide timely event information to all fans:"
                note="Note: You can place customer service telephone numbers, email address e instagram."/>  
                <CommonInputComponent title="Email:"
                note="Note: If it is an email address, follow the standard: user####@email.com." 
                placeholder="Ej: user####@email.com"/>
                <CommonInputComponent title="Phone:"
                note="Note: If it is a telephone number, put the correlative of your country before it. Ex: +1, +55, etc." 
                placeholder="Ej: user####@email.com"/>
                <SimpleComponent/>
                <InputComponent one={stars}
                title="Specifies the rating that users can give to the event:" 
                note="Note: Click on the stars that indicate the maximum rating range that can be given to the event."/>
                <ValorationComponent/>
                <section className='finish-msg'>
                    <h2>You finished setting up your event</h2>
                    <img src={meta} alt="finish-line"/>
                    <h3>Congratulations</h3>
                </section>
                <section className='div-actions-btns'>
                    <section className='actions-btns'>
                        <button className='btn-cancel'>Cancel</button>
                        <button className='btn-submit'>Submit</button>
                    </section>
                </section>
            </form>
        </div>
    )
}

export default ThirdStepView;