import './TransferHead.css'
import {AiOutlineMinusCircle} from 'react-icons/ai'
import {AiOutlinePlusCircle} from 'react-icons/ai'

function TransferHead(){
    return(
        <div className='transferHeadComponent'>
            <p className='titleParraph'>Transfer Ticket</p>
            <section className='assignedTransferenceSection'>
                <article className='searchUserToTransfer'>
                    <p className='assignUserParraph'>Transfer to:</p>
                    <input type='text' placeholder='Search user'/>
                    <p className='quantyParraph'>Quanty of:</p>
                    <section className='quantyOfTransference'>
                        <AiOutlineMinusCircle className='minusIcon'/>
                        <p>####</p>
                        <AiOutlinePlusCircle className='plusIcon'/>
                    </section>
                </article>
            </section>
        </div>
    )
}

export default TransferHead