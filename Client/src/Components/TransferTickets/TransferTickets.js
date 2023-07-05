import ReturnButtonsComponent from '../Utils/ReturnButtonsComponent/ReturnButtonsComponent';
import TransferHead from './TransferHead/TransferHead';
import './TransferTickets.css'
import UserContact from './UserContact/UserContact';
import swal from 'sweetalert2';
import {useNavigate} from 'react-router-dom';

function TransferTickets(){

    const navigate = useNavigate();

    function onClickTransfering(){
        swal.fire({
            title: 'Are you sure?',
            text: "You won't be able to revert this!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, transfer ticket/s!'
          }).then((result) => {
            if (result.isConfirmed) {
              swal.fire(
                'Successfully transference!'
              )
            }
          })
    }

    return(
        <div className='transferTicketsView'>
            <ReturnButtonsComponent back="/Profile/Tickets"/>
            {/* <TicketComponent/> */}
            <section className='transferTicketSection'>
                <TransferHead/>
                <section className='contentTransfer'>
                    <p>Your friends</p>
                    <section className='usersList'>
                        <UserContact name="username"/>
                        <UserContact name="username"/>
                        <UserContact name="username"/>
                        <UserContact name="username"/>
                        <UserContact name="username"/>
                        <UserContact name="username"/>
                        <UserContact name="username"/>
                        <UserContact name="username"/>
                        <UserContact name="username"/>
                        <UserContact name="username"/>
                        <UserContact name="username"/>
                        <UserContact name="username"/>
                        <UserContact name="username"/>
                        <UserContact name="username"/>
                        <UserContact name="username"/>
                        <UserContact name="username"/>
                    </section>
                </section>
            </section>
            <button className='buttonTransferTicket' onClick={onClickTransfering}>Transfer</button>
        </div>
    )
}

export default TransferTickets;