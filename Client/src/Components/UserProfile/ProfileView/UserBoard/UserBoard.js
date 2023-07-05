import Board from '../../../Utils/Board/Board'
import BoardEvents from './BoardEvents/BoardEvents'
import Searcher from '../../../Utils/Searcher/Searcher'
import './UserBoard.css'

function UserBoard(){
    return(
        <div className='user-board'>
            <Board/>
            <Searcher text="events"/>
            <section className="title-tickets">
                <h2>Mis Eventos</h2>
                <section className="title-subline">.</section>
            </section>
            <BoardEvents/>
        </div>
    )
}

export default UserBoard