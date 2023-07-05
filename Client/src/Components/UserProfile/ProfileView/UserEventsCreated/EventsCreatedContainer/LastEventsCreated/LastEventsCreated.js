/* import ComponentEventEditable from './ComponentEventEditable/ComponentEventEditable'; */
import './LastEventsCreated.css'
import NoneEventsCreated from './NoneEventsCreated/NoneEventsCreated';

function LastEventsCreated(){
    return(
        <div className='last-events-created'>
            <h2>Last Created</h2>
            <p></p>
            <div className='events-created-container-editables'>
                {/* <ComponentEventEditable/>
                <ComponentEventEditable/>
                <ComponentEventEditable/>
                <ComponentEventEditable/>
                <ComponentEventEditable/>
                <ComponentEventEditable/>
                <ComponentEventEditable/>
                <ComponentEventEditable/> */}
                <NoneEventsCreated/>
            </div>
        </div>
    )
}

export default LastEventsCreated;
