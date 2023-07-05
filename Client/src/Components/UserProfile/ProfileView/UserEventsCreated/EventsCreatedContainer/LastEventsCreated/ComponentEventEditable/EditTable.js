import EventComponent from '../../../../../../../Utils/EventComponent/EventComponent';
import './EditTable.css'
import Pencil from '../../../../../../../../images/lapiz.png'
import Delete from '../../../../../../../../images/eliminar.png'


function ComponentEventEditable(){
    return(
        <div className='event-component-with-btns'>
            <button>
                    <img src={Pencil} alt="pencil" className='edit-btn'/>
            </button>
            <button>
                    <img src={Delete} alt="delete-btn" className='delete-btn'/>
            </button>
                    <EventComponent/>
        </div>
    )
}

export default ComponentEventEditable;