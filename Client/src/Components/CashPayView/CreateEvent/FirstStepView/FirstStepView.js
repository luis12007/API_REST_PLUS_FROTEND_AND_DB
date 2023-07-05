import './FirstStepView.css'
import logo from '../../../images/pinata.png'
import user from '../../../images/usuario.png'
import FieldComponent from './FieldComponent/FieldComponent'
import pencil from '../../../images/lapiz.png'
import FieldDescriptionComponent from './FieldDescriptionComponent/FieldDescriptionComponent'
import magazine from '../../../images/revista.png'
import FieldDateComponent from './FieldDateComponent/FieldDateComponent'
import calendar from '../../../images/calendario.png'
import gps from '../../../images/marcador-de-posicion.png'
import FieldImgEventComponent from './FieldImgEventComponent/FieldImgEventComponent'
import collaborative from '../../../images/colaborar.png'
import alert from '../../../images/signo-de-exclamacion.png'

function FirstStepView(){
    return(
        <div className='first-step-create-event'>
            <form className='first-step-div' >
                <section className='title-first-step'>
                    <img src={logo} alt="pinata-title"/>
                    <h2>Create Event</h2>
                </section>
                <section className='user-identifier'>
                    <img src={user} alt="user-identifier"/>
                    <p>@Username</p>
                </section>
                <FieldComponent img={pencil} title="Title of Event" 
                    note="Note: The title must have a minimum of 2 characters and a maximum of 25 characters" 
                    placeholder="Ej:Flow Festival" height="40px"/>
                <FieldDescriptionComponent img={magazine} title="Description of the event:"
                    note="Note: The description must have a maximum of 250 characters"
                    placeholder=""
                    height = "80px"/>
                <FieldDateComponent img={calendar} title="Start time of the event, date and place:"
                    one="Note: The  time format is 24 hours. The accepted format for the date is: dd/mm/yy."
                    second="Note: Here specify exactly the name of the establishment where the event will take place. "
                 />
                <FieldComponent img={gps} title="Address of the event venue:" 
                note="Note: Enter in detail the address of the place where the event will take place" 
                placeholder="" height="40px"/>
                <FieldImgEventComponent/>
                <FieldComponent img={collaborative} title="Select event contributors: "
                note="Note: Employees who will participate and be able to view and edit the event post" 
                placeholder="Soundman" height="40px"/>
                <section className='info-sign'>
                    <img src={alert} alt="alert-img"/>
                    <p>This symbol indicates that you cannot continue without completing the required fields</p>
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

export default FirstStepView