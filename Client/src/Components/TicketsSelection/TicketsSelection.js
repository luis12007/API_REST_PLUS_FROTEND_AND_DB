import ReturnButtonsComponent from '../Utils/ReturnButtonsComponent/ReturnButtonsComponent'
//import TicketComponent from '../Utils/TicketComponent/TicketComponent'
import ClassComponent from './ClassComponent/ClassComponent'
import HeadComponent from './HeadComponent/HeadComponent'
import './TicketsSelection.css'
import {BiSolidHandDown} from 'react-icons/bi'
import { useNavigate } from 'react-router-dom'
import swal from 'sweetalert2'

function TicketsSelection(){

    const navigate = useNavigate()

    const handleSaveChoice = () => {
        swal.fire({
            title: 'Are you sure?',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, save!'
          }).then((result) => {
            if (result.isConfirmed) {
              swal.fire(
                'Success!'
              )
              navigate('/Payment')
            }
          })
    }

    return(
        <div className='ticketsSelectionView'>
            <ReturnButtonsComponent back="/Event/Name/Buy"/>
            
            <p className='separateTitle'>Location</p>
            <section className='locationTable'>
                <section className='titleTable'>
                    <BiSolidHandDown className='titleTableIcon'/>
                    <p className='titleTableParraph'>Select the location of your preference</p>
                </section>
                <section className='tableContent'>
                    <HeadComponent/>
                    <ClassComponent type="Ultra platinum" price="$125.00"/>
                    <ClassComponent type="Ultra platinum" price="$125.00"/>
                    <ClassComponent type="Ultra platinum" price="$125.00"/>
                    <ClassComponent type="Ultra platinum" price="$125.00"/>
                    <ClassComponent type="Ultra platinum" price="$125.00"/>
                    <ClassComponent type="Ultra platinum" price="$125.00"/>
                    <ClassComponent type="Ultra platinum" price="$125.00"/>
                    <ClassComponent type="Ultra platinum" price="$125.00"/>
                    <ClassComponent type="Ultra platinum" price="$125.00"/>
                    <ClassComponent type="Ultra platinum" price="$125.00"/>
                    <ClassComponent type="Ultra platinum" price="$125.00"/>
                    <ClassComponent type="Ultra platinum" price="$125.00"/>
                </section>
            </section>
                <button className='buttonSaveChoice' onClick={handleSaveChoice}>Save my choice</button>
        </div>
    )
}

export default TicketsSelection